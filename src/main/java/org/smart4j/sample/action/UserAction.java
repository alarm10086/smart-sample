package org.smart4j.sample.action;

import java.util.List;
import org.smart4j.framework.ioc.annotation.Inject;
import org.smart4j.framework.mvc.DataContext;
import org.smart4j.framework.mvc.annotation.Action;
import org.smart4j.framework.mvc.annotation.Request;
import org.smart4j.framework.mvc.bean.View;
import org.smart4j.sample.entity.User;
import org.smart4j.sample.service.UserService;

@Action
public class UserAction {

    @Inject
    private UserService userService;

    @Request.Get("/user")
    public View index() {
        List<User> userList = userService.getUserList();
        DataContext.Request.put("userList", userList);
        return new View("user.jsp");
    }

    @Request.Post("/user")
    public View save() {
        return new View("user.jsp");
    }

    @Request.Get("/user/{id}")
    public View edit() {
        return new View("user_edit.jsp");
    }

    @Request.Put("/user/{id}")
    public View update() {
        return new View("user.jsp");
    }

    @Request.Delete("/user/{id}")
    public View delete() {
        return new View("user.jsp");
    }
}
