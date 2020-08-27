package xyz.blackyin.minecraft;

import org.apache.commons.codec.digest.DigestUtils;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class GetFile {
    public static String getSHA1(String dir, String name) {

        try (
                FileInputStream fileInputStream = new FileInputStream(dir + name)
        ) {
            String sha1 = DigestUtils.sha1Hex(fileInputStream);
            return sha1;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getSize(String dir, String name) {
        File file = new File(dir + name);
        return String.valueOf(file.length());
    }
}

