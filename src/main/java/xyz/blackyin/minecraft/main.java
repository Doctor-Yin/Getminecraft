package xyz.blackyin.minecraft;


import xyz.blackyin.minecraft.entity.SaveFile;
import xyz.blackyin.minecraft.entity.Version;
import xyz.blackyin.minecraft.entity.VersionManifest;
import xyz.blackyin.minecraft.utils.GsonUtils;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author limbang-pc
 * @create 2020/08/28 11:01
 */

public class Main {

    private String mojangUrl = "https://launchermeta.mojang.com";
    private String librariesUrl = "https://libraries.minecraft.net";
    private String launcherUrl = "https://launcher.mojang.com";
    private String baseDir = "C:/mc/mojang";

    public Main() {
        String versionManifestUrl = mojangUrl + "/mc/game/version_manifest.json";
        List<VersionManifest.VersionsBean> versions = GsonUtils.fromUrl(versionManifestUrl, VersionManifest.class).getVersions();
        Map<String, SaveFile> downloadList = new ConcurrentHashMap<>();

        for (VersionManifest.VersionsBean version : versions) {
            // 添加 VersionManifest 的所有 json 到下载列表
            SaveFile saveFile = splitUrl(version.getUrl(), mojangUrl);
            saveFile.setSha1(splitSha1(saveFile.getDir()));
            downloadList.put(version.getUrl(), saveFile);

            Version version1 = GsonUtils.fromUrl(version.getUrl(), Version.class);

            // 添加 assetIndex 到下载列表
            SaveFile assetIndexFile = splitUrl(version1.getAssetIndex().getUrl(), mojangUrl);
            assetIndexFile.setSha1(version1.getAssetIndex().getSha1());
            assetIndexFile.setSize(version1.getAssetIndex().getSize());
            downloadList.put(version1.getAssetIndex().getUrl(), assetIndexFile);

            // 添加 logging 到下载列表
            SaveFile loggingFile = splitUrl(version1.getLogging().getClient().getFile().getUrl(), launcherUrl);
            loggingFile.setSha1(version1.getLogging().getClient().getFile().getSha1());
            loggingFile.setSize(version1.getLogging().getClient().getFile().getSize());
            downloadList.put(version1.getLogging().getClient().getFile().getUrl(), loggingFile);

            // 添加 downloads 到下载列表
            Map<String, Version.DownloadsBean> downloads = version1.getDownloads();
            for (Map.Entry<String, Version.DownloadsBean> entry : downloads.entrySet()) {
                SaveFile downloadFile = splitUrl(entry.getValue().getUrl(), launcherUrl);
                downloadFile.setSize(entry.getValue().getSize());
                downloadFile.setSha1(entry.getValue().getSha1());
                downloadList.put(entry.getValue().getUrl(), downloadFile);
            }

            // 添加 libraries 到下载列表
            List<Version.LibrariesBean> libraries = version1.getLibraries();
            for (Version.LibrariesBean librarie : libraries) {
                String url = librarie.getDownloads().getArtifact().getUrl();
                SaveFile librarieFile = splitUrl(url, librariesUrl);
                librarieFile.setSha1(librarie.getDownloads().getArtifact().getSha1());
                librarieFile.setSize(librarie.getDownloads().getArtifact().getSize());
                downloadList.put(url, librarieFile);
            }

            // 跳出循环,测试用
            break;
        }

        new DownloadFile(downloadList).start(10);
    }

    private String splitSha1(String dir) {
        int i = dir.substring(0, dir.length() - 1).lastIndexOf("/") + 1;
        return dir.substring(i,dir.length() - 1);
    }

    /**
     * 拆分 url
     *
     * @param url
     * @param baseUrl
     * @return
     */
    private SaveFile splitUrl(String url, String baseUrl) {
        String tem = url.replace(baseUrl, "");
        int pos = tem.lastIndexOf("/") + 1;
        SaveFile file = new SaveFile();
        file.setDir(baseDir + tem.substring(0, pos));
        file.setName(tem.substring(pos));
        return file;
    }


}
