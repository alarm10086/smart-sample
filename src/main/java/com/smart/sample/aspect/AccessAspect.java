package com.smart.sample.aspect;

import com.smart.framework.DataContext;
import com.smart.framework.annotation.Aspect;
import com.smart.framework.annotation.Bean;
import com.smart.framework.annotation.Order;
import com.smart.framework.base.BaseAspect;
import com.smart.framework.exception.AccessException;
import com.smart.framework.util.ArrayUtil;
import com.smart.framework.util.WebUtil;
import com.smart.sample.Constant;
import java.lang.reflect.Method;

@Bean
@Aspect(pkg = "com.smart.sample.action")
@Order(0)
public class AccessAspect extends BaseAspect {

    @Override
    public boolean intercept(Class<?> cls, Method method, Object[] params) throws Exception {
        // 获取类名与方法名
        String className = cls.getSimpleName();
        String methodName = method.getName();
        // 排除特定类的特定方法（无需进行 AOP 拦截）
        boolean result = true; // 默认为需要拦截
        if (className.equals("SystemAction")) {
            String[] methodNames = {"captcha", "login", "logout"};
            if (ArrayUtil.contains(methodNames, methodName)) {
                result = false; // 设置为无需拦截
            }
        }
        return result;
    }

    @Override
    public void before(Class<?> cls, Method method, Object[] params) throws Exception {
        // 从 Session 中获取 USER_ID，并判断 USER_ID 是否存在
        Long userId = DataContext.Session.get(Constant.USER_ID);
        if (userId == null) {
            // 若 USER_ID 不存在（说明该用户未登录），则设置 REDIRECT_URL 到 Session 中
            WebUtil.setRedirectURL(DataContext.getRequest(), Constant.REDIRECT_URL);
            // 抛出访问异常
            throw new AccessException();
        }
    }
}
