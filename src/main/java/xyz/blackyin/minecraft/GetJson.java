package xyz.blackyin.minecraft;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.io.IOException;

public class GetJson {
    private static final Logger logger = LoggerFactory.getLogger(GetJson.class);

    public static Logger getLogger() {
        return logger;
    }

    public static Connection.Response getExecute(String url) {
        try {
            Connection.Response execute = Jsoup.connect(url)
                    .ignoreContentType(true)
                    .execute();
            return execute;
        } catch (IOException e) {
            GetJson.getLogger().error("访问连接出错错误:" + e.getMessage());
        }
        return null;
    }
}
