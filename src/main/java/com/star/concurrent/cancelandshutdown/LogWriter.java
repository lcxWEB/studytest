package com.star.concurrent.cancelandshutdown;

import java.io.PrintWriter;
import java.io.Writer;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class LogWriter {

    private final BlockingQueue<String> queue;

    private final LoggerThread thread;

    public LogWriter(Writer writer) {
        this.queue = new LinkedBlockingQueue<>(100);
        this.thread = new LoggerThread(writer);
    }

    public void start() {
        thread.start();
    }

    public void log(String msg) throws InterruptedException {
        queue.put(msg);
    }


    private class LoggerThread extends Thread {

        private final PrintWriter writer;

        private LoggerThread(Writer writer) {
            this.writer = (PrintWriter) writer;
        }

        @Override
        public void run() {
            try {
                while (true) {
                    writer.println(queue.take());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                writer.close();
            }
        }

    }
}
