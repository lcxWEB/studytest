package com.star.concurrent.blockingqueue;

import java.io.File;
import java.util.concurrent.BlockingQueue;

/**
 * @Author: lcx
 * @Date: 2019/3/9 14:41
 * @Description:
 */

public class Indexer implements Runnable {

    private final BlockingQueue<File> queue;

    public Indexer(BlockingQueue<File> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            System.out.println("consumer : " + Thread.currentThread());
            while (true) {
            // while (!queue.isEmpty()) {
                indexFile(queue.take());
            }
        } catch (InterruptedException e) {
            // 恢复被中断的状态
            Thread.currentThread().interrupt();
        }
    }

    private void indexFile(File file) {
        System.out.println("为文件" + file + "建立索引");
    }

}
