package com.smart.sample.aspect;

import com.smart.framework.AuthException;
import com.smart.framework.DataContext;
import com.smart.framework.annotation.Aspect;
import com.smart.framework.base.BaseAspect;
import com.smart.sample.action.UserAction;
import com.smart.sample.entity.User;

@Aspect(pkg = "com.smart.sample.action")
public class AuthAspect extends BaseAspect {

    @Override
    public boolean filter(String className, String methodName) {
        return !(className.equals(UserAction.class.getName()) && (methodName.equals("login") || methodName.equals("logout")));
    }

    @Override
    public void before(String className, String methodName) {
        User user = DataContext.Session.get("user");
        if (user == null) {
            throw new AuthException();
        }
    }
}
