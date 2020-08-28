package xyz.blackyin.minecraft;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import xyz.blackyin.minecraft.entity.SaveFile;
import xyz.blackyin.minecraft.utils.FileUtils;
import xyz.blackyin.minecraft.utils.ThreadUtils;

import java.io.File;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 下载文件
 *
 * @author limbang-pc
 * @create 2020/08/28 20:48
 */

public class DownloadFile {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);
    private Map<String, SaveFile> downloadList;

    public DownloadFile(Map<String, SaveFile> downloadList) {
        this.downloadList = downloadList;
    }

    /**
     * 启动下载
     *
     * @param nThreads 线程池线程数量
     */
    public void start(int nThreads) {
        ExecutorService executorService = ThreadUtils.newFixedThreadPool(nThreads);
        // 一直重试下载,直到列表为空
        while (!downloadList.isEmpty()) {
            for (Map.Entry<String, SaveFile> fileEntry : downloadList.entrySet()) {
                executorService.submit(() -> {
                    if (downloadFile(fileEntry.getKey(), fileEntry.getValue())) {
                        downloadList.remove(fileEntry.getKey());
                        logger.info("列表剩余:" + downloadList.size());
                    }
                });
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                logger.error("线程被中断...");
            }
        }
        executorService.shutdown();
        try {
            executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            logger.error("线程被中断...");
        }
    }

    /**
     * 下载文件,下载之前会判断本地是否存在,存在就校对文件sha1
     *
     * @param url
     * @param saveFile
     * @return
     */
    private boolean downloadFile(String url, SaveFile saveFile) {
        String filePath = saveFile.getDir() + saveFile.getName();
        if (new File(filePath).exists()) {
            if (FileUtils.isSha1(saveFile.getSha1(), filePath)) {
                logger.info("文件存在:" + saveFile.getName());
                return true;
            }
        }
        if (FileUtils.downloadAndSha1(url, saveFile.getDir(), saveFile.getName(), saveFile.getSha1())) {
            logger.info("下载成功:" + saveFile.getName());
            return true;
        }
        return false;
    }
}
