package xyz.blackyin.minecraft.utils;

import com.google.gson.Gson;

/**
 * gson 工具类
 *
 * @author limbang-pc
 * @create 2020/08/28 20:00
 */

public class GsonUtils {

    public static <T> T fromUrl(String url,Class<T> tClass){
        String json = HttpUtils.getString(url);
        return new Gson().fromJson(json, tClass);
    }
}
