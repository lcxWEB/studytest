package com.star.pdf;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ImageToPDFMutiThread {

    private static ExecutorService fixedThreadPool;

//    private final String TEST_PDF_BOOK_PATH = "classpath:阿里巴巴Java开发手册（详尽版）.pdf";

    static {
//        System.setProperty("sun.java2d.cmm", "sun.java2d.cmm.kcms.KcmsServiceProvider");
        int processors = Runtime.getRuntime().availableProcessors();
//        log.info("availableProcessors: {}", processors);
        fixedThreadPool = Executors.newFixedThreadPool(processors);
    }

    public static void main(String[] args) throws IOException {

        File imgPath = new File("/Users/lichunxia/Documents/images/pdfimg");

        String[] imgList = imgPath.list();
        Arrays.sort(imgList);

        System.out.println(Arrays.toString(imgList));
        System.out.println(imgList.length);

        int[] arr = new int[]{0, 100, 200, 300, imgList.length};

        Tracer tracer = new Tracer(arr.length - 1);

        long startTime = System.nanoTime();

        for (int j = 1; j < arr.length; j++) {
            final int k = j;
            fixedThreadPool.execute(() -> {
                System.out.println(imgList[arr[k - 1]]);
                String pdfPath = imgPath + "/" + k + "合成的test.pdf";
                PDDocument doc = new PDDocument();
                try {
                    for (int i = arr[k - 1]; i < arr[k]; i++) {
                        String imagePath = imgPath + "/" + imgList[i];
                        PDPage page = new PDPage();
                        doc.addPage(page);
                        PDImageXObject pdImage = PDImageXObject.createFromFile(imagePath, doc);
                        PDPageContentStream contents = new PDPageContentStream(doc, page);
                        contents.drawImage(pdImage, 20, 20, (float) (pdImage.getWidth() / 1.6), (float) (pdImage.getHeight() / 1.6));
                        contents.close();
                    }
                    doc.save(pdfPath);
                    tracer.increaseSuccessPages();
                } catch (IOException e) {
                    e.printStackTrace();
                    tracer.increaseFailPages();
                } finally {
                    try {
                        doc.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
        }

        while (!tracer.isDone()) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        fixedThreadPool.shutdown();
        long endTime = System.nanoTime();

        System.out.println("耗时：" + (endTime - startTime) / 1000000000.0 + " 秒");
    }
}


