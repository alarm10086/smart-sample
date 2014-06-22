package org.smart4j.sample.aspect;

import java.lang.reflect.Method;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smart4j.framework.aop.AspectProxy;
import org.smart4j.framework.aop.annotation.Aspect;
import org.smart4j.framework.mvc.annotation.Action;

@Aspect(annotation = Action.class)
public class ActionAspect extends AspectProxy {

    private static final Logger logger = LoggerFactory.getLogger(ActionAspect.class);

    private long begin;

    @Override
    public void before(Class<?> cls, Method method, Object[] params) throws Throwable {
        logger.debug("---------- begin ----------");
        begin = System.currentTimeMillis();
    }

    @Override
    public void after(Class<?> cls, Method method, Object[] params, Object result) throws Throwable {
        logger.debug("time: " + (System.currentTimeMillis() - begin) + "ms");
        logger.debug("----------- end -----------");
    }
}
