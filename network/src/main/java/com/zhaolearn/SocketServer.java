package com.zhaolearn;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * SocketServer服务端，这里模拟求圆的面积
 *
 * @author: HeHaoZhao
 * @date: 2019/2/25 15:01
 */
public class SocketServer {
    public static void main(String[] args) throws IOException {
        // 在端口上创建一个服务器套接字
        ServerSocket serverSocket = new ServerSocket(8080);
        // 监听来自客户端的连接
        Socket socket = serverSocket.accept();
        //用于接收客户端发送来数据
        DataInputStream dis = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
        //用于向客户端发送数据
        DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
        do {
            double radius = dis.readDouble();
            System.out.println("服务器端收到数据：" + radius);
            double result = Math.PI * radius * radius;
            dos.writeDouble(result);
            //清空
            dos.flush();
        } while (dis.readInt() != 0);
        //关闭
        socket.close();
        serverSocket.close();
    }
}
