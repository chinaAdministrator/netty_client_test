package com.example.netty_client_tset.netty.client;

import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.util.concurrent.EventExecutorGroup;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ClientHandler extends ChannelInboundHandlerAdapter {

    private Channel channel;

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        super.channelRead(ctx, msg);
        System.out.println("接收到了客户端的消息是:" + msg);
    }

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        channel = ctx.channel();
        System.out.println("服务器连接，连接的channel的短ID是：" + ctx.channel());
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        channel = null;
        System.out.println("服务器断开，当前被移除的channel的短ID是：" + ctx.channel());
    }

    public void sendMsg(Object msg) {
        if (channel != null) {
            channel.writeAndFlush(Unpooled.copiedBuffer((msg + System.getProperty("line.separaotr")).getBytes()));

        }
    }
}
