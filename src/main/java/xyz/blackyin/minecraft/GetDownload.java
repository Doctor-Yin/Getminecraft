package xyz.blackyin.minecraft;

import org.apache.commons.io.FileUtils;


import java.io.File;
import java.net.URL;

public class GetDownload {
    public static void downloadHttpUrl(String url, File dir) {
        try {
            URL httpurl = new URL(url);
            FileUtils.copyURLToFile(httpurl, dir);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }



}
