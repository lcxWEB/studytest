package com.star.spring.ioc;

import org.springframework.stereotype.Component;

/**
 * @Author: lcx
 * @Date: 2019/2/18 17:18
 * @Description:
 */
@Component("dJNewsListener")
public class DowJonesNewsListener implements IFXNewsListener {

    @Override
    public String[] getAvailableNewsIds() {
        return new String[0];
    }

    @Override
    public FXNewsBean getNewsByPK(String newsId) {
        return null;
    }

    @Override
    public void postProcessIfNecessary(String newsId) {

    }
}
