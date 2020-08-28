package xyz.blackyin.minecraft.entity;

import java.util.List;
import java.util.Map;

/**
 * @author limbang-pc
 * @create 2020/08/28 12:56
 */

public class Version {

    private AssetIndexBean assetIndex;
    private Map<String,DownloadsBean> downloads;
    private LoggingBean logging;
    private List<LibrariesBean> libraries;


    public AssetIndexBean getAssetIndex() {
        return assetIndex;
    }

    public void setAssetIndex(AssetIndexBean assetIndex) {
        this.assetIndex = assetIndex;
    }


    public Map<String,DownloadsBean> getDownloads() {
        return downloads;
    }

    public void setDownloads(Map<String,DownloadsBean> downloads) {
        this.downloads = downloads;
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
        /**
         * id : 1.16
         * sha1 : bdb68de96a44ec1e9ed6d9cfcd2ee973be618c3a
         * size : 295417
         * totalSize : 329202599
         * url : https://launchermeta.mojang.com/v1/packages/bdb68de96a44ec1e9ed6d9cfcd2ee973be618c3a/1.16.json
         */

        private String id;
        private String sha1;
        private int size;
        private int totalSize;
        private String url;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getSha1() {
            return sha1;
        }

        public void setSha1(String sha1) {
            this.sha1 = sha1;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public int getTotalSize() {
            return totalSize;
        }

        public void setTotalSize(int totalSize) {
            this.totalSize = totalSize;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }



    public static class DownloadsBean {
            /**
             * sha1 : 653e97a2d1d76f87653f02242d243cdee48a5144
             * size : 17505439
             * url : https://launcher.mojang.com/v1/objects/653e97a2d1d76f87653f02242d243cdee48a5144/client.jar
             */

            private String sha1;
            private int size;
            private String url;

            public String getSha1() {
                return sha1;
            }

            public void setSha1(String sha1) {
                this.sha1 = sha1;
            }

            public int getSize() {
                return size;
            }

            public void setSize(int size) {
                this.size = size;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }


    public static class LoggingBean {
        /**
         * client : {"argument":"-Dlog4j.configurationFile=${path}","file":{"id":"client-1.12.xml","sha1":"ef4f57b922df243d0cef096efe808c72db042149","size":877,"url":"https://launcher.mojang.com/v1/objects/ef4f57b922df243d0cef096efe808c72db042149/client-1.12.xml"},"type":"log4j2-xml"}
         */

        private ClientBeanX client;

        public ClientBeanX getClient() {
            return client;
        }

        public void setClient(ClientBeanX client) {
            this.client = client;
        }

        public static class ClientBeanX {
            /**
             * argument : -Dlog4j.configurationFile=${path}
             * file : {"id":"client-1.12.xml","sha1":"ef4f57b922df243d0cef096efe808c72db042149","size":877,"url":"https://launcher.mojang.com/v1/objects/ef4f57b922df243d0cef096efe808c72db042149/client-1.12.xml"}
             * type : log4j2-xml
             */

            private String argument;
            private FileBean file;
            private String type;

            public String getArgument() {
                return argument;
            }

            public void setArgument(String argument) {
                this.argument = argument;
            }

            public FileBean getFile() {
                return file;
            }

            public void setFile(FileBean file) {
                this.file = file;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public static class FileBean {
                /**
                 * id : client-1.12.xml
                 * sha1 : ef4f57b922df243d0cef096efe808c72db042149
                 * size : 877
                 * url : https://launcher.mojang.com/v1/objects/ef4f57b922df243d0cef096efe808c72db042149/client-1.12.xml
                 */

                private String id;
                private String sha1;
                private int size;
                private String url;

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public String getSha1() {
                    return sha1;
                }

                public void setSha1(String sha1) {
                    this.sha1 = sha1;
                }

                public int getSize() {
                    return size;
                }

                public void setSize(int size) {
                    this.size = size;
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
        /**
         * downloads : {"artifact":{"path":"com/mojang/patchy/1.1/patchy-1.1.jar","sha1":"aef610b34a1be37fa851825f12372b78424d8903","size":15817,"url":"https://libraries.minecraft.net/com/mojang/patchy/1.1/patchy-1.1.jar"}}
         * name : com.mojang:patchy:1.1
         * rules : [{"action":"allow","os":{"name":"osx"}}]
         * natives : {"osx":"natives-macos"}
         * extract : {"exclude":["META-INF/"]}
         */

        private DownloadsBeanX downloads;
        private String name;
        private NativesBean natives;
        private ExtractBean extract;
        private List<RulesBeanX> rules;

        public DownloadsBeanX getDownloads() {
            return downloads;
        }

        public void setDownloads(DownloadsBeanX downloads) {
            this.downloads = downloads;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public NativesBean getNatives() {
            return natives;
        }

        public void setNatives(NativesBean natives) {
            this.natives = natives;
        }

        public ExtractBean getExtract() {
            return extract;
        }

        public void setExtract(ExtractBean extract) {
            this.extract = extract;
        }

        public List<RulesBeanX> getRules() {
            return rules;
        }

        public void setRules(List<RulesBeanX> rules) {
            this.rules = rules;
        }

        public static class DownloadsBeanX {
            /**
             * artifact : {"path":"com/mojang/patchy/1.1/patchy-1.1.jar","sha1":"aef610b34a1be37fa851825f12372b78424d8903","size":15817,"url":"https://libraries.minecraft.net/com/mojang/patchy/1.1/patchy-1.1.jar"}
             */

            private ArtifactBean artifact;

            public ArtifactBean getArtifact() {
                return artifact;
            }

            public void setArtifact(ArtifactBean artifact) {
                this.artifact = artifact;
            }

            public static class ArtifactBean {
                /**
                 * path : com/mojang/patchy/1.1/patchy-1.1.jar
                 * sha1 : aef610b34a1be37fa851825f12372b78424d8903
                 * size : 15817
                 * url : https://libraries.minecraft.net/com/mojang/patchy/1.1/patchy-1.1.jar
                 */

                private String path;
                private String sha1;
                private int size;
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

                public int getSize() {
                    return size;
                }

                public void setSize(int size) {
                    this.size = size;
                }

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }
            }
        }

        public static class NativesBean {
            /**
             * osx : natives-macos
             */

            private String osx;

            public String getOsx() {
                return osx;
            }

            public void setOsx(String osx) {
                this.osx = osx;
            }
        }

        public static class ExtractBean {
            private List<String> exclude;

            public List<String> getExclude() {
                return exclude;
            }

            public void setExclude(List<String> exclude) {
                this.exclude = exclude;
            }
        }

        public static class RulesBeanX {
            /**
             * action : allow
             * os : {"name":"osx"}
             */

            private String action;
            private OsBeanX os;

            public String getAction() {
                return action;
            }

            public void setAction(String action) {
                this.action = action;
            }

            public OsBeanX getOs() {
                return os;
            }

            public void setOs(OsBeanX os) {
                this.os = os;
            }

            public static class OsBeanX {
                /**
                 * name : osx
                 */

                private String name;

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }
            }
        }
    }
}
