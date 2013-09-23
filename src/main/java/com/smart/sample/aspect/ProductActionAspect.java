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
    protected void begin(Method method, Object[] args) {
        if (logger.isInfoEnabled()) {
            logger.info("---------- Begin ----------");
        }
    }

    @Override
    protected boolean filter(Method method, Object[] args) {
        return method.getName().equals("getProducts");
    }

    @Override
    protected void before(Method method, Object[] args) {
        begin = System.currentTimeMillis();
    }

    @Override
    protected void after(Method method, Object[] args) {
        logger.info("Time: " + (System.currentTimeMillis() - begin) + "ms");
    }

    @Override
    protected void error(Method method, Object[] args, Exception e) {
        logger.info("Error: " + e.getMessage());
    }

    @Override
    protected void end(Method method, Object[] args) {
        if (logger.isInfoEnabled()) {
            logger.info("----------- End -----------");
        }
    }
}
