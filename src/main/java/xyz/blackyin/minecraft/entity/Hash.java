package xyz.blackyin.minecraft.entity;

import java.util.Map;

public class Hash {
    private Map<String,HashBean> objects;

    public Map<String, HashBean> getObjects() {
        return objects;
    }

    public void setObjects(Map<String, HashBean> objects) {
        this.objects = objects;
    }

    public static class HashBean {
        private String hash;
        private int size;

        public String getHash() {
            return hash;
        }

        public void setHash(String hash) {
            this.hash = hash;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }
    }
}