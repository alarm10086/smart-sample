package smart.sample.action;

import smart.framework.DataContext;
import smart.framework.annotation.Action;
import smart.framework.annotation.Inject;
import smart.framework.annotation.Request;
import smart.framework.bean.Params;
import smart.framework.bean.Result;
import smart.framework.bean.View;
import smart.framework.util.WebUtil;
import smart.sample.Constant;
import smart.sample.service.UserService;
import smart.security.SmartSecurityHelper;
import smart.security.exception.LoginException;

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
    public Result login(Params params) {
        String username = params.getString("username");
        String password = params.getString("password");
        String captcha = params.getString("captcha");

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
