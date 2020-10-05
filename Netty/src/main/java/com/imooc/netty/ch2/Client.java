package com.imooc.netty.ch2;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author 闪电侠
 */
public class Client {

    //定义ip和端口（即一个Socket实例）
    private static final String HOST = "127.0.0.1";
    private static final int PORT = 8000;
    private static final int SLEEP_TIME = 5000;

    public static void main(String[] args) throws IOException {
        //定义一个socket的客户端对象
        final Socket socket = new Socket(HOST, PORT);
        //定义一个子线程，避免阻塞主线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("客户端启动成功!");
                //轮询
                while (true) {
                    try {
                        String message = "hello world";
                        System.out.println("客户端发送数据: " + message);
                        socket.getOutputStream().write(message.getBytes());
                    } catch (Exception e) {
                        System.out.println("写数据出错!");
                    }
                    sleep();
                }
            }
        }).start();
    }

    //线程暂停时间，sleep方法是属于Thread的静态方法，使用sleep方法只会释放CPU资源，不会导致锁行为的改变。sleep方法可以用来任何地方。
    //与之不同的wait方法，它是属于Object的方法，每个对象都会继承该方法，它在使用的过程中不仅会释放CPU资源，还会释放线程所占用的同步锁，wait方法只能使用在synchronized同步代码块中或者synchronized同步方法中。
    private static void sleep() {
        try {
            Thread.sleep(SLEEP_TIME);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
