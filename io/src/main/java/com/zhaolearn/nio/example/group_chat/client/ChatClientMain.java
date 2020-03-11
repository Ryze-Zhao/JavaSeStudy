package com.zhaolearn.nio.example.group_chat.client;

public class ChatClientMain {
    public static void main(String[] args)  {
        ChatClientHandler chatClientHandler=new ChatClientHandler();
        chatClientHandler.ready();
    }
}
