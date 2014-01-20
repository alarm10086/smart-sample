package com.smart.sample.aspect;

import com.smart.framework.DataContext;
import com.smart.framework.annotation.Aspect;
import com.smart.framework.annotation.Order;
import com.smart.framework.exception.AccessException;
import com.smart.framework.proxy.AspectProxy;
import com.smart.framework.util.WebUtil;
import com.smart.sample.Constant;
import com.smart.sample.action.SystemAction;
import java.lang.reflect.Method;

@Aspect(pkg = "com.smart.sample.action")
@Order(0)
public class AccessAspect extends AspectProxy {

    @Override
    public boolean intercept(Class<?> cls, Method method, Object[] params) throws Throwable {
        boolean result = true;
        if (cls == SystemAction.class) {
            result = false;
        }
        return result;
    }

    @Override
    public void before(Class<?> cls, Method method, Object[] params) throws Throwable {
        Long userId = DataContext.Session.get(Constant.USER_ID);
        if (userId == null) {
            WebUtil.setRedirectURL(DataContext.getRequest(), Constant.REDIRECT_URL);
            throw new AccessException();
        }
    }
}
