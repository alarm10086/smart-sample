package com.smart.sample.action;

import com.smart.framework.DataContext;
import com.smart.framework.annotation.Action;
import com.smart.framework.annotation.Inject;
import com.smart.framework.annotation.Request;
import com.smart.framework.bean.Result;
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

    @Request("GET:/captcha")
    public void captcha() {
        // 创建验证码
        String captcha = WebUtil.createCaptcha(DataContext.getResponse());
        // 将验证码放入 Session 中
        DataContext.Session.put(Constant.CAPTCHA, captcha);
    }

    @Request("POST:/login")
    public Result login(Map<String, Object> fieldMap) {
        // 获取请求参数
        String username = CastUtil.castString(fieldMap.get("username"));
        String password = CastUtil.castString(fieldMap.get("password"));
        String captcha = CastUtil.castString(fieldMap.get("captcha"));
        // 判断验证码是否正确
        String sessionCaptcha = DataContext.Session.get(Constant.CAPTCHA);
        if (!sessionCaptcha.equals(captcha)) {
            // 若验证码错误，则返回指定的失败标志
            return new Result(false).data("captcha_error");
        }
        // 判断用户是否存在
        User user = userService.login(username, password);
        if (user == null) {
            // 若用户不存在，则返回失败标志
            return new Result(false);
        }
        // 将 用户ID 放入 Session 中
        DataContext.Session.put(Constant.USER_ID, user.getId());
        // 从 Session 中获取 REDIRECT_URL，并判断 REDIRECT_URL 是否存在
        String redirectURL = DataContext.Session.get(Constant.REDIRECT_URL);
        if (StringUtil.isNotEmpty(redirectURL)) {
            // 若 REDIRECT_URL 已存在，则首先从 Session 中移除 REDIRECT_URL，然后将 REDIRECT_URL 作为数据返回
            DataContext.Session.remove(Constant.REDIRECT_URL);
            return new Result(true).data(redirectURL);
        }
        // 返回成功标志
        return new Result(true);
    }

    @Request("GET:/logout")
    public Result logout() {
        DataContext.Session.removeAll();
        return new Result(true);
    }
}
