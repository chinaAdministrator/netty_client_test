package com.example.netty_client_tset;

import com.example.netty_client_tset.netty.client.NettyClient;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@MapperScan(basePackages = "com.example.netty_client_test.mapper")
@EnableAsync
public class NettyClientTsetApplication implements CommandLineRunner {
    @Autowired
    private NettyClient nettyClient;

    public static void main(String[] args) {
        SpringApplication.run(NettyClientTsetApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        nettyClient.start();
    }
}
