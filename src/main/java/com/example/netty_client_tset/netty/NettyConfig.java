package com.example.netty_client_tset.netty;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "netty")
public class NettyConfig {
    private String host;
    private int port;
    private int bossThread;
    private int workerThread;
    private boolean keepalive;
    private int backlog;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public int getBossThread() {
        return bossThread;
    }

    public void setBossThread(int bossThread) {
        this.bossThread = bossThread;
    }

    public int getWorkerThread() {
        return workerThread;
    }

    public void setWorkerThread(int workerThread) {
        this.workerThread = workerThread;
    }

    public boolean isKeepalive() {
        return keepalive;
    }

    public void setKeepalive(boolean keepalive) {
        this.keepalive = keepalive;
    }

    public int getBacklog() {
        return backlog;
    }

    public void setBacklog(int backlog) {
        this.backlog = backlog;
    }


    @Override
    public String toString() {
        return "NettyConfig{" +
                "host='" + host + '\'' +
                ", port=" + port +
                ", bossThread=" + bossThread +
                ", workerThread=" + workerThread +
                ", keepalive=" + keepalive +
                ", backlog=" + backlog +
                '}';
    }
}
