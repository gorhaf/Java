package main;

import java.nio.file.Path;
import java.nio.file.Paths;

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
        // 创建路径
        Path path1 = Paths.get("/Users/admin/Downloads");
        Path path2 = Paths.get("人人都是程序员");
        // 使用 resolve 合并路径
        System.out.println(path1.resolve(path2));
        // 使用 resolveSibling 合并路径
        System.out.println(path1.resolveSibling(path2));
    }
}