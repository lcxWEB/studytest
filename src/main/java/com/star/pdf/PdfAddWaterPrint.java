package com.star.pdf;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfGState;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class PdfAddWaterPrint {
//    private static final float IAMGE_HEIGHT = 595f; // 水印图片的的高度
//    private static final float IAMGE_WIDTH = 842f; // 水印图片的的宽度

//    public static void main(String[] args) throws IOException, DocumentException {
//        String logoPath = "/Users/lichunxia/Documents/work/a3m.png";
//        Archives waterPrint = new Archives("/Users/lichunxia/Documents/work/2.png");
//        String pdfPath = "/Users/lichunxia/Documents/work/printaction.pdf";
//        String outPath = "/Users/lichunxia/Documents/work/test0524.pdf";
//        PdfReader reader = new PdfReader(pdfPath);
//        // 添加水印之后的pdf文件
//        PdfStamper stamp = new PdfStamper(reader, new FileOutputStream(outPath));
//        try {
//            int pageSize = reader.getNumberOfPages();
//            float pageHeight = reader.getPageSize(1).getHeight();
//            float pageWidth = reader.getPageSize(1).getWidth();
////            // 每两行显示两个 左边一个，右边一个
////            int lineNum = (int) (pageHeight / IAMGE_HEIGHT); // 行数
////            int middleY = (int) pageWidth / 2;
//            for (int i = 1; i <= pageSize; i++) {
////                for (int j = 0, k = 0; j < lineNum; j = j + 4, k++) {
//                    Random random = new Random();
//                    // 放入水印
//                    Image img = Image.getInstance(logoPath);
////                    img.scaleAbsolute(IAMGE_WIDTH, IAMGE_HEIGHT * 184 / 455);
//                    // 将水印显示到最底层
//                    img.setAlignment(Image.UNDERLYING);
//                    int trueY;
////                    while (true) {
////                        trueY = random.nextInt(middleY);
////                        if (trueY > IAMGE_WIDTH / 2 && trueY < (middleY - IAMGE_WIDTH)) {
////                            break;
////                        }
////                    }
//                    // 水印的位置
////                    img.setAbsolutePosition(trueY, j * IAMGE_HEIGHT + (float) random.nextInt((int) IAMGE_HEIGHT) - (k % 2) * 10);
//                    img.setAbsolutePosition(0, 0);
//                    // 旋转 角度
////                    img.setRotationDegrees(random.nextInt(360));
//                    PdfContentByte under = stamp.getUnderContent(i);
//
//                    PdfGState gs = new PdfGState();
//                    // 设置透明度为0.5
//                    gs.setFillOpacity(1);
//                    under.setGState(gs);
//                    under.addImage(img);
////                    while (true) {
////                        trueY = random.nextInt(middleY) + middleY;
////                        if (trueY > middleY + IAMGE_WIDTH / 2 && trueY < (2 * middleY - IAMGE_WIDTH)) {
////                            break;
////                        }
////                    }
//                    // 水印的位置
////                    img.setAbsolutePosition(trueY, j * IAMGE_HEIGHT + (float) random.nextInt((int) IAMGE_HEIGHT) - (k % 2) * 10);
//                    // 旋转角度
////                    img.setRotationDegrees(random.nextInt(360));
////                    under.addImage(img);
////                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            stamp.close();
//            reader.close();
//        }
//    }


    public static void main(String[] args) throws IOException, DocumentException {
        String logoPath = "/Users/lichunxia/Documents/work/a3m.png";
        File waterPrint = new File("/Users/lichunxia/Documents/work/2.png");
        String pdfPath = "/Users/lichunxia/Documents/work/1.pdf";
        String outPath = "/Users/lichunxia/Documents/work/test0524.pdf";
        PdfReader reader = new PdfReader(pdfPath);
        // 添加水印之后的pdf文件
        PdfStamper stamp = new PdfStamper(reader, new FileOutputStream(outPath));
        try {
            int pageSize = reader.getNumberOfPages();
            for (int i = 1; i <= pageSize; i++) {
                // 放入水印
                Image img = Image.getInstance(logoPath);
                // 将水印显示到最底层
//                img.setAlignment(Image.UNDERLYING);
//                img.setAlignment(Image.DEFAULT);
                img.setAbsolutePosition(0, 0);
                PdfContentByte under = stamp.getOverContent(i);
//                PdfGState gs = new PdfGState();
                // 设置透明度为1
//                gs.setFillOpacity(1);
//                under.setGState(gs);
                under.addImage(img);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            stamp.close();
            reader.close();
        }
    }
}
