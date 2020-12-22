package com.star.poi;

import cn.hutool.core.date.TimeInterval;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.xmlbeans.XmlOptions;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBody;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;

public class MergeDoc {

//    public static void main (String[] args) throws Exception {
//        InputStream in1 = null;
//        InputStream in2 = null;
////        OPCPackage src1Package = null;
////        OPCPackage src2Package = null;
//
//        OutputStream dest = new FileOutputStream("D:\\test\\merge-doc\\merged.docx");
//        try {
//            in1 = new FileInputStream("D:\\test\\merge-doc\\国家档案局令第13号.docx");
//            in2 = new FileInputStream("D:\\test\\merge-doc\\国家档案局令第13号.docx");
//
////            in2 = new FileInputStream("D:\\test\\merge-doc\\企业档案归档要求与整理操作规范.docx");
////            src1Package = OPCPackage.open(in1);
////            src2Package = OPCPackage.open(in2);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//
//
//        XWPFDocument src1Document = new XWPFDocument(in1);
//        CTBody src1Body = src1Document.getDocument().getBody();
//        XWPFParagraph p = src1Document.createParagraph();
//        //设置分页符
//        p.setPageBreak(true);
//        XWPFDocument src2Document = new XWPFDocument(in2);
//        CTBody src2Body = src2Document.getDocument().getBody();
//        appendBody(src1Body, src2Body);
//        src1Document.write(dest);
//        System.out.println("done");
//    }

    public static void main(String[] args) throws Exception {
        String path2 = "/Users/lichunxia/Documents/work/素材/03+冲向云霄年终总结.docx";
        String path1 = "/Users/lichunxia/Documents/work/素材/毕业证书.docx";
        final ArrayList<String> list = new ArrayList<>(10);
        for (int i = 0; i < 50; i++) {
            list.add(path2);
        }

        final TimeInterval timeInterval = new TimeInterval();
        timeInterval.start();
        final XWPFDocument xwpfDocument = appendBody(path1, list);

        OutputStream dest = new FileOutputStream("/Users/lichunxia/Documents/work/素材/many-merged.docx");
        xwpfDocument.write(dest);
        final long seconds = timeInterval.intervalSecond();
        System.out.println("done with second " + seconds);
    }

    private static XWPFDocument appendBody(String srcDocPath, Collection<String> appendDocPaths) throws Exception {
        FileInputStream srcStream = new FileInputStream(srcDocPath);
        XWPFDocument srcDoc = new XWPFDocument(srcStream);
        CTBody srcBody = srcDoc.getDocument().getBody();
        int count = 0;
        int group = 1;
        for (String appendDocPath : appendDocPaths) {
            final FileInputStream fileInputStream = new FileInputStream(appendDocPath);
            final XWPFDocument appendDoc = new XWPFDocument(fileInputStream);
            final CTBody appendBody = appendDoc.getDocument().getBody();

            final XWPFParagraph paragraph = srcDoc.createParagraph();
            paragraph.setPageBreak(true);
            appendBody(srcBody, appendBody);
            fileInputStream.close();
            appendDoc.close();

            count++;
            if (count == 1) {
                group++;
                System.out.println("group:" + group);
                count = 0;
                final File file = File.createTempFile("templateDoc", ".docx");
                final OutputStream outputStream = new FileOutputStream(file);
                srcDoc.write(outputStream);
                srcStream.close();
                srcDoc.close();
                srcStream = new FileInputStream(file);
                srcDoc = new XWPFDocument(srcStream);
                srcBody = srcDoc.getDocument().getBody();
            }
        }
        return srcDoc;
    }

    private static void appendBody(CTBody src, CTBody append) throws Exception {
        XmlOptions optionsOuter = new XmlOptions();
        optionsOuter.setSaveOuter();
        String appendString = append.xmlText(optionsOuter);
        String srcString = src.xmlText();
        String prefix = srcString.substring(0, srcString.indexOf(">") + 1);
        String mainPart = srcString.substring(srcString.indexOf(">") + 1, srcString.lastIndexOf("<"));
        String sufix = srcString.substring(srcString.lastIndexOf("<"));
        String addPart = appendString.substring(appendString.indexOf(">") + 1, appendString.lastIndexOf("<"));
        CTBody makeBody = CTBody.Factory.parse(prefix + mainPart + addPart + sufix);
        src.set(makeBody);
    }
}
