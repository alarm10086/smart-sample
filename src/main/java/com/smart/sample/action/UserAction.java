package com.smart.sample.action;

import com.smart.framework.DataContext;
import com.smart.framework.annotation.Bean;
import com.smart.framework.annotation.Inject;
import com.smart.framework.annotation.Request;
import com.smart.framework.base.BaseAction;
import com.smart.framework.bean.Result;
import com.smart.sample.entity.User;
import com.smart.sample.service.UserService;
import java.util.Map;

@Bean
public class UserAction extends BaseAction {

    @Inject
    private UserService userService;

    @Request("post:/login")
    public Result login(Map<String, Object> fieldMap) {
        User user = userService.login(fieldMap);
        if (user != null) {
            DataContext.put("user", user); // 将 user 对象放入 Session 中
            return new Result(true).data(user);
        } else {
            return new Result(false).error(ERROR_DATA);
        }
    }
}
