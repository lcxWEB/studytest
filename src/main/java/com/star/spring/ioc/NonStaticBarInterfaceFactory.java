package com.star.spring.ioc;

/**
 * @Author: lcx
 * @Date: 2019/2/19 11:09
 * @Description:
 */

public class NonStaticBarInterfaceFactory
{
    public IFXNewsPersister getInstance()
    {
        return new DowJonesNewsPersister();
    }

    public IFXNewsPersister getInstance(FXNewsBean fxNewsBean)
    {
        return new DowJonesNewsPersister();
    }
}
