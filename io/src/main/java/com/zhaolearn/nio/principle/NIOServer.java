package com.zhaolearn.nio.principle;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

/**
 * 4.1.1    ​首先打开Selector（ Selector会一直处于监听状态）和ServerSocketChannel，将ServerSocketChannel注册到Selector（使用方法register(Selector sel, int ops), 一个Selector上可以注册多个SocketChannel，Selector会使用Set集合存放SelectionKey），并设置ServerSocketChannel监听的事件，如：SelectionKey.OP_ACCEPT；
 * 4.1.2    客户端连接时，符合SelectionKey.OP_ACCEPT事件，因此可通过selector.selectedKeys()获取到符合此事件的SelectionKey，其中就有ServerSocketChannel的SelectionKey；
 * 4.1.3    遍历selector.selectedKeys()，判断SelectionKey事件，如果是SelectionKey.OP_ACCEPT，那么就用serverSocketChannel.accept()获取到SocketChannel（分配给客户端的），将这个SocketChannel设置为非阻塞（因为我们要的是NIO非阻塞），并通过注册到Selector中（同时给入一个Buffer：socketChannel.register(selector, SelectionKey.OP_READ, ByteBuffer.allocate(1024));）
 * 4.1.4    当有指定事件发生时（如4.1.3中的SelectionKey.OP_READ事件），Selector会得到发生指定事件的SelectionKey（如4.1.3注册的那个SelectionKey），并通过这个SelectionKey获取到发生指定事件的客户端SocketChannel（使用channel()方法）
 * 4.1.5    最后通过获取的Channel，进行相应的业务
 */
public class NIOServer {
    public static void main(String[] args) throws Exception {
        //得到一个Selecor对象
        Selector selector = Selector.open();
        //创建ServerSocketChannel -> ServerSocket
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        //绑定一个端口6666, 在服务器端监听
        serverSocketChannel.socket().bind(new InetSocketAddress(6666));
        //设置为非阻塞
        serverSocketChannel.configureBlocking(false);
        //把 serverSocketChannel 注册到  selector 关心 事件为 OP_ACCEPT
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        System.out.println("注册后的selectionkey 数量=" + selector.keys().size()); // 1
        //循环等待客户端连接
        while (true) {
            //这里我们等待1秒，如果没有事件发生, 返回，这里改为selectNow也可以
            if (selector.select(10000) == 0) { //没有事件发生
                System.out.println("服务器等待了10秒，无连接");
                continue;
            }
            //如果返回的>0, 就获取到相关的 selectionKey集合
            //1.如果返回的>0， 表示已经获取到关注的事件；2. selector.selectedKeys() 返回关注事件的集合
            //通过 selectionKeys 反向获取通道
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            System.out.println("注册的selectionkey总数量：" + selector.keys().size()+"  当前触发selectionKeys数量：" + selectionKeys.size());
            //遍历 Set<SelectionKey>, 使用迭代器遍历
            Iterator<SelectionKey> keyIterator = selectionKeys.iterator();
            while (keyIterator.hasNext()) {
                //获取到SelectionKey
                SelectionKey key = keyIterator.next();
                //根据key 对应的通道发生的事件做相应处理（这一步主要是用于处理serverSocketChannel监听到客户端连接，并为当前连接的客户端分配SocketChannel和注册到Selector）
                if (key.isAcceptable()) { //如果是 OP_ACCEPT, 有新的客户端连接
                    //给该客户端生成一个 SocketChannel
                    //使用serverSocketChannel.accept()，或者key.channel();都可以。
                    //serverSocketChannel.accept()虽然是阻塞的，但由于只有SelectionKey.OP_ACCEPT（有客户端连接时）才执行，因此不用考虑没新连接也等待。
                    SocketChannel socketChannel = serverSocketChannel.accept();
                    System.out.println("客户端连接成功 生成了一个 socketChannel " + socketChannel.hashCode());
                    //将  SocketChannel 设置为非阻塞
                    socketChannel.configureBlocking(false);
                    //将socketChannel 注册到selector, 关注事件为 OP_READ， 同时给socketChannel关联一个Buffer
                    socketChannel.register(selector, SelectionKey.OP_READ, ByteBuffer.allocate(1024));
                    System.out.println("客户端连接后 ，注册的selectionkey 数量=" + selector.keys().size()); //2,3,4..
                }
                //根据key 对应的通道发生的事件做相应处理（这一步主要用于处理客户端的SelectionKey.OP_READ事件，主要处理的是SocketChannel，这是通过SelectionKey直接获取即可）
                if (key.isReadable()) {  //发生 OP_READ
                    //通过key 反向获取到对应channel
                    SocketChannel channel = (SocketChannel) key.channel();
                    //获取到该channel关联的buffer
                    ByteBuffer buffer = (ByteBuffer) key.attachment();
                    //如果客户端关闭，会产生一个SelectionKey.OP_READ事件且会以异常提示客户端关闭，因此需要catch
                    try {
                        //将 Channel 的数据读入缓冲区，返回读入到缓冲区的字节数
                        channel.read(buffer);
                        System.out.println("channel信息："+channel.hashCode()+"  form 客户端：" + new String(buffer.array()));
                    } catch (IOException e) {
                        System.out.println("客户端已经关闭");
                        key.cancel();
                        channel.close();
                        buffer.clear();
                    }finally {
                        buffer.clear();
                    }
                }
                //手动从集合中移动当前的selectionKey, 防止重复操作
                keyIterator.remove();
            }
        }
    }
}
