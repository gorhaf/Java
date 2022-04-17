package main;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * @author 【看动画，学Java】https://student-api.iyincaishijiao.com/t/Nqrff3f/
 * @author 【官方网站】gorhaf.com
 * @author 【微信公众号】gorhaf
 * @author 【个人微信号】gorhafapp
 * @author 【抖音】人人都是程序员
 * @author 【B站】人人都是程序员
 */
public class Client {

    public static void main(String[] args) {
        try {
            // 客户端
            SocketChannel client = SocketChannel.open();
            // 连接服务端
            boolean success = client.connect(new InetSocketAddress("192.168.0.108", 8080));
            // 当连接服务端失败时
            if (!success) {
                System.out.println("连接失败");
                return;
            }
            // 缓冲区
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            // 将要发送的数据存入缓冲区中
            buffer.put("你好，服务端！我是客户端！".getBytes());
            // 翻转缓冲区，确定读写的数据范围
            buffer.flip();
            // 向服务端发送消息
            client.write(buffer);
            // 清空缓冲区
            buffer.clear();
            // 获取服务端消息
            int length = client.read(buffer);
            // 打印服务端消息
            System.out.println(new String(buffer.array(), 0, length));
            // 关闭资源
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}