package com.star.concurrent.blockingqueue;

import com.star.concurrent.latch.TestHarness;

import java.io.File;
import java.io.FileFilter;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @Author: lcx
 * @Date: 2019/3/9 14:44
 * @Description:
 */

public class Test {

    public static void main(String[] args) {
        File file = new File("e:\\Dsp测试");
        File[] files = file.listFiles();
        startIndexing(files);
    }

    public static void startIndexing(File[] roots) {
        BlockingQueue<File> queue = new LinkedBlockingQueue<>(100);
        FileFilter filter = new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return true;
            }
        };

        for (File root : roots) {
            Runnable task = new FileCrawer(queue, filter, root);
            new Thread(task).start();
        }

        // Runnable task = new Indexer(queue);
        // try {
        //     System.out.println(TestHarness.timeTasks(8, task));
        // } catch (InterruptedException e) {
        //     e.printStackTrace();
        // }

        for (int i = 0; i < 10; i++) {
            new Thread(new Indexer(queue)).start();
        }
    }

}
