package xyz.blackyin.minecraft;

import java.util.List;

public class VersionManifest {

    /**
     * id : 1.16.2
     * type : release
     * url : https://launchermeta.mojang.com/v1/packages/363cf3fef00f554a93ff3c54b189465efeb3d0bb/1.16.2.json
     * time : 2020-08-14T14:41:03+00:00
     * releaseTime : 2020-08-11T10:13:46+00:00
     */

    private List<VersionsBean> versions;

    public List<VersionsBean> getVersions() {
        return versions;
    }

    public void setVersions(List<VersionsBean> versions) {
        this.versions = versions;
    }

    public static class VersionsBean {
        private String url;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
