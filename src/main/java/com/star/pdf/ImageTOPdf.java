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

public class ImageTOPdf {

    private static ExecutorService fixedThreadPool;

//    private final String TEST_PDF_BOOK_PATH = "classpath:阿里巴巴Java开发手册（详尽版）.pdf";

    static {
//        System.setProperty("sun.java2d.cmm", "sun.java2d.cmm.kcms.KcmsServiceProvider");
        int processors = Runtime.getRuntime().availableProcessors();
//        log.info("availableProcessors: {}", processors);
        fixedThreadPool = Executors.newFixedThreadPool(processors);
    }

    public static void main(String[] args) throws IOException, InterruptedException {
//        if (args.length < 2) {
//            System.err.println("usage: " + ImageTOPdf.class.getName() + " <image> <output-file>");
//            System.exit(1);
//        }

//        File imgPath = new File("/Users/lichunxia/Documents/images/pdfimg");
        File imgPath = new File("/Users/lichunxia/Documents/work/third-house/pics");

        String[] imgList = imgPath.list();

        Arrays.sort(imgList);
        System.out.println(Arrays.toString(imgList));
        System.out.println(imgList.length);

        String pdfPath = imgPath + "/合成的test.pdf";

//        if (!pdfPath.endsWith(".pdf")) {
//            System.err.println("Last argument must be the destination .pdf file");
//            System.exit(1);
//        }

        PDDocument doc = new PDDocument();
        Tracer tracer = new Tracer(imgList.length);

        long startTime = System.nanoTime();

        for (int i = 0; i < imgList.length; i++) {
            final int j = i;
            fixedThreadPool.execute(() -> {
                        String imagePath = imgPath + "/" + imgList[j];
                        PDPage page = new PDPage();
                        doc.addPage(page);

                        // createFromFile is the easiest way with an image file
                        // if you already have the image in a BufferedImage,
                        // call LosslessFactory.createFromImage() instead
                        PDImageXObject pdImage = null;
                        try {
                            pdImage = PDImageXObject.createFromFile(imagePath, doc);
                            PDPageContentStream contents = null;
                            contents = new PDPageContentStream(doc, page);

                            // draw the image at full size at (x=20, y=20)
                            // contents.drawImage(pdImage, 20, 20);

                            // to draw the image at half size at (x=20, y=20) use
                            contents.drawImage(pdImage, 20, 20, (float) (pdImage.getWidth() / 1.6), (float) (pdImage.getHeight() / 1.6));
                            contents.close();
                            tracer.increaseSuccessPages();
                        } catch (IOException e) {
                            e.printStackTrace();
                            tracer.increaseFailPages();
                        }
                    }
            );
//            Thread.sleep(10);
        }

        while (!tracer.isDone()) {
//                System.out.println("finally " + tracer.isDone());
            Thread.sleep(30);
        }
        doc.save(pdfPath);
        doc.close();
        long endTime = System.nanoTime();
        System.out.println("耗时：" + (endTime - startTime) / 1000000000.0 + " 秒");

    }
}

