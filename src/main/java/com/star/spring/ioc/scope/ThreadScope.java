package com.star.spring.ioc.scope;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.config.Scope;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: lcx
 * @Date: 2019/2/19 10:20
 * @Description:
 */

public class ThreadScope implements Scope {

    private final ThreadLocal threadScope = new ThreadLocal() {
        @Override
        protected Object initialValue() {
            return new HashMap();
        }
    };

    @Override
    public Object get(String name, ObjectFactory objectFactory) {
        Map scope = (Map) threadScope.get();
        Object object = scope.get(name);
        if (object == null) {
            object = objectFactory.getObject();
            scope.put(name, object);
        }
        return object;
    }

    @Override
    public Object remove(String name) {
        Map scope = (Map) threadScope.get();
        return scope.remove(name);
    }

    @Override
    public void registerDestructionCallback(String name, Runnable callback) {

    }

    @Override
    public Object resolveContextualObject(String key) {
        return null;
    }

    @Override
    public String getConversationId() {
        return null;
    }

}
