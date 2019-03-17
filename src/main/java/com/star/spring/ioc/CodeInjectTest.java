package com.star.spring.ioc;

import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.ConstructorArgumentValues;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

/**
 * @Author: lcx
 * @Date: 2019/2/18 17:21
 * @Description:
 */

public class CodeInjectTest {

    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        // BeanFactory container = bindViaCode(beanFactory);
        BeanFactory container = bindViaXMLFile(beanFactory);
        FXNewsProvider newsProvider = (FXNewsProvider) container.getBean("djNewsProvider");
        System.out.println("从容器里获取的BEAN：" + newsProvider);
        System.out.println(newsProvider.getNewsListener());
        System.out.println(newsProvider.getNewsPersister());
        System.out.println(newsProvider.getValueSet());
        System.out.println(newsProvider.getValueMap());
        System.out.println(newsProvider.getProperties());
        System.out.println(newsProvider.getStr());
        newsProvider.getAndPersistNews();

        NextDayDateDisplayer dayDateDisplayer = (NextDayDateDisplayer) container.getBean("nextDayDateDisplayer");
        System.out.println(dayDateDisplayer.getDateOfNextDay());

    }

    public static BeanFactory bindViaCode(BeanDefinitionRegistry registry) {

        AbstractBeanDefinition newsProvider = new RootBeanDefinition(FXNewsProvider.class);
        AbstractBeanDefinition newsListener = new RootBeanDefinition(DowJonesNewsListener.class);
        AbstractBeanDefinition newsPersister = new RootBeanDefinition(DowJonesNewsPersister.class);

        System.out.println(newsProvider);
        System.out.println(newsListener);
        System.out.println(newsPersister);

        //将 bean定义 注册到容器中
        registry.registerBeanDefinition("djNewsProvider", newsProvider);
        // registry.registerBeanDefinition("djNewsListener", newsListener);
        // registry.registerBeanDefinition("djNewsPersister", newsPersister);

        //1. 通过构造方法注入方式
        ConstructorArgumentValues argValues = new ConstructorArgumentValues();
        argValues.addIndexedArgumentValue(0, newsListener);
        argValues.addIndexedArgumentValue(1, newsPersister);
        newsProvider.setConstructorArgumentValues(argValues);

        //2. 通过setter方法注入方式
        MutablePropertyValues propertyValues = new MutablePropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("newsListener", newsListener));
        propertyValues.addPropertyValue(new PropertyValue("newsPersister", newsPersister));
        newsProvider.setPropertyValues(propertyValues);
        // 绑定完成
        return (BeanFactory) registry;

    }

    public static BeanFactory bindViaXMLFile(BeanDefinitionRegistry registry)
    {
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(registry);
        reader.loadBeanDefinitions("classpath:news-config.xml");
        return (BeanFactory)registry;
        // return new XmlBeanFactory(new ClassPathResource("news-config.xml"));
    }


}
