package com.star.dom4j;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.*;

/**
 * Created by lcx on 2018/10/19.
 */
public class HRWriter {

    public void writeXml(){
        String file = "D:\\springbootproject\\src\\main\\resources\\test.xml";

        SAXReader reader = new SAXReader();

        try {
            Document document = reader.read(file);
            //            获取根节点,hr
            Element root = document.getRootElement();
            Element employee = root.addElement("employee");
            employee.addAttribute("no", "3311");
            Element name = employee.addElement("name");
            name.setText("莉莉");
            employee.addElement("salary").setText("3600");

            Writer writer = new OutputStreamWriter(new FileOutputStream(file), "UTF-8");
            document.write(writer);
            writer.close();
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        HRWriter writer = new HRWriter();
        writer.writeXml();
    }
}
