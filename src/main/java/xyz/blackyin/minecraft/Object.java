package xyz.blackyin.minecraft;

import java.util.List;

public class Object {

    private AssetIndexBean assetIndex;
    private DownloadsBean downloads;
    private String id;
    private LoggingBean logging;
    private List<LibrariesBean> libraries;

    public AssetIndexBean getAssetIndex() {
        return assetIndex;
    }

    public void setAssetIndex(AssetIndexBean assetIndex) {
        this.assetIndex = assetIndex;
    }

    public DownloadsBean getDownloads() {
        return downloads;
    }

    public void setDownloads(DownloadsBean downloads) {
        this.downloads = downloads;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LoggingBean getLogging() {
        return logging;
    }

    public void setLogging(LoggingBean logging) {
        this.logging = logging;
    }

    public List<LibrariesBean> getLibraries() {
        return libraries;
    }

    public void setLibraries(List<LibrariesBean> libraries) {
        this.libraries = libraries;
    }

    public static class AssetIndexBean {
        private String sha1;
        private String url;

        public String getSha1() {
            return sha1;
        }

        public void setSha1(String sha1) {
            this.sha1 = sha1;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

    public static class DownloadsBean {
        private ClientBean client;
        private ClientMappingsBean client_mappings;
        private ServerBean server;
        private ServerMappingsBean server_mappings;

        public ClientBean getClient() {
            return client;
        }

        public void setClient(ClientBean client) {
            this.client = client;
        }

        public ClientMappingsBean getClient_mappings() {
            return client_mappings;
        }

        public void setClient_mappings(ClientMappingsBean client_mappings) {
            this.client_mappings = client_mappings;
        }

        public ServerBean getServer() {
            return server;
        }

        public void setServer(ServerBean server) {
            this.server = server;
        }

        public ServerMappingsBean getServer_mappings() {
            return server_mappings;
        }

        public void setServer_mappings(ServerMappingsBean server_mappings) {
            this.server_mappings = server_mappings;
        }

        public static class ClientBean {
            private String sha1;
            private String url;

            public String getSha1() {
                return sha1;
            }

            public void setSha1(String sha1) {
                this.sha1 = sha1;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }

        public static class ClientMappingsBean {
            private String sha1;
            private String url;

            public String getSha1() {
                return sha1;
            }

            public void setSha1(String sha1) {
                this.sha1 = sha1;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }

        public static class ServerBean {
            private String sha1;
            private String url;

            public String getSha1() {
                return sha1;
            }

            public void setSha1(String sha1) {
                this.sha1 = sha1;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }

        public static class ServerMappingsBean {
            private String sha1;
            private String url;

            public String getSha1() {
                return sha1;
            }

            public void setSha1(String sha1) {
                this.sha1 = sha1;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }
    }

    public static class LoggingBean {
        private ClientBean client;

        public ClientBean getClient() {
            return client;
        }

        public void setClient(ClientBean client) {
            this.client = client;
        }

        public static class ClientBean {
            private FileBean file;

            public FileBean getFile() {
                return file;
            }

            public void setFile(FileBean file) {
                this.file = file;
            }

            public static class FileBean {
                private String sha1;
                private String url;

                public String getSha1() {
                    return sha1;
                }

                public void setSha1(String sha1) {
                    this.sha1 = sha1;
                }

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }
            }
        }
    }

    public static class LibrariesBean {
        private DownloadsBean downloads;

        public DownloadsBean getDownloads() {
            return downloads;
        }

        public void setDownloads(DownloadsBean downloads) {
            this.downloads = downloads;
        }

        public static class DownloadsBean {
            private ArtifactBean artifact;

            public ArtifactBean getArtifact() {
                return artifact;
            }

            public void setArtifact(ArtifactBean artifact) {
                this.artifact = artifact;
            }

            public static class ArtifactBean {
                private String path;
                private String sha1;
                private String url;

                public String getPath() {
                    return path;
                }

                public void setPath(String path) {
                    this.path = path;
                }

                public String getSha1() {
                    return sha1;
                }

                public void setSha1(String sha1) {
                    this.sha1 = sha1;
                }

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }
            }
        }
    }
}
