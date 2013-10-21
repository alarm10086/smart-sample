package com.smart.sample.aspect;

import com.smart.framework.annotation.Aspect;
import com.smart.framework.annotation.Bean;
import com.smart.framework.base.BaseAspect;
import org.apache.log4j.Logger;

@Bean
@Aspect(pkg = "com.smart.sample.action", cls = "ProductAction")
public class ProductActionAspect extends BaseAspect {

    private static final Logger logger = Logger.getLogger(ProductActionAspect.class);

    private long begin;

    @Override
    public boolean filter(String className, String methodName) {
        return methodName.equals("index");
    }

    @Override
    public void before(String className, String methodName) {
        if (logger.isDebugEnabled()) {
            logger.debug("---------- Begin ----------");
        }
        begin = System.currentTimeMillis();
    }

    @Override
    public void after(String className, String methodName) {
        logger.info("Time: " + (System.currentTimeMillis() - begin) + "ms");
        if (logger.isDebugEnabled()) {
            logger.debug("----------- End -----------");
        }
    }

    @Override
    public void error(String className, String methodName, Exception e) {
        logger.info("Error: " + e.getMessage());
    }
}
