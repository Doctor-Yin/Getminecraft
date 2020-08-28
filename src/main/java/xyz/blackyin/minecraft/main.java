package xyz.blackyin.minecraft;


import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import xyz.blackyin.minecraft.entity.SaveFile;
import xyz.blackyin.minecraft.entity.Version;
import xyz.blackyin.minecraft.entity.VersionManifest;
import xyz.blackyin.minecraft.utils.FileUtils;
import xyz.blackyin.minecraft.utils.HttpUtils;
import xyz.blackyin.minecraft.utils.ThreadUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/**
 * @author limbang-pc
 * @create 2020/08/28 11:01
 */

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    private String mojangUrl = "https://launchermeta.mojang.com";
    private String librariesUrl = "https://libraries.minecraft.net";
    private String launcherUrl = "https://launcher.mojang.com";
    private String baseDir = "C:/mc/test";

    public Main() {
        List<VersionManifest.VersionsBean> versions = getVersionManifest().getVersions();
        Map<String, SaveFile> downloadList = new HashMap<>();

        for (VersionManifest.VersionsBean version : versions) {
            // 添加 VersionManifest 的所有 json 到下载列表
            downloadList.put(version.getUrl(), splitUrl(version.getUrl(), mojangUrl));

            Version version1 = getVersion(version.getUrl());

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
        ExecutorService executorService = ThreadUtils.newFixedThreadPool(10);
        List<Future> futureList = new ArrayList<>();

        logger.info("待下载总数:" + downloadList.size());
        for (Map.Entry<String, SaveFile> entry : downloadList.entrySet()) {
            Future future = executorService.submit(() -> {
                if (entry.getValue().getSize() == 0) {
                    if (FileUtils.download(entry.getKey(),
                            entry.getValue().getDir(),
                            entry.getValue().getName())) {
                        logger.info("下载成功:" + entry.getValue().getName());
                    } else {
                        logger.error("下载失败:" + entry.getValue().getName());
                    }
                } else {
                    if (FileUtils.downloadAndSha1(entry.getKey(),
                            entry.getValue().getDir(),
                            entry.getValue().getName(),
                            entry.getValue().getSha1(),
                            entry.getValue().getSize())) {
                        logger.info("下载成功:" + entry.getValue().getName());
                    } else {
                        logger.error("下载失败:" + entry.getValue().getName());
                    }
                }
            });
            futureList.add(future);
        }

        for (Future future : futureList) {
            try {
                System.out.println(future.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
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

    /**
     * 获取 VersionManifest
     *
     * @return
     */
    private VersionManifest getVersionManifest() {
        // 请求 version_manifest 并转换为实体
        String url = mojangUrl + "/mc/game/version_manifest.json";
        String json = HttpUtils.getString(url);
        return new Gson().fromJson(json, VersionManifest.class);
    }

    private Version getVersion(String url) {
        // 请求 url 并转换为实体
        String json = HttpUtils.getString(url);
        return new Gson().fromJson(json, Version.class);
    }

}
