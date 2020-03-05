package com.zhaolearn.bio;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 1    ​BIO编程流程
 * 1.1    ​服务器端启动一个ServerSocket
 * 1.2    ​客户端启动Socket对服务器进行通信，默认情况下服务器端需要对每个客户 建立一个线程与之通讯
 * 1.3    ​客户端发出请求后, 先咨询服务器是否有线程响应，如果没有则会等待，或者被拒绝
 * 1.4    ​如果有响应，客户端线程会等待请求结束后，在继续执行
 *
 *2     说明：
 *     ​1~3行，是开启了服务端；
 *     ​4~9行，是有一个客户端连接后，服务端分配一个线程等待，id和名字分别如图所示，即到read....这一步。
 *     ​10~12行，是第一个客户端发送了信息后，服务端接收了信息，并重新阻塞，等待客户端发送新的数据。
 *     ​13~21行，后面红色部分是第二个客户端重复动作产生的。
 * ​从结果可以看出
 *     ​第一个与第二个客户端连接，服务端的确创建了两个不同的线程
 *     ​read....证明客户端连接服务端，服务端接收了信息后，会重新阻塞
 *
 *
 *
 *
 */
public class BIODemo {
    public static void main(String[] args) throws Exception {
        //思路
        //1. 创建一个线程池
        //2. 如果有客户端连接，就创建一个线程，与之通讯(单独写一个方法)
        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
        //创建ServerSocket，监听本机的6666端口
        ServerSocket serverSocket = new ServerSocket(6666);
        System.out.println("服务器启动了");
        while (true) {
            System.out.println("主线程线程信息 id =" + Thread.currentThread().getId() + " 名字=" + Thread.currentThread().getName());
            //监听，等待客户端连接
            System.out.println("等待连接....");
            final Socket socket = serverSocket.accept();
            System.out.println("一个客户端已连接");
            //就创建一个线程，与之通讯(单独写一个方法)
            newCachedThreadPool.execute(new Runnable() {
                public void run() { //我们重写
                    //可以和客户端通讯
                    handler(socket);
                }
            });
        }
    }

    //编写一个handler方法，和客户端通讯
    public static void handler(Socket socket) {
        try {
            System.out.println("处理客户端的线程信息 id =" + Thread.currentThread().getId() + " 名字=" + Thread.currentThread().getName());
            byte[] bytes = new byte[1024];
            //通过socket 获取输入流
            InputStream inputStream = socket.getInputStream();
            //循环的读取客户端发送的数据
            while (true) {
                System.out.println("处理客户端的线程信息 id =" + Thread.currentThread().getId() + " 名字=" + Thread.currentThread().getName());
                System.out.println("read....");
                int read =  inputStream.read(bytes);
                if(read != -1) {
                    System.out.println(new String(bytes, 0, read
                    )); //输出客户端发送的数据
                } else {
                    break;
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            System.out.println("关闭和client的连接");
            try {
                socket.close();
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
