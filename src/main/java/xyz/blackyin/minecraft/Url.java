package xyz.blackyin.minecraft;

import java.net.MalformedURLException;
import java.net.URL;

public class Url {
    public static String getLastString(String str) {
        URL url;
        try {
            url = new URL(str);
        } catch (MalformedURLException e) {
            return null;
        }

        String file = url.getFile();
        String[] splitStr = file.split("/");
        int len = splitStr.length;
        String result = splitStr[len-1];
        return result;
    }

}
