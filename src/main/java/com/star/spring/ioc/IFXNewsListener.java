package com.star.spring.ioc;

/**
 * @Author: lcx
 * @Date: 2019/2/18 17:13
 * @Description:
 */

public interface IFXNewsListener {

    String[] getAvailableNewsIds();

    FXNewsBean getNewsByPK(String newsId);

    void postProcessIfNecessary(String newsId);

}
