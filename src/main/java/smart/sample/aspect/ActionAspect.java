package smart.sample.aspect;

import java.lang.reflect.Method;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import smart.framework.annotation.Action;
import smart.framework.annotation.Aspect;
import smart.framework.proxy.AspectProxy;

@Aspect(annotation = Action.class)
public class ActionAspect extends AspectProxy {

    private static final Logger logger = LoggerFactory.getLogger(ActionAspect.class);

    private long begin;

    @Override
    public void before(Class<?> cls, Method method, Object[] params) throws Throwable {
        if (logger.isDebugEnabled()) {
            logger.debug("---------- begin ----------");
        }
        begin = System.currentTimeMillis();
    }

    @Override
    public void after(Class<?> cls, Method method, Object[] params, Object result) throws Throwable {
        logger.info("time: " + (System.currentTimeMillis() - begin) + "ms");
        if (logger.isDebugEnabled()) {
            logger.debug("----------- end -----------");
        }
    }
}
