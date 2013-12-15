package com.smart.sample.aspect;

import com.smart.framework.DataContext;
import com.smart.framework.annotation.Aspect;
import com.smart.framework.annotation.Bean;
import com.smart.framework.annotation.Order;
import com.smart.framework.base.BaseAspect;
import com.smart.framework.exception.AccessException;
import com.smart.sample.Constant;
import com.smart.sample.entity.User;
import java.lang.reflect.Method;
import javax.servlet.http.HttpServletRequest;

@Bean
@Aspect(pkg = "com.smart.sample.action")
@Order(0)
public class AccessAspect extends BaseAspect {

    @Override
    public boolean intercept(Class<?> cls, Method method, Object[] params) throws Exception {
        String className = cls.getSimpleName();
        String methodName = method.getName();
        return !(
            className.equals("SystemAction") &&
                (methodName.equals("login") || methodName.equals("logout")
                )
        );
    }

    @Override
    public void before(Class<?> cls, Method method, Object[] params) throws Exception {
        User user = DataContext.Session.get("user");
        if (user == null) {
            HttpServletRequest request = DataContext.getRequest();
            String requestPath = request.getRequestURL().toString();
            DataContext.Session.put(Constant.REDIRECT_URL, requestPath);
            throw new AccessException();
        }
    }
}
