package com.zhaolearn.manyclient;

import java.io.*;
import java.net.Socket;

public class SingleServer implements Runnable {
    private Socket socket;
    private String clientNo;

    public SingleServer(Socket socket, String clientNo) {
        this.socket = socket;
        this.clientNo = clientNo;
    }
    @Override
    public void run() {
        try {
            DataInputStream dis = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
            DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
            do {
                double radius = dis.readDouble();
                System.out.println("客户端：" + clientNo + " 接收到的半径为：" + radius);
                double result = Math.PI * radius * radius;
                dos.writeDouble(result);
                dos.flush();
            } while (dis.readInt() != 0);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("与客户端" + clientNo + "通信结束");
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
