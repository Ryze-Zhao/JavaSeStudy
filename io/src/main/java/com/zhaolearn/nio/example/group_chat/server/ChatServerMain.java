package com.zhaolearn.nio.example.group_chat.server;


public class ChatServerMain {
    public static void main(String[] args) {
        //创建服务器对象
        ChatServerHandler chatServerHandler=new ChatServerHandler();
        chatServerHandler.listen();
    }
}
