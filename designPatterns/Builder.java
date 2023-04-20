public class Builder {
    Socket2 s1 = new Socket2.Builder().host("a").timeout(123).port(2).build();
    Socket2 s2 = new Socket2.Builder().timeout(12).ssl(false).host("aaa").port(235).build();
}

class Socket {
    Socket() {
    }

    Socket(String host) {
    }

    Socket(int port) {
    }

    Socket(String host, int port) {
    }

    Socket(boolean ssl) {
    }

    Socket(String host, boolean ssl) {
    }

    Socket(int port, boolean ssl) {
    }

    Socket(String host, int port, boolean ssl) {
    }
}

class Socket2 {

    int port;
    String host;
    boolean ssl;
    int timeout;

    private Socket2(Builder builder) {
        port = builder.port;
        host = builder.host;
        ssl = builder.ssl;
        timeout = builder.timeout;
    }

    public static class Builder {
        private int port = 0;
        private String host = null;
        private boolean ssl = false;
        private int timeout = 0;

        public Builder port(int port) {
            this.port = port;
            return this;
        }
        public Builder host(String host) {
            this.host = host;
            return this;
        }
        public Builder ssl(boolean ssl) {
            this.ssl = ssl;
            return this;
        }
        public Builder timeout(int timeout) {
            this.timeout = timeout;
            return this;
        }

        public Socket2 build(){
            return new Socket2(this);
        }
    }
    
}