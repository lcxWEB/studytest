package com.star.pdf;

import java.util.concurrent.atomic.AtomicInteger;

public class Tracer {

    private int totalPages;

    private AtomicInteger successPages;

    private AtomicInteger failPages;

    private String firstPage;

    public Tracer(int totalPages) {
        this.totalPages = totalPages;

        this.successPages = new AtomicInteger();
        this.successPages.set(0);

        this.failPages = new AtomicInteger();
        this.failPages.set(0);
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public void increaseSuccessPages() {
        int successPages = this.successPages.addAndGet(1);
//        System.out.println("done pages: " + successPages);
    }

    public void increaseFailPages() {
        this.failPages.addAndGet(1);
    }

    public boolean isDone() {
        System.out.println(successPages.get() + " " + failPages.get() + " " + totalPages);
        return totalPages == successPages.get() + failPages.get();
    }

    public boolean isScceed() {
        return totalPages == successPages.get();
    }

    public String getFirstPage() {
        return firstPage;
    }

    public void setFirstPage(String firstPage) {
        this.firstPage = firstPage;
    }
}
