package com.star.concurrent.threadpool;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MyAppThread extends Thread {

    public static final String DEFAULT_NAME = "myAppThread";
    private static final AtomicInteger created = new AtomicInteger();
    private static final AtomicInteger alive = new AtomicInteger();
    private static final Logger logger = Logger.getAnonymousLogger();
    private static volatile boolean debugLifecycle = false;

    public MyAppThread(Runnable target) {
        this(target, DEFAULT_NAME);
    }

    public MyAppThread(Runnable target, String name) {
        super(target, name + "-" + created.incrementAndGet());
        setDefaultUncaughtExceptionHandler(new UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                logger.log(Level.SEVERE, "uncaught in thread " + t.getName());
            }
        });
    }

    public static int getThreadsCreated() {
        return created.get();
    }

    public static int getThreadsAlive() {
        return alive.get();
    }

    public static boolean getDebug() {
        return debugLifecycle;
    }

    public static void setDebug(boolean debug) {
        debugLifecycle = debug;
    }

    @Override
    public void run() {
        boolean debug = debugLifecycle;
        if (debug) logger.log(Level.FINE, "created " + getName());

        try {
            alive.incrementAndGet();
            super.run();
        } finally {
            alive.decrementAndGet();
            if (debug) logger.log(Level.FINE, "exiting " + getName());
        }
    }
}
