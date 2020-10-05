package com.imooc.netty.ch2;

import io.netty.channel.nio.NioEventLoop;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class ClientHandler {

    public static final int MAX_DATA_LEN = 1024;
    private final Socket socket;
    //保存客户端的Socket
    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    //对于每个客户端都会创建一个线程
    public void start() {
        System.out.println("新客户端接入");
        new Thread(new Runnable() {
            @Override
            public void run() {
                doStart();
                //NioEventLoop nioEventLoop;
            }
        }).start();
    }

    //如果不对每个客户端创建一个线程的时候，客户端会造成Server中的doStart方法中的while(ture)的阻塞
    private void doStart() {
        try {
            InputStream inputStream = socket.getInputStream();
            while (true) {//监听连接是否存在数据的读写（NioEventLoop:Nio事件的循环）
                /*
                * 1.新连接的一个接入
                * 2.连接当前存在的连接上数据流的读写
                * 监听到的一个用户的连接在底层是（IO模型中）作为一个Socket进行处理
                * 监听到的一个用户的连接在底层（NIO模型中）是一个SocketChannel
                * Netty统一将其封装成一个自定义的Channel，基于该Channel一系列的读写都可以进行操作
                * */
                byte[] data = new byte[MAX_DATA_LEN];
                int len;
                while ((len = inputStream.read(data)) != -1) {
                    String message = new String(data, 0, len);
                    System.out.println("客户端传来消息: " + message);
                    socket.getOutputStream().write(data);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
