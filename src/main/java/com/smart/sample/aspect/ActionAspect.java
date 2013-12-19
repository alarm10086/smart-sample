package com.smart.sample.aspect;

import com.smart.framework.annotation.Aspect;
import com.smart.framework.annotation.Order;
import com.smart.framework.base.BaseAspect;
import java.lang.reflect.Method;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect(pkg = "com.smart.sample.action")
@Order(1)
public class ActionAspect extends BaseAspect {

    private static final Logger logger = LoggerFactory.getLogger(ActionAspect.class);

    private long begin;

    @Override
    public void before(Class<?> cls, Method method, Object[] params) throws Exception {
        if (logger.isDebugEnabled()) {
            logger.debug("---------- begin ----------");
        }
        begin = System.currentTimeMillis();
    }

    @Override
    public void after(Class<?> cls, Method method, Object[] params, Object result) throws Exception {
        logger.info("time: " + (System.currentTimeMillis() - begin) + "ms");
        if (logger.isDebugEnabled()) {
            logger.debug("----------- end -----------");
        }
    }
}
