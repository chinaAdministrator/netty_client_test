package com.example.netty_client_tset.netty.client;

import com.example.netty_client_tset.netty.NettyConfig;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class NettyClient {

    @Autowired
    private NettyConfig nettyConfig;

    @Autowired
    private ClientChannelInitializer clientChannelInitializer;

    @Async
    public void start() throws Exception{
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try {
            Bootstrap b = new Bootstrap(); // (1)
            b.group(workerGroup); // (2)
            b.channel(NioSocketChannel.class); // (3)
            b.option(ChannelOption.SO_KEEPALIVE, true); // (4)
            b.handler(clientChannelInitializer);

            // Start the client.
            ChannelFuture channelFuture = b.connect(nettyConfig.getHost(), nettyConfig.getPort()).sync(); // (5)
            // Wait until the connection is closed.
            channelFuture.channel().closeFuture().sync();
        } finally {
            workerGroup.shutdownGracefully();
        }
    }
}
