package com.star.spring.ioc.scope;

import org.springframework.beans.factory.config.CustomEditorConfigurer;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.UrlResource;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @Author: lcx
 * @Date: 2019/2/19 16:12
 * @Description:
 */

public class ScopeTest {

    public static void main(String[] args) {

        // XmlBeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("news-config.xml"));
        //
        // CustomEditorConfigurer ceConfigurer = new CustomEditorConfigurer();
        // Map customerEditors = new HashMap();
        // customerEditors.put(java.util.Date.class, new DatePropertyEditor());
        // ceConfigurer.setCustomEditors(customerEditors);
        // ceConfigurer.postProcessBeanFactory(beanFactory);

        ApplicationContext context = new ClassPathXmlApplicationContext("news-config.xml");

        // MockNewsPersister newsPersister = (MockNewsPersister) context.getBean("mockPersister");
        // newsPersister.persistNews();
        // newsPersister.persistNews();
        // FXNewsProvider newsProvider = (FXNewsProvider) context.getBean("djNewsProvider");
        // newsProvider.getAndPersistNews();

        DateFoo dateFoo = (DateFoo) context.getBean("dateFoo");
        System.out.println(dateFoo.getDate());

        ((ClassPathXmlApplicationContext) context).close();

        // 初始化bean
        // ((ClassPathXmlApplicationContext) context).refresh();
        //
        // dateFoo = (DateFoo) context.getBean("dateFoo");
        // System.out.println(dateFoo.getDate());
        //
        // System.out.println("dsds" + null);

        ResourceLoader resourceLoader = new ClassPathXmlApplicationContext("news-config.xml");
        // 或者
        // ResourceLoader resourceLoader = new FileSystemXmlApplicationContext("配置文件路径");
        Resource fileResource = resourceLoader.getResource("D:/springbootproject/src/main/resources/aplication2.xml");
        assertTrue(fileResource instanceof ClassPathResource);
        assertFalse(fileResource.exists());
        Resource urlResource2 = resourceLoader.getResource("http://www.spring21.cn");
        assertTrue(urlResource2 instanceof UrlResource);
    }

}
