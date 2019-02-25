package com.zhaolearn;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * SocketClient客户端，这里请求服务端
 *
 * @author: HeHaoZhao
 * @date: 2019/2/25 15:01
 */
public class SocketClient {
    public static void main(String[] args) throws IOException {
        // 创建一个套接字并将其连接到指定IP与端口号
        Socket socket = new Socket("127.0.0.1", 8080);
        DataInputStream dis = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
        DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            System.out.println("请输入圆的半径:");
            double length = sc.nextDouble();
            dos.writeDouble(length);
            dos.flush();
            double area = dis.readDouble();
            System.out.println("服务器计算的面积为:" + area);
            while (true) {
                System.out.println("是否继续计算？(Y/N)");
                String str = sc.next();
                if (str.equalsIgnoreCase("N")) {
                    dos.writeInt(0);
                    dos.flush();
                    flag = false;
                    break;
                } else if (str.equalsIgnoreCase("Y")) {
                    dos.writeInt(1);
                    dos.flush();
                    break;
                }
            }
        }
        //关闭
        socket.close();
    }
}
