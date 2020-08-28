package xyz.blackyin.minecraft.utils;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


/**
 * Created by limbang-pc on 2020/8/28.
 */
public class FileUtilsTest {

    @Test
    public void download() {
        String url = "https://libraries.minecraft.net/com/mojang/patchy/1.1/patchy-1.1.jar";
        String saveDir = "C:/mc/test";
        String fileName = "patchy-1.1.jar";
        assertEquals(true,FileUtils.download(url,saveDir,fileName));
    }

    @Test
    public void isSize(){
        String filePath = "C:\\mc\\test\\patchy-1.1.jar";
        long size = 15817;
        assertEquals(true,FileUtils.isSize(size,filePath));
    }

    @Test
    public void isSha1(){
        String filePath = "C:\\mc\\test\\patchy-1.1.jar";
        String sha1 = "aef610b34a1be37fa851825f12372b78424d8903";
        assertEquals(true,FileUtils.isSha1(sha1,filePath));
    }
}