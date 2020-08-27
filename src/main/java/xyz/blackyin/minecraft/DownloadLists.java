package xyz.blackyin.minecraft;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class DownloadLists {


    public static void StartDownloadPathSha1(ArrayList<ArrayList<String>> String) throws IOException, InterruptedException {
        for (int a = 0; a < String.size(); a++) {
            ArrayList<String> urlPathSha1 = String.get(a);
            String url = urlPathSha1.get(0);
            String path = urlPathSha1.get(1);
            String sha1 = urlPathSha1.get(2);
            path = main.mojangPath + path;
            File file = new File(path);
            File home = new File(path.replace(Url.getLastString(url), ""));
            System.out.print("开始下载：");
            System.out.println(path);
            if (!home.exists()) {
                home.mkdirs();
            }
            if (!file.exists()) {
                GetDownload.downloadHttpUrl(url, file);
            } else if (main.load){
                    System.out.println("发现同名文件");
                    System.out.println("读取本地文件sha1中....");
                    String fileSha1 = GetFile.getSHA1(home + "/", Url.getLastString(url));
                    System.out.println("读取完成，核对ing....");

                if (!fileSha1.equals(sha1)) {
                    System.out.println("更新文件ing...");
                    ++main.updateNumber;
                    file.delete();
                    GetDownload.downloadHttpUrl(url, file);
                } else {
                    System.out.println("跳过" + ++main.s);
                }
            }else {
                System.out.println("跳过" + ++main.s);
            }
            System.out.println("完成" + ++main.ss);
        }
    }

    public static void StartDownloadHashSize(ArrayList<ArrayList<String>> String) throws IOException, InterruptedException {
        for (int a = 0; a < String.size(); a++) {
            ArrayList<String> urlHashSize = String.get(a);
            String url = urlHashSize.get(0);
            String size = urlHashSize.get(1);
            String path = urlHashSize.get(2);
            String name = urlHashSize.get(3);
            path = main.mojangPath + "assets/" + path;
            File file = new File(path + "/" + name);
            System.out.print("开始下载：");
            System.out.println(file);
            File home = new File(path);
            if (!home.exists()) {
                home.mkdirs();
            }
            if (!file.exists()) {
                GetDownload.downloadHttpUrl(url, file);
            } else {
                System.out.println("发现同名文件");
                System.out.println("读取本地文件长度中....");
                String fileSize = GetFile.getSize(home + "/", name);
                System.out.println("读取完成，核对ing....");

                if (!fileSize.equals(size)) {
                    System.out.println("更新文件ing...");
                    ++main.updateNumber;
                    file.delete();
                    GetDownload.downloadHttpUrl(url, file);
                } else {
                    System.out.println("跳过" + ++main.s);
                }
            }
            System.out.println("完成" + ++main.ss);
        }
    }
}
