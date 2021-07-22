package com.example.netty_client_tset.controller;

import com.example.netty_client_tset.netty.client.ClientHandler;
import com.example.netty_client_tset.netty.client.NettyClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class TestController {

    @Autowired
    private ClientHandler handler;

    @RequestMapping(value = "/hello")
    public Object hello(){
        handler.sendMsg(new HashMap<String, String>(){{
            put("sn","35824005111111");
        }});
        return "hello";
    }
}
