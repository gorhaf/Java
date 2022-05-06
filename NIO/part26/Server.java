package main;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
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
public class Server {
    /**
     * 通道选择器
     */
    private static Selector selector;
    /**
     * 服务端套字节通道
     */
    private static ServerSocketChannel server;

    public static void main(String[] args) {
        try {
            // 创建通道选择器
            selector = Selector.open();
            // 创建服务端套字节通道
            server = ServerSocketChannel.open();
            // 绑定监听端口号
            server.bind(new InetSocketAddress(8080));
            // 将服务端配置为非阻塞模式
            server.configureBlocking(false);
            // 将服务端套字节通道注册到选择器里
            server.register(selector, SelectionKey.OP_ACCEPT);
            // Selector在事件到来前一直阻塞
            while (selector.select() > 0) {
                // 所有已准备好的key
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                // 遍历所有已准备好的key
                Iterator<SelectionKey> iterator = selectionKeys.iterator();
                while (iterator.hasNext()) {
                    // 获取当前Key
                    SelectionKey selectionKey = iterator.next();
                    // 当有客户端连接时
                    if (selectionKey.isAcceptable()) {
                        // 接受客户端请求处理器
                        acceptHandler();
                    }
                    // 当有客户端需要读取数据时
                    if (selectionKey.isReadable()) {
                        // 读数据处理器
                        readHandler(selectionKey);
                    }
                    // 移除已处理的Key
                    iterator.remove();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭连接
            if (server != null) {
                try {
                    server.close();
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
     */
    private static void acceptHandler() throws IOException {
        // 获取客户端
        SocketChannel client = server.accept();
        // 采用非阻塞模式
        client.configureBlocking(false);
        // 将客户端套字节通道注册到选择器里
        client.register(selector, SelectionKey.OP_READ);
        // 向客户端传输信息
        String message = "你好，客户端！我是服务端！";
        client.write(ByteBuffer.wrap(message.getBytes()));
    }

    /**
     * 可读数据处理器
     *
     * @param selectionKey 选择键
     */
    private static void readHandler(SelectionKey selectionKey) throws IOException {
        // 获取客户端
        SocketChannel client = (SocketChannel) selectionKey.channel();
        // 创建缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        // 获取客户端信息
        int length = client.read(buffer);
        // 当有信息时
        if (length > 0) {
            // 打印客户端信息
            System.out.println(new String(buffer.array(), 0, length));
        }
    }
}