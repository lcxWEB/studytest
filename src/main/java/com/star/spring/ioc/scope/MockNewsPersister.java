package com.star.spring.ioc.scope;

import com.star.spring.ioc.FXNewsBean;
import com.star.spring.ioc.IFXNewsPersister;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;

/**
 * @Author: lcx
 * @Date: 2019/2/19 16:08
 * @Description:
 */

public class MockNewsPersister implements IFXNewsPersister, BeanFactoryAware {

    private BeanFactory beanFactory;

    private FXNewsBean newsBean;

    @Override
    public void persistNews(FXNewsBean newsBean) {
        persistNews();
    }

    public void persistNews() {
        System.out.println("Persist bean：" + getNewsBean());
    }

    public FXNewsBean getNewsBean() {
        // return newsBean;
        return (FXNewsBean) beanFactory.getBean("newsBean");
    }

    public void setNewsBean(FXNewsBean newsBean) {
        this.newsBean = newsBean;
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }
}
