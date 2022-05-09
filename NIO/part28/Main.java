package main;

import java.io.IOException;
import java.nio.file.*;

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
        // 监视器
        WatchService watcher = null;
        try {
            // 初始化监视器
            watcher = FileSystems.getDefault().newWatchService();
            // 监视对象
            Path path = Paths.get("/Users/admin/Downloads");
            // 将监视对象注册到监视器中
            WatchKey watchKey = path.register(watcher,
                    StandardWatchEventKinds.ENTRY_CREATE,
                    StandardWatchEventKinds.ENTRY_DELETE,
                    StandardWatchEventKinds.ENTRY_MODIFY);
            // 轮询
            while (true) {
                // 获取有变化的对象
                WatchKey key = watcher.take();
                // 处理事件
                for (WatchEvent<?> event : key.pollEvents()) {
                    switch (event.kind().name()) {
                        case "ENTRY_CREATE":
                            System.out.println("创建：" + event.context());
                            break;
                        case "ENTRY_DELETE":
                            System.out.println("删除：" + event.context());
                            break;
                        case "ENTRY_MODIFY":
                            System.out.println("修改：" + event.context());
                            break;
                    }
                }
                // 重置监视对象
                boolean valid = key.reset();
                // 当监视对象失效时
                if (!valid) {
                    // 移除该监视对象
                    watchKey.cancel();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // 当监视器不为空时
            if (watcher != null) {
                try {
                    // 关闭监视器
                    watcher.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}