package xyz.blackyin.minecraft.entity;

import java.util.List;

/**
 * version_manifest
 *
 * @author limbang-pc
 * @create 2020/08/28 11:15
 */

public class VersionManifest {

    private LatestBean latest;
    private List<VersionsBean> versions;

    public LatestBean getLatest() {
        return latest;
    }

    public void setLatest(LatestBean latest) {
        this.latest = latest;
    }

    public List<VersionsBean> getVersions() {
        return versions;
    }

    public void setVersions(List<VersionsBean> versions) {
        this.versions = versions;
    }

    public static class LatestBean {

        private String release;
        private String snapshot;

        public String getRelease() {
            return release;
        }

        public void setRelease(String release) {
            this.release = release;
        }

        public String getSnapshot() {
            return snapshot;
        }

        public void setSnapshot(String snapshot) {
            this.snapshot = snapshot;
        }
    }

    public static class VersionsBean {

        private String id;
        private String type;
        private String url;
        private String time;
        private String releaseTime;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getReleaseTime() {
            return releaseTime;
        }

        public void setReleaseTime(String releaseTime) {
            this.releaseTime = releaseTime;
        }
    }
}
