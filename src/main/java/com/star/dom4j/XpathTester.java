package com.star.dom4j;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import java.util.List;

/**
 * Created by lcx on 2018/10/19.
 */
public class XpathTester {

    public void xpath(String xpathExp){

        String file = "D:\\springbootproject\\src\\main\\resources\\test.xml";

        SAXReader saxReader = new SAXReader();

        try {
            Document document = saxReader.read(file);
            List<Node> nodes = document.selectNodes(xpathExp);
            for (Node n : nodes){
                Element element = (Element) n;
                System.out.println(element.attributeValue("no"));
                System.out.println(element.elementText("name"));
                System.out.println(element.elementText("age"));
                System.out.println(element.elementText("salary"));
                System.out.println("~~~~~~~~~~~~");
            }
            System.out.println("===================");
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        XpathTester xpathTester = new XpathTester();
//        xpathTester.xpath("/hr/employee");
//        xpathTester.xpath("//employee");
//
//        xpathTester.xpath("/hr/employee[2]");
//        xpathTester.xpath("//employee[salary<1000]");
//        通过子节点筛选
//        xpathTester.xpath("//employee[name='莉莉']");
//        通过属性筛选
//        xpathTester.xpath("//employee[@no=3311]");
//        xpathTester.xpath("//employee[last()]");
//        通过位置筛选
//        xpathTester.xpath("//employee[position()<2]");
        xpathTester.xpath("//employee[1] | //employee[3]");
    }

}
