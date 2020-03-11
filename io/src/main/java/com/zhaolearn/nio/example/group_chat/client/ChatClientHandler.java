package com.zhaolearn.nio.example.group_chat.client;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Scanner;


@Getter
public class ChatClientHandler {
    private ChatClient chatClient;
    public ChatClientHandler() { this.chatClient=new ChatClient();}
    //向服务器发送消息
    public void sendInfo(String info) {
        info = chatClient.getUsername() + " 说：" + info;
        try {
            chatClient.getSocketChannel().write(ByteBuffer.wrap(info.getBytes()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //读取从服务器端回复的消息
    public void readInfo() {
        try {
            int readChannels = chatClient.getSelector().select();
            if (readChannels > 0) {//有可以用的通道
                Iterator<SelectionKey> iterator = chatClient.getSelector().selectedKeys().iterator();
                while (iterator.hasNext()) {
                    SelectionKey key = iterator.next();
                    if (key.isReadable()) {
                        //得到相关的通道
                        SocketChannel sc = (SocketChannel) key.channel();
                        //得到一个Buffer
                        ByteBuffer buffer = ByteBuffer.allocate(1024);
                        //读取
                        sc.read(buffer);
                        //把读到的缓冲区的数据转成字符串
                        String msg = new String(buffer.array());
                        System.out.println(msg.trim());
                    }
                }
                iterator.remove(); //删除当前的selectionKey, 防止重复操作
            } else {
                //System.out.println("没有可以用的通道...");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void ready() {
        //启动一个线程, 每个3秒，读取从服务器发送数据
        new Thread(() -> {
            while (true) {
                this.readInfo();
                try {
                    Thread.currentThread().sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        //发送数据给服务器端
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String s = scanner.nextLine();
            this.sendInfo(s);
        }
    }
}
