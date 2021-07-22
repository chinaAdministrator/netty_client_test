package com.example.netty_client_tset;

import com.example.netty_client_tset.netty.client.ClientHandler;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class NettyClientTsetApplicationTests {


    @Autowired
    private ClientHandler handler;
    @Test
    void contextLoads() {

    }

}
