package main;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @author 【看动画，学Java】https://student-api.iyincaishijiao.com/t/Nqrff3f/
 * @author 【官方网站】gorhaf.com
 * @author 【微信公众号】gorhaf
 * @author 【个人微信号】gorhafapp
 * @author 【抖音】人人都是程序员
 * @author 【B站】人人都是程序员
 */
public class Client {
    /**
     * 通道选择器
     */
    private static Selector selector;
    /**
     * 客户端
     */
    private static SocketChannel client;

    public static void main(String[] args) {
        try {
            // 创建通道选择器
            selector = Selector.open();
            // 创建客户端
            client = SocketChannel.open();
            // 采用非阻塞模式
            client.configureBlocking(false);
            // 连接服务端
            client.connect(new InetSocketAddress("192.168.0.102", 8080));
            // 将服务端连接注册到Selector里，并监听OP_CONNECT事件
            client.register(selector, SelectionKey.OP_CONNECT);
            // Selector在事件到来前一直阻塞
            while (selector.select() > 0) {
                // 获取所有准备好的事件
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                // 遍历所有key
                Iterator<SelectionKey> iterator = selectionKeys.iterator();
                while (iterator.hasNext()) {
                    // 获取当前key
                    SelectionKey selectionKey = iterator.next();
                    // 当连接服务端成功时
                    if (selectionKey.isConnectable()) {
                        // 处理连接
                        connectHandler(selectionKey);
                    }
                    // 当有数据可读时
                    if (selectionKey.isReadable()) {
                        // 处理可读数据
                        readHandler(selectionKey);
                    }
                    // 移除已处理的key
                    iterator.remove();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭连接
            if (client != null) {
                try {
                    client.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (selector != null) {
                try {
                    selector.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 连接处理器
     *
     * @param selectionKey 选择键
     */
    private static void connectHandler(SelectionKey selectionKey) throws IOException {
        // 获取服务端
        SocketChannel server = (SocketChannel) selectionKey.channel();
        // 检测连接是否完成，当连接未完成时
        if (server.isConnectionPending()) {
            // 继续完成连接，调用该方法时会阻塞，直到完成连接或连接失败
            server.finishConnect();
        }
        // 采用非阻塞模式
        server.configureBlocking(false);
        // 将服务端注册到Selector里，并监听OP_READ事件
        server.register(selector, SelectionKey.OP_READ);
        // 连接成功后，向服务端发送数据
        String message = "你好，服务端！我是客户端";
        server.write(ByteBuffer.wrap(message.getBytes()));
    }

    /**
     * 可读数据处理器
     *
     * @param selectionKey 选择键
     */
    private static void readHandler(SelectionKey selectionKey) throws IOException {
        // 获取服务端
        SocketChannel server = (SocketChannel) selectionKey.channel();
        // 创建缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        // 将服务端数据读到缓冲区里
        int length = server.read(buffer);
        // 当数据长度大于0时
        if (length > 0) {
            // 打印数据
            System.out.println(new String(buffer.array(), 0, length));
        }
    }
}