package xyz.blackyin.minecraft.utils;


import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 * 文件工具类
 *
 * @author limbang-pc
 * @create 2020/08/28 9:21
 */

public class FileUtils {

    private static final Logger logger = LoggerFactory.getLogger(FileUtils.class);

    /**
     * 下载文件
     *
     * @param url      url
     * @param saveDir  保存的目录
     * @param fileName 文件名称
     * @return
     */
    public static boolean download(String url, String saveDir, String fileName) {
        try (InputStream ins = new URL(url).openStream()) {
            Path target = Paths.get(saveDir, fileName);
            Files.createDirectories(target.getParent());
            Files.copy(ins, target, StandardCopyOption.REPLACE_EXISTING);
            return true;
        } catch (IOException e) {
            logger.error("文件下载失败!!!");
        }
        return false;
    }

    /**
     * sha1校验
     *
     * @param sha1     sha1值
     * @param filePath 需要校验的文件路径
     * @return
     */
    public static boolean isSha1(String sha1, String filePath) {
        try (FileInputStream fileInputStream = new FileInputStream(filePath)) {
            return DigestUtils.sha1Hex(fileInputStream).equals(sha1);
        } catch (IOException e) {
            logger.error("读取数据失败!!!");
        }
        return false;
    }

    /**
     * 校验文件大小
     *
     * @param size  正确文件大小
     * @param filePath 需要校验文件路径
     * @return
     */
    public static boolean isSize(long size, String filePath){
        return new File(filePath).length() == size;
    }

    /**
     * 下载并校验 sha1
     *
     * @param url       url
     * @param saveDir   保存的目录
     * @param fileName  文件名称
     * @param sha1      sha1值
     * @return
     */
    public static boolean downloadAndSha1(String url, String saveDir, String fileName, String sha1) {
        if (download(url, saveDir, fileName)) {
            if(isSha1(sha1, saveDir + fileName)){
                return true;
            }
        }
        return false;
    }

    /**
     * 下载并校验 sha1,并对比大小
     *
     * @param url       url
     * @param saveDir   保存的目录
     * @param fileName  文件名称
     * @param sha1      sha1值
     * @param size      正确文件大小
     * @return
     */
    public static boolean downloadAndSha1(String url, String saveDir, String fileName, String sha1,long size) {
        if(downloadAndSha1(url,saveDir,fileName,sha1) && isSize(size,saveDir + fileName)){
            return true;
        }
        return false;
    }
}
