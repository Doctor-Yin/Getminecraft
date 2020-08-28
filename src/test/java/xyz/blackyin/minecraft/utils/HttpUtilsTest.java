package xyz.blackyin.minecraft.utils;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by limbang-pc on 2020/8/28.
 */
public class HttpUtilsTest {

    @Test
    public void get() {
        String url = "https://launchermeta.mojang.com/mc/game/version_manifest.json";
        assertEquals(true,HttpUtils.getString(url) != null);
    }
}