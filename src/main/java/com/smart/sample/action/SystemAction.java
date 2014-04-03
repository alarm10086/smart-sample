package com.smart.sample.action;

import com.smart.framework.DataContext;
import com.smart.framework.annotation.Action;
import com.smart.framework.annotation.Inject;
import com.smart.framework.annotation.Request;
import com.smart.framework.bean.Param;
import com.smart.framework.bean.Result;
import com.smart.framework.bean.View;
import com.smart.framework.util.WebUtil;
import com.smart.sample.Constant;
import com.smart.sample.service.UserService;
import com.smart.security.SmartSecurityHelper;
import com.smart.security.exception.LoginException;

@Action
public class SystemAction {

    @Inject
    private UserService userService;

    @Request.Get("/captcha")
    public void captcha() {
        String captcha = WebUtil.createCaptcha(DataContext.getResponse());
        DataContext.Session.put(Constant.CAPTCHA, captcha);
    }

    @Request.Get("/login")
    public View login() {
        return new View("login.jsp");
    }

    @Request.Post("/login")
    public Result login(Param param) {
        String username = param.getString("username");
        String password = param.getString("password");
        String captcha = param.getString("captcha");

        String sessionCaptcha = DataContext.Session.get(Constant.CAPTCHA);
        if (!sessionCaptcha.equals(captcha)) {
            return new Result(false).data("captcha_error");
        }

        try {
            SmartSecurityHelper.login(username, password, false);
        } catch (LoginException e) {
            return new Result(false);
        }

        return new Result(true);
    }

    @Request.Get("/logout")
    public Result logout() {
        SmartSecurityHelper.logout();
        return new Result(true);
    }
}
