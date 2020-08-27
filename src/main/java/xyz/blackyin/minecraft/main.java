package xyz.blackyin.minecraft;

import com.google.gson.Gson;
import xyz.blackyin.minecraft.VersionManifest.VersionsBean;


import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

public class main {
    public static boolean load = false;  //文件更新核对sha1值功能下载没出错不用开启
    public static String mojangPath = "E:/mojang/"; // 下载路径最后要带 ：/
    public static int s = 0; //文件跳过数量值
    public static int ss = 0; //文件完成数量值
    public static int updateNumber; //文件更新数量值

    public static void main(String[] args) throws Exception {
        if (mojangPath.charAt(mojangPath.length() - 1) == '/') {
            String json = GetJson.getExecute("http://launchermeta.mojang.com/mc/game/version_manifest.json").body();
            List<VersionsBean> versions = new Gson().fromJson(json, VersionManifest.class).getVersions();
            ArrayList<ArrayList<String>> downloadListPathSha = new ArrayList<>();
            ArrayList<ArrayList<String>> downloadListHashSize = new ArrayList<>();
            ArrayList<ArrayList<String>> downloadListJsonSha = new ArrayList<>();

            for (VersionsBean version : versions) {
                String url = version.getUrl();
                String sha1 = StringUtils.substringBetween(url, "/packages/", "/");
                String str = sha1;
                String path = "v1/packages/" + str + "/" + Url.getLastString(url);
                ArrayList<String> Client = new ArrayList<>();
                Client.add(url);
                Client.add(path);
                Client.add(sha1);
                downloadListJsonSha.add(Client);
            }
            LinkedHashSet<ArrayList<String>> set5 = new LinkedHashSet<>(downloadListJsonSha);
            downloadListJsonSha = new ArrayList<>(set5);
            DownloadLists.StartDownloadPathSha1(downloadListJsonSha);

            for (int i = 0; i < downloadListJsonSha.size(); i++) {
                ArrayList<String> cache = downloadListJsonSha.get(i);
                String path = cache.get(1);
                String file = mojangPath + path;
                String jsonJson = JsonRead.readJsonFile(file);
                if (new Gson().fromJson(jsonJson, Object.class).getLogging() != null) {
                    ArrayList<String> Client = new ArrayList<>();
                    String url = new Gson().fromJson(jsonJson, Object.class).getLogging().getClient().getFile().getUrl();
                    Client.add(url);
                    String sha1 = new Gson().fromJson(jsonJson, Object.class).getLogging().getClient().getFile().getSha1();
                    Client.add("v1/objects/" + sha1 + "/" + Url.getLastString(url));
                    Client.add(sha1);
                    downloadListPathSha.add(Client);
                }
                Object.DownloadsBean downloads = new Gson().fromJson(jsonJson, Object.class).getDownloads();
                if (downloads.getClient() != null) {
                    ArrayList<String> Client = new ArrayList<>();
                    String url = downloads.getClient().getUrl();
                    Client.add(url);
                    String sha1 = downloads.getClient().getSha1();
                    Client.add("v1/objects/" + sha1 + "/" + Url.getLastString(url));
                    Client.add(sha1);
                    downloadListPathSha.add(Client);
                }
                if (downloads.getServer() != null) {
                    ArrayList<String> Client = new ArrayList<>();
                    String url = downloads.getServer().getUrl();
                    Client.add(url);
                    String sha1 = downloads.getServer().getSha1();
                    Client.add("v1/objects/" + sha1 + "/" + Url.getLastString(url));
                    Client.add(sha1);
                    downloadListPathSha.add(Client);
                }
                if (downloads.getClient_mappings() != null) {
                    ArrayList<String> Client = new ArrayList<>();
                    String url = downloads.getClient_mappings().getUrl();
                    Client.add(url);
                    String sha1 = downloads.getClient_mappings().getSha1();
                    Client.add("v1/objects/" + sha1 + "/" + Url.getLastString(url));
                    Client.add(sha1);
                    downloadListPathSha.add(Client);
                }
                if (downloads.getServer_mappings() != null) {
                    ArrayList<String> Client = new ArrayList<>();
                    String url = downloads.getServer_mappings().getUrl();
                    Client.add(url);
                    String sha1 = downloads.getServer_mappings().getSha1();
                    Client.add("v1/objects/" + sha1 + "/" + Url.getLastString(url));
                    Client.add(sha1);
                    downloadListPathSha.add(Client);
                }
            }
            LinkedHashSet<ArrayList<String>> set2 = new LinkedHashSet<>(downloadListPathSha);
            downloadListPathSha = new ArrayList<>(set2);
            downloadListJsonSha.clear();
            for (VersionsBean versionsBean : versions) {
                String cacheHome = mojangPath + "v1/packages";
                String url = versionsBean.getUrl();
                String file = cacheHome + "/" + StringUtils.substringBetween(url, "/packages/", "/") + "/" + Url.getLastString(url);
                String jsonJson = JsonRead.readJsonFile(file);
                String urlUrl = new Gson().fromJson(jsonJson, Object.class).getAssetIndex().getUrl();
                String sha1 = StringUtils.substringBetween(urlUrl, "/packages/", "/");
                String str = sha1;
                String path = "v1/packages/" + str + "/" + Url.getLastString(urlUrl);
                ArrayList<String> Client = new ArrayList<>();
                Client.add(urlUrl);
                Client.add(path);
                Client.add(sha1);
                downloadListJsonSha.add(Client);
            }
            LinkedHashSet<ArrayList<String>> set6 = new LinkedHashSet<>(downloadListJsonSha);
            downloadListJsonSha = new ArrayList<>(set6);
            for (int e = 0; e < downloadListJsonSha.size(); e++) {
                ArrayList<String> cache = downloadListJsonSha.get(e);
                String url = cache.get(0);
                String cacheHome = mojangPath + "v1/packages";
                String file = cacheHome + "/" + StringUtils.substringBetween(url, "/packages/", "/") + "/" + Url.getLastString(url);
                String jsonJson = JsonRead.readJsonFile(file);
                Hash hash1 = new Gson().fromJson(jsonJson, Hash.class);
                Map<String, Hash.HashBean> objects = hash1.getObjects();
                for (Map.Entry<String, Hash.HashBean> stringHashBeanEntry : objects.entrySet()) {
                    ArrayList<String> Client = new ArrayList<>();
                    String hash = stringHashBeanEntry.getValue().getHash();
                    int size = stringHashBeanEntry.getValue().getSize();
                    String str = String.valueOf(hash.charAt(0)) + String.valueOf(hash.charAt(1));
                    Client.add("http://resources.download.minecraft.net/" + str + "/" + hash);
                    Client.add(String.valueOf(size));
                    Client.add(str);
                    Client.add(hash);
                    downloadListHashSize.add(Client);
                }
            }
            LinkedHashSet<ArrayList<String>> set4 = new LinkedHashSet<>(downloadListHashSize);
            downloadListHashSize = new ArrayList<>(set4);
            DownloadLists.StartDownloadPathSha1(downloadListJsonSha);
            DownloadLists.StartDownloadHashSize(downloadListHashSize);
            DownloadLists.StartDownloadPathSha1(downloadListPathSha);
            System.out.println("更新了" + updateNumber + "文件");
        }else {
            System.out.println("路径最后符号不正确");
        }
    }
}