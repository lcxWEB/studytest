package com.star.spring.ioc;

import org.springframework.stereotype.Component;

/**
 * @Author: lcx
 * @Date: 2019/2/18 17:19
 * @Description:
 */
@Component
public class DowJonesNewsPersister implements IFXNewsPersister {

    @Override
    public void persistNews(FXNewsBean newsBean) {

    }
}
