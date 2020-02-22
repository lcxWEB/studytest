package com.star.pdf;

import com.sun.media.jai.codec.ImageCodec;
import com.sun.media.jai.codec.ImageEncoder;
import com.sun.media.jai.codec.JPEGEncodeParam;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

import javax.imageio.ImageIO;
import javax.media.jai.JAI;
import javax.media.jai.RenderedOp;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Arrays;

public class ImageToPDFSingleThread {

    //        for (int j = 1; j < arr.length; j++) {
//            System.out.println(imgList[arr[j - 1]]);
//            String pdfPath = imgPath + "/" + j + "合成的test.pdf";
//            PDDocument doc = new PDDocument();
//            try {
//                for (int i = arr[j - 1]; i < arr[j]; i++) {
//                    String imagePath = imgPath + "/" + imgList[i];
//                    File imgFile = new File(imagePath);
//                    BufferedImage bim = ImageIO.read(imgFile);
//                    PDPage page = new PDPage();
//                    doc.addPage(page);
////                    RenderedOp
//                    PDImageXObject pdImage = PDImageXObject.createFromFile(imagePath, doc);
//                    byte[] bytes = toByteArray(imagePath);
////                    PDImageXObject pdImage = PDImageXObject.createFromByteArray(doc, bytes, null);
////                    PDImageXObject pdImage = LosslessFactory.createFromImage(doc, bim);
//                    PDPageContentStream contents = null;
//                    contents = new PDPageContentStream(doc, page);
//                    contents.drawImage(pdImage, 20, 20, (float) (pdImage.getWidth() / 1.6), (float) (pdImage.getHeight() / 1.6));
//                    contents.close();
//                }
//                doc.save(pdfPath);
//            } finally {
//                doc.close();
//            }
//        }

    public static void main(String[] args) throws IOException {

//        File imgPath = new File("/Users/lichunxia/Documents/images/pdfimg");
        String imgPath = "/Users/lichunxia/Documents/work/yuan.jpeg";
//        File imgPath = new File("/Users/lichunxia/Documents/work/YH-2017-2302-00003");
//        File waterPrint = new File("/Users/lichunxia/Documents/work/waterprint.jpeg");
//        File waterPrint = new File("/Users/lichunxia/Documents/work/1.jpeg");
        File waterPrint = new File("/Users/lichunxia/Documents/work/2.png");

//        Arrays.sort(imgList);
//        System.out.println(Arrays.toString(imgList));
//        System.out.println(imgList.length);

//        int[] arr = new int[]{0, 100, 200, 300, imgList.length};

        long startTime = System.nanoTime();

        PDDocument doc = new PDDocument();
        float opacity = 0.25f;

        try {
//            String pdfPath = imgPath + "/" + 1 + "test2.pdf";
            String pdfPath = "/Users/lichunxia/Documents/work/test2.pdf";
//            String imagePath = imgPath + "/" + imgList[0];
//            File imgFile = new File(imagePath);
            File imgFile = new File(imgPath);
            BufferedImage bim = ImageIO.read(imgFile);

            bim = Thumbnails.of(imgFile)
                    .size(bim.getWidth(), bim.getHeight())
                    .watermark(Positions.CENTER, ImageIO.read(waterPrint), 1)
                    .asBufferedImage();


//            Thumbnails.of(imgFile)
////                    // 设置图片大小
//                    .size(bim.getWidth(), bim.getHeight())
//                    // 加水印 参数：1.水印位置 2.水印图片 3.不透明度0.0-1.0
//                    .watermark(Positions.CENTER, ImageIO.read(waterPrint), 1)
////                    // 输出到文件
//                    .toFile("/Users/lichunxia/Documents/work/test3.jpeg");

            OutputStream outputStream = new ByteArrayOutputStream();
            ImageIO.write(bim, "jpg", outputStream);
            PDImageXObject pdImage = PDImageXObject.createFromByteArray(doc, ((ByteArrayOutputStream) outputStream).toByteArray(), null);

            float imageW = pdImage.getWidth();
            float imageH = pdImage.getHeight();
            float imageRatio = imageW / imageH;
            float tarImageW;
            float tarImageH;

            PDPage page;

            if (imageRatio > 1) {
                // A3的宽
                tarImageW = 1190.55f;
                tarImageH = tarImageW / imageRatio;
                page = new PDPage(new PDRectangle(1190.55f, 841.89f));
            } else {
                // A4的高
                tarImageH = 841.89f;
                tarImageW = tarImageH * imageRatio;
                page = new PDPage(PDRectangle.A4);
            }
            doc.addPage(page);
            PDPageContentStream contents = new PDPageContentStream(doc, page);
            contents.drawImage(pdImage, 0, 0, tarImageW, tarImageH);
            contents.close();
            doc.save(pdfPath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void typeChange() {
        /* tif转换到jpg格式 */
//        String input2 = "/Users/lichunxia/Documents/work/1-1994-XZ11-1-1/1-1994-XZ11-1-1/0001.tif";
        String input2 = "/Volumes/Samsung_T3/江南大学/1-1994-XZ11-2/1-1994-XZ11-2-3/0001.tif";
//        String output2 = "/Users/lichunxia/Documents/work/1-1994-XZ11-1-1/1-1994-XZ11-1-1/a.jpg";
        String output2 = "/Volumes/Samsung_T3/江南大学/1-1994-XZ11-2/1-1994-XZ11-2-3/0001.jpg";
        RenderedOp src2 = JAI.create("fileload", input2);
        OutputStream os2 = null;
        try {
            os2 = new FileOutputStream(output2);
//            os2 = new ByteArrayOutputStream();
        } catch (Exception e) {
            e.printStackTrace();
        }
        JPEGEncodeParam param2 = new JPEGEncodeParam();
        //指定格式类型，jpg 属于 JPEG 类型
        ImageEncoder enc2 = ImageCodec.createImageEncoder("JPEG", os2, param2);
        try {
            enc2.encode(src2);
            os2.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public static byte[] toByteArray(String filename) throws IOException {

        File f = new File(filename);
        if (!f.exists()) {
            throw new FileNotFoundException(filename);
        }

        ByteArrayOutputStream bos = new ByteArrayOutputStream((int) f.length());
        BufferedInputStream in = null;
        try {
            in = new BufferedInputStream(new FileInputStream(f));
            int buf_size = 1024;
            byte[] buffer = new byte[buf_size];
            int len = 0;
            while (-1 != (len = in.read(buffer, 0, buf_size))) {
                bos.write(buffer, 0, len);
            }
            return bos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            bos.close();
        }
    }
}


