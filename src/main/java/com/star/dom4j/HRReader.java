package com.star.dom4j;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.List;

/**
 * Created by lcx on 2018/10/19.
 */
public class HRReader {


    public void readXml() {

        String file = "D:\\springbootproject\\src\\main\\resources\\test.xml";

        SAXReader reader = new SAXReader();
        try {
            Document document = reader.read(file);
//            获取根节点
            Element root = document.getRootElement();
//            elements用于获取指定的标签集合
            List<Element> employees = root.elements("employee");

            for (Element element:employees){
//           element用于获取唯一的子节点对象
                Element name = element.element("name");
//                获取标签的文本值
                String namevalue = name.getText();
//                System.out.println(namevalue);
                System.out.println(element.elementText("name"));
                System.out.println(element.elementText("age"));
                Attribute attribute = element.attribute("no");
                System.out.println(attribute.getText());

            }

        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        HRReader reader = new HRReader();
        reader.readXml();
    }
}
