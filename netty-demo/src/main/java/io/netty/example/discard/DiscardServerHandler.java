package io.netty.example.discard;

import io.netty.channel.ChannelHandlerAdapter;

public class DiscardServerHandler extends ChannelHandlerAdapter {

    // @Override
    // public void channelRead(ChannelHandlerContext ctx, Object msg) {
    //     ctx.writeAndFlush(msg);
    // }
    //
    // @Override
    // public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
    //     // Close the connection when an exception is raised.
    //     cause.printStackTrace();
    //     ctx.close();
    // }
}
