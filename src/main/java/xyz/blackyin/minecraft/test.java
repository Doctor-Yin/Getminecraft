package xyz.blackyin.minecraft;

public class test {
    public static void main(String[] args) {
        String url = "https://libraries.minecraft.net/com/mojang/patchy/1.1/patchy-1.1.jar";
        String path = "com/mojang/patchy/1.1/patchy-1.1.jar";
        path = "E:/mojang/libraries/"+ path;
        System.out.println("/" + path.replace(Url.getLastString(url), ""));
    }
}
