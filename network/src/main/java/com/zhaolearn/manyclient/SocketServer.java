package com.zhaolearn.manyclient;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * SocketServer服务端，这里模拟求圆的面积(改进版本，可以接受多个Client)
 *
 * @author: HeHaoZhao
 * @date: 2019-2-25 15:18:58
 */
public class SocketServer {
    public static void main(String[] args) throws IOException {
        System.out.println("服务器启动完毕，等待数据传入");
        // 在端口上创建一个服务器套接字
        ServerSocket serverSocket = new ServerSocket(8080);
        // 创建线程池
        ExecutorService exec = Executors.newCachedThreadPool();
        try {
            while (true) {
                Socket socket = serverSocket.accept();
                String clientNo=UUID.randomUUID().toString();
                exec.execute(new SingleServer(socket, clientNo));
            }
        } finally {
            serverSocket.close();
        }
    }
}
