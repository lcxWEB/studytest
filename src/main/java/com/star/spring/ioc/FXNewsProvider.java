package com.star.spring.ioc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * @Author: lcx
 * @Date: 2019/2/18 17:12
 * @Description:
 */
@Component("djNewsProvider")
public class FXNewsProvider {

    @Autowired
    @Qualifier("dJNewsListener")
    private IFXNewsListener newsListener;
    @Resource
    private IFXNewsPersister newsPersister;

    private Set valueSet;

    private Map valueMap;

    private Properties properties;

    private String str;

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public Map getValueMap() {
        return valueMap;
    }

    public void setValueMap(Map valueMap) {
        this.valueMap = valueMap;
    }

    public Set getValueSet() {
        return valueSet;
    }

    public void setValueSet(Set valueSet) {
        this.valueSet = valueSet;
    }

    // 使用<property>进行依赖注入时必须有无参构造函数
    public FXNewsProvider() {
    }

    public FXNewsProvider(IFXNewsListener newsListener, IFXNewsPersister newsPersister) {
        this.newsListener = newsListener;
        this.newsPersister = newsPersister;
    }

    public void setNewsListener(IFXNewsListener newsListener) {
        this.newsListener = newsListener;
    }

    public void setNewsPersister(IFXNewsPersister newsPersister) {
        this.newsPersister = newsPersister;
    }

    public IFXNewsListener getNewsListener() {
        return newsListener;
    }

    public IFXNewsPersister getNewsPersister() {
        return newsPersister;
    }

    public void getAndPersistNews() {
        System.out.println("执行 getAndPersistNews ====== ");
        String[] newsIds = newsListener.getAvailableNewsIds();
        if (CollectionUtils.isEmpty(Arrays.asList(newsIds))) {
            return;
        }
        for (String newsId : newsIds) {
            FXNewsBean newsBean = newsListener.getNewsByPK(newsId);
            newsPersister.persistNews(newsBean);
            newsListener.postProcessIfNecessary(newsId);
        }
    }
}
