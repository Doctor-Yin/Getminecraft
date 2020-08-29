package xyz.blackyin.minecraft.utils;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * @author limbang-pc
 * @create 2020/08/29 11:47
 */

public class ExceptionUtils {

    public static String getExceptionInfo(Exception e) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        e.printStackTrace(new PrintStream(baos));
        return baos.toString();
    }
}