package main;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @author 【看动画，学Java】https://student-api.iyincaishijiao.com/t/Nqrff3f/
 * @author 【官方网站】gorhaf.com
 * @author 【微信公众号】gorhaf
 * @author 【个人微信号】gorhafapp
 * @author 【抖音】人人都是程序员
 * @author 【B站】人人都是程序员
 */
public class Main {

    public static void main(String[] args) {
        // 文件路径
        Path src = Paths.get("/Users/admin/Downloads/人人都是程序员.txt");
        Path dst = Paths.get("/Users/admin/Downloads/人人都是程序员副本.txt");
        try {
            // 创建文件通道
            FileChannel in = FileChannel.open(src, StandardOpenOption.READ);
            FileChannel out = FileChannel.open(dst, StandardOpenOption.CREATE,
                    StandardOpenOption.WRITE);
            // 创建缓冲区
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            // 循环读取字节
            while (in.read(buffer) >= 0 || buffer.position() != 0) {
                // 翻转缓冲区
                buffer.flip();
                // 写数据
                out.write(buffer);
                // 压缩缓冲区
                buffer.compact();
            }
            // 关闭通道
            in.close();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}