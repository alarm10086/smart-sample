package com.smart.sample.aspect;

import com.smart.framework.AuthException;
import com.smart.framework.DataContext;
import com.smart.framework.annotation.Aspect;
import com.smart.framework.base.BaseAspect;
import com.smart.sample.action.UserAction;
import com.smart.sample.entity.User;
import java.lang.reflect.Method;

@Aspect(pkg = "com.smart.sample.action")
public class AuthAspect extends BaseAspect {

    @Override
    public boolean filter(Class<?> cls, Method method, Object[] args) {
        return !(cls.equals(UserAction.class) &&
            (method.getName().equals("login") || method.getName().equals("logout"))
        );
    }

    @Override
    public void before(Method method, Object[] args) {
        User user = DataContext.Session.get("user");
        if (user == null) {
            throw new AuthException();
        }
    }
}
