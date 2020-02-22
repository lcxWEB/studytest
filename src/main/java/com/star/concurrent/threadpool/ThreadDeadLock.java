package com.star.concurrent.threadpool;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadDeadLock {

    static ExecutorService executorService = Executors.newSingleThreadExecutor();

    public static class RenderPageTask implements Callable<String> {
        @Override
        public String call() throws Exception {
            Future<String> header, foot;
            header = (Future<String>) executorService.submit(new LoadFileTask("head.html"));
            foot = (Future<String>) executorService.submit(new LoadFileTask("footer.html"));

            String page = renderBody();

            return header.get() + page + foot.get();

        }

        private String renderBody() {
            return "";
        }

        private class LoadFileTask implements Runnable {
            public LoadFileTask(String s) {
            }

            @Override
            public void run() {

            }
        }
    }

    public static void main(String[] args) {
        executorService.submit(new RenderPageTask());
    }
}
