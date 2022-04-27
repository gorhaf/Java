package main;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Set;

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
            // 创建通道选择器
            Selector selector = Selector.open();
            // 创建服务端套字节通道
            ServerSocketChannel server = ServerSocketChannel.open();
            // 绑定监听端口号
            server.bind(new InetSocketAddress(8080));
            // 将服务端套字节通道注册到选择器里
            server.register(selector, SelectionKey.OP_ACCEPT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}