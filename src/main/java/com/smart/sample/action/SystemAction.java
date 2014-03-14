package com.smart.sample.action;

import com.smart.framework.DataContext;
import com.smart.framework.annotation.Action;
import com.smart.framework.annotation.Inject;
import com.smart.framework.annotation.Request;
import com.smart.framework.bean.Result;
import com.smart.framework.bean.View;
import com.smart.framework.util.CastUtil;
import com.smart.framework.util.StringUtil;
import com.smart.framework.util.WebUtil;
import com.smart.sample.Constant;
import com.smart.sample.entity.User;
import com.smart.sample.service.UserService;
import java.util.Map;

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
    public Result login(Map<String, Object> fieldMap) {
        String username = CastUtil.castString(fieldMap.get("username"));
        String password = CastUtil.castString(fieldMap.get("password"));
        String captcha = CastUtil.castString(fieldMap.get("captcha"));

        String sessionCaptcha = DataContext.Session.get(Constant.CAPTCHA);
        if (!sessionCaptcha.equals(captcha)) {
            return new Result(false).data("captcha_error");
        }

        User user = userService.login(username, password);
        if (user == null) {
            return new Result(false);
        }

        DataContext.Session.put(Constant.USER_ID, user.getId());
        String redirectURL = DataContext.Session.get(Constant.REDIRECT_URL);
        if (StringUtil.isNotEmpty(redirectURL)) {
            DataContext.Session.remove(Constant.REDIRECT_URL);
            return new Result(true).data(redirectURL);
        }

        return new Result(true);
    }

    @Request.Get("/logout")
    public Result logout() {
        DataContext.Session.removeAll();
        return new Result(true);
    }
}
