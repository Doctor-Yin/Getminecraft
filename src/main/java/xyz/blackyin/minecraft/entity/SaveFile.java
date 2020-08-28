package xyz.blackyin.minecraft.entity;

/**
 * @author limbang-pc
 * @create 2020/08/28 12:09
 */

public class SaveFile {
    private String dir;
    private String name;
    private String sha1;
    private long size;

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSha1() {
        return sha1;
    }

    public void setSha1(String sha1) {
        this.sha1 = sha1;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "SaveFile{" +
                "dir='" + dir + '\'' +
                ", name='" + name + '\'' +
                ", sha1='" + sha1 + '\'' +
                ", size=" + size +
                '}';
    }
}
