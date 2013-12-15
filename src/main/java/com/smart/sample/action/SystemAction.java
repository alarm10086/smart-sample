package com.smart.sample.action;

import com.smart.framework.DataContext;
import com.smart.framework.annotation.Bean;
import com.smart.framework.annotation.Inject;
import com.smart.framework.annotation.Request;
import com.smart.framework.base.BaseAction;
import com.smart.framework.bean.Result;
import com.smart.framework.util.StringUtil;
import com.smart.sample.Constant;
import com.smart.sample.entity.User;
import com.smart.sample.service.UserService;
import java.util.Map;

@Bean
public class SystemAction extends BaseAction {

    @Inject
    private UserService userService;

    @Request("post:/login")
    public Result login(Map<String, Object> fieldMap) {
        User user = userService.login(fieldMap);
        if (user != null) {
            DataContext.Session.put("user", user);
            String redirectURL = DataContext.Session.get(Constant.REDIRECT_URL);
            if (StringUtil.isNotEmpty(redirectURL)) {
                DataContext.Session.remove(Constant.REDIRECT_URL);
                return new Result(true).data(redirectURL);
            } else {
                return new Result(true);
            }
        } else {
            return new Result(false);
        }
    }

    @Request("get:/logout")
    public Result logout() {
        DataContext.Session.removeAll();
        return new Result(true);
    }
}
