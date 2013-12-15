package com.smart.sample.aspect;

import com.smart.framework.annotation.Aspect;
import com.smart.framework.annotation.Bean;
import com.smart.framework.annotation.Order;
import com.smart.framework.base.BaseAspect;
import java.lang.reflect.Method;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Bean
@Aspect(pkg = "com.smart.sample.service.impl", cls = "ProductServiceImpl")
@Order(2)
public class ProductServiceAspect extends BaseAspect {

    private static final Logger logger = LoggerFactory.getLogger(ProductServiceAspect.class);

    @Override
    public void before(Class<?> cls, Method method, Object[] params) throws Exception {
        if (logger.isDebugEnabled()) {
            logger.debug("[Before]");
        }
    }

    @Override
    public void after(Class<?> cls, Method method, Object[] params, Object result) throws Exception {
        if (logger.isDebugEnabled()) {
            logger.debug("[After]");
        }
    }
}
