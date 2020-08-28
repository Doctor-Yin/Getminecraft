package xyz.blackyin.minecraft.utils;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * http工具类
 *
 * @author limbang-pc
 * @create 2020/08/28 11:29
 */

public class HttpUtils {
    private static final Logger logger = LoggerFactory.getLogger(HttpUtils.class);
    private static OkHttpClient client = new OkHttpClient().newBuilder().build();

    public static String getString(String url) {
        Request request = new Request.Builder()
                .url(url)
                .method("GET", null)
                .build();
        try {
            Response response = client.newCall(request).execute();
            return response.body().string();
        } catch (IOException e) {
            logger.error("IO 错误,GET[" + url + "]失败");
        }
        return null;
    }
}
