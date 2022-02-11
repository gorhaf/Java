package main;

import java.io.*;

/**
 * @author 【看动画，学Java】https://learning.snssdk.com/feoffline/toutiao_wallet_bundles/toutiao_learning_wap/online/album_detail.html?content_id=6892772675148579083
 * @author 【官方网站】gorhaf.com
 * @author 【微信公众号】gorhaf
 * @author 【个人微信号】gorhafapp
 * @author 【抖音/今日头条/西瓜视频】人人都是程序员
 * @author 【腾讯课堂】人人都是程序员
 * @author 【B站】人人都是程序员
 * 欢迎大家扫描下方二维码关注我们
 * █▀▀▀▀▀▀▀██▀██████▀▀▀▀██▀▀▀▀▀▀▀█
 * █ █▀▀▀█ █▄ ▀ ▄▄█▄█▄█▀██ █▀▀▀█ █
 * █ █   █ █▄▄▀▄▀█▄▄ ██▀ █ █   █ █
 * █ ▀▀▀▀▀ █ █ █▀▄▀▄ █ █ █ ▀▀▀▀▀ █
 * █▀▀▀▀▀█▀▀▀▀▀█ █▀▄▀▀█ ▄▀█▀█▀█▀██
 * █▄▄▄ ██▀█  █▀▀ ▀  ▄ ▄▀▄   ███▄█
 * ██  ▀▀█▀ ▄ ▄ █▀▄▄▄▀▄▀▄ ▄██▀▀▄██
 * █ █▄▄  ▀ █ ▄█▄▄▄▀▄▀█▄ ▄ ▄ █ █▄█
 * █  ▄██▄▀██▄ █ ▀▄▀ ▀▀ ▄▄▄▀██▀▄██
 * █ █▀▀█▀▀█▀ █▀▀█▄▀▀█▀▄ ▀▄    █▄█
 * █ █▀▀██▀▀█▀  █▀▀  ██▄▀▀▀▀▀█▀ ▀█
 * █▀▀▀▀▀▀▀█ ▄██▄▄▀▀▀▄▄▀ █▀█   ▄▄█
 * █ █▀▀▀█ █▀ ▄█ █▀ ▄▀▄▄ ▀▀▀  ▀▀ █
 * █ █   █ █ ▄▀▀▀█▄ ▄▀▄▀ █▀▀▀ ▀ ▄█
 * █ ▀▀▀▀▀ █ ▀█ ▀█▄  █▄█▄▄█  ▄▀▄██
 * ▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀
 */
public class Main {

    public static void main(String[] args) {
        // 声明字符输入输出流
        FileReader reader = null;
        FileWriter writer = null;
        try {
            // 初始化字符输入输出流
            reader = new FileReader("/Users/admin/Downloads/人人都是程序员.txt");
            writer = new FileWriter("/Users/admin/Downloads/人人都是程序员副本.txt");
            // 复制数据
            reader.transferTo(writer);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 当字符输入流不为空时
            if (reader != null) {
                try {
                    // 关闭字符输入流
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            // 当字符输出流不为空时
            if (writer != null) {
                try {
                    // 关闭字符输出流
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}