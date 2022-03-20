package main;

import java.nio.ByteBuffer;

/**
 * @author 【看动画，学Java】https://learning.snssdk.com/feoffline/toutiao_wallet_bundles/toutiao_learning_wap/online/album_detail.html?content_id=6892772675148579083
 * @author 【官方网站】gorhaf.com
 * @author 【微信公众号】gorhaf
 * @author 【个人微信号】gorhafapp
 * @author 【抖音/今日头条/西瓜视频】人人都是程序员
 * @author 【学浪】宋辞
 * @author 【腾讯课堂】人人都是程序员
 * @author 【B站】人人都是程序员
 */
public class Main {

    public static void main(String[] args) {
        // 创建字节缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        // 写入数据
        buffer.put("he".getBytes());
        // 打上标记
        buffer.mark();
        // 继续写入数据
        buffer.put("kko".getBytes());
        // 回到标记
        buffer.reset();
        // 重新写入数据
        buffer.put("llo".getBytes());
        // 记录当前 position 的位置
        int length = buffer.position();
        // 将 position 设置为 0，并清除标记
        buffer.rewind();
        // 目标数组
        byte[] dst = new byte[length];
        // 将缓冲区中的数据读到目标数组中
        buffer.get(dst);
        // 输出数据
        System.out.println(new String(dst));
    }
}