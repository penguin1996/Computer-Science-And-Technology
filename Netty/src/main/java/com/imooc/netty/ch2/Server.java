package com.imooc.netty.ch2;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/*
* while(true)
* for(;;)
* 两者等价
* */
public class Server {

    private ServerSocket serverSocket;

    //绑定端口
    public Server(int port) {
        try {
            this.serverSocket = new ServerSocket(port);
            System.out.println("服务端启动成功，端口:" + port);
        } catch (IOException exception) {
            System.out.println("服务端启动失败");
        }
    }

    public void start() {
        //不希望创建Server对象的线程阻塞ServerBoot的主线程，所以创建一个子线程来进行处理端口监听
        new Thread(new Runnable() {
            @Override
            public void run() {
                //doStart方法去实际的接收客户端的连接
                doStart();
            }
        }).start();
    }

    private void doStart() {
        while (true) {//服务端通过阻塞的方式不断监听新用户的连接
            try {
                //客户端的创建(待深入理解)
                Socket client = serverSocket.accept();
                //匿名内部类，生命周期仅在当前语句有效。
                new ClientHandler(client).start();
            } catch (IOException e) {
                System.out.println("服务端异常");
            }
        }
    }
}

