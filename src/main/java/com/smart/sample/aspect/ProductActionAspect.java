package com.smart.sample.aspect;

import com.smart.framework.annotation.Aspect;
import com.smart.framework.annotation.Bean;
import com.smart.framework.base.BaseAspect;
import java.lang.reflect.Method;
import org.apache.log4j.Logger;

@Bean
@Aspect(pkg = "com.smart.sample.action", cls = "ProductAction")
public class ProductActionAspect extends BaseAspect {

    private static final Logger logger = Logger.getLogger(ProductActionAspect.class);

    private long begin;

    @Override
    public boolean filter(Class<?> cls, Method method, Object[] args) {
        return method.getName().equals("list");
    }

    @Override
    public void before(Method method, Object[] args) {
        if (logger.isInfoEnabled()) {
            logger.info("---------- Begin ----------");
        }
        begin = System.currentTimeMillis();
    }

    @Override
    public void after(Method method, Object[] args) {
        logger.info("Time: " + (System.currentTimeMillis() - begin) + "ms");
        if (logger.isInfoEnabled()) {
            logger.info("----------- End -----------");
        }
    }

    @Override
    public void error(Method method, Object[] args, Exception e) {
        logger.info("Error: " + e.getMessage());
    }
}
