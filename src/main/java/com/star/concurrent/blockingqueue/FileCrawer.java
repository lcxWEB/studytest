package com.star.concurrent.blockingqueue;

import java.io.File;
import java.io.FileFilter;
import java.util.concurrent.BlockingQueue;

/**
 * @Author: lcx
 * @Date: 2019/3/9 13:17
 * @Description:
 */

public class FileCrawer implements Runnable {

    private final BlockingQueue<File> fileQueue;
    private final FileFilter fileFilter;
    private final File root;

    public FileCrawer(BlockingQueue<File> fileQueue, FileFilter fileFilter, File root) {
        this.fileQueue = fileQueue;
        this.fileFilter = fileFilter;
        this.root = root;
    }

    @Override
    public void run() {
        try {
            crawl(root);
            System.out.println(Thread.currentThread());
        } catch (InterruptedException e) {
            // 恢复被中断的状态
            Thread.currentThread().interrupt();
        }
    }

    private void crawl(File root) throws InterruptedException {
        File[] entries = root.listFiles(fileFilter);
        if (entries != null) {
            for (File file : entries) {
                if (file.isDirectory()) {
                    crawl(file);
                } else if (!areadyIndexed(file)) {
                    fileQueue.put(file);
                }
            }
        }
    }

    private boolean areadyIndexed(File file) {
        return false;
    }

}
