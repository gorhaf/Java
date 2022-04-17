package main;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * @author 【看动画，学Java】https://student-api.iyincaishijiao.com/t/Nqrff3f/
 * @author 【官方网站】gorhaf.com
 * @author 【微信公众号】gorhaf
 * @author 【个人微信号】gorhafapp
 * @author 【抖音】人人都是程序员
 * @author 【B站】人人都是程序员
 */
public class Server {

    public static void main(String[] args) {
        try {
            // 创建服务端套字节通道
            ServerSocketChannel server = ServerSocketChannel.open();
            // 绑定监听端口号
            server.bind(new InetSocketAddress(8080));
            // 等待客户端连接
            SocketChannel client = server.accept();
            // 创建缓冲区
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            // 获取客户端消息
            int length = client.read(buffer);
            // 输出客户端消息
            System.out.println(new String(buffer.array(), 0, length));
            // 向客户端传输数据
            client.write(ByteBuffer.wrap("你好，客户端！我是服务端！".getBytes()));
            // 关闭连接
            client.close();
            server.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}