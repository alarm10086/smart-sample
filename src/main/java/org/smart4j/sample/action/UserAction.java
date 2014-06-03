package org.smart4j.sample.action;

import java.util.List;
import java.util.Map;
import org.smart4j.framework.ioc.annotation.Inject;
import org.smart4j.framework.mvc.DataContext;
import org.smart4j.framework.mvc.annotation.Action;
import org.smart4j.framework.mvc.annotation.Request;
import org.smart4j.framework.mvc.bean.Params;
import org.smart4j.framework.mvc.bean.Result;
import org.smart4j.framework.mvc.bean.View;
import org.smart4j.plugin.security.annotation.HasRoles;
import org.smart4j.sample.entity.User;
import org.smart4j.sample.service.UserService;

@Action
@HasRoles("admin")
public class UserAction {

    @Inject
    private UserService userService;

    @Request.Get("/users")
    public View index() {
        List<User> userList = userService.findUserList();
        DataContext.Request.put("userList", userList);
        return new View("user.jsp");
    }

    @Request.Post("/users")
    public View search(Params params) {
        String username = params.getString("username");
        List<User> userList = userService.findUserListByUsername(username);
        DataContext.Request.put("userList", userList);
        return new View("user_list.jsp");
    }

    @Request.Get("/user")
    public View create() {
        return new View("user_create.jsp");
    }

    @Request.Post("/user")
    public Result save(Params params) {
        Map<String, Object> fieldMap = params.getFieldMap();
        boolean result = userService.saveUser(fieldMap);
        return new Result(result);
    }

    @Request.Get("/user/{id}")
    public View edit(long id) {
        User user = userService.findUser(id);
        DataContext.Request.put("user", user);
        return new View("user_edit.jsp");
    }

    @Request.Put("/user/{id}")
    public Result update(long id, Params params) {
        Map<String, Object> fieldMap = params.getFieldMap();
        boolean result = userService.updateUser(id, fieldMap);
        return new Result(result);
    }

    @Request.Delete("/user/{id}")
    public Result delete(long id) {
        boolean result = userService.deleteUser(id);
        return new Result(result);
    }
}
