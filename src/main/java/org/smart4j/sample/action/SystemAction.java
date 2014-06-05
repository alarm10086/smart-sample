package org.smart4j.sample.action;

import org.smart4j.framework.mvc.DataContext;
import org.smart4j.framework.mvc.annotation.Action;
import org.smart4j.framework.mvc.annotation.GET;
import org.smart4j.framework.mvc.annotation.POST;
import org.smart4j.framework.mvc.bean.Params;
import org.smart4j.framework.mvc.bean.Result;
import org.smart4j.framework.mvc.bean.View;
import org.smart4j.framework.util.StringUtil;
import org.smart4j.framework.util.WebUtil;
import org.smart4j.plugin.security.SecurityHelper;
import org.smart4j.plugin.security.fault.LoginException;
import org.smart4j.sample.Constant;

@Action
public class SystemAction {

    @GET("/captcha")
    public void captcha() {
        String captcha = WebUtil.createCaptcha(DataContext.getResponse());
        DataContext.Session.put(Constant.CAPTCHA, captcha);
    }

    @GET("/login")
    public View login() {
        return new View("login.jsp");
    }

    @POST("/login")
    public Result login(Params params) {
        String username = params.getString("username");
        String password = params.getString("password");
        String captcha = params.getString("captcha");

        String sessionCaptcha = DataContext.Session.get(Constant.CAPTCHA);
        if (StringUtil.isNotEmpty(sessionCaptcha) && !sessionCaptcha.equals(captcha)) {
            return new Result(false).data("captcha_error");
        }

        try {
            SecurityHelper.login(username, password, false);
        } catch (LoginException e) {
            return new Result(false);
        }

        return new Result(true);
    }

    @GET("/logout")
    public Result logout() {
        SecurityHelper.logout();
        return new Result(true);
    }
}
