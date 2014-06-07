package org.smart4j.sample.action;

import java.util.List;
import java.util.Map;
import org.smart4j.framework.ioc.annotation.Inject;
import org.smart4j.framework.mvc.annotation.Action;
import org.smart4j.framework.mvc.annotation.DELETE;
import org.smart4j.framework.mvc.annotation.GET;
import org.smart4j.framework.mvc.annotation.POST;
import org.smart4j.framework.mvc.annotation.PUT;
import org.smart4j.framework.mvc.bean.Params;
import org.smart4j.framework.mvc.bean.Result;
import org.smart4j.framework.mvc.bean.View;
import org.smart4j.plugin.security.annotation.HasRoles;
import org.smart4j.sample.bean.UserBean;
import org.smart4j.sample.entity.Role;
import org.smart4j.sample.service.PermissionService;
import org.smart4j.sample.service.RoleService;
import org.smart4j.sample.service.UserService;

@Action
@HasRoles("admin")
public class UserAction {

    @Inject
    private UserService userService;

    @Inject
    private RoleService roleService;

    @Inject
    private PermissionService permissionService;

    @GET("/users")
    public View index() {
        List<UserBean> userBeanList = userService.findUserBeanList();
        return new View("user.jsp")
            .data("userBeanList", userBeanList);
    }

    @POST("/users")
    public View search(Params params) {
        String username = params.getString("username");
        List<UserBean> userBeanList = userService.findUserBeanListByUsername(username);
        return new View("user_list.jsp")
            .data("userBeanList", userBeanList);
    }

    @GET("/user")
    public View create() {
        List<Role> roleList = roleService.getRoleList();
        return new View("user_create.jsp")
            .data("roleList", roleList);
    }

    @POST("/user")
    public Result save(Params params) {
        Map<String, Object> fieldMap = params.getFieldMap();
        boolean result = userService.saveUser(fieldMap);
        return new Result(result);
    }

    @GET("/user/{id}")
    public View edit(long id) {
        UserBean userBean = userService.findUserBean(id);
        List<Role> roleList = roleService.getRoleList();
        return new View("user_edit.jsp")
            .data("userBean", userBean)
            .data("roleList", roleList);
    }

    @PUT("/user/{id}")
    public Result update(long id, Params params) {
        Map<String, Object> fieldMap = params.getFieldMap();
        boolean result = userService.updateUser(id, fieldMap);
        return new Result(result);
    }

    @DELETE("/user/{id}")
    public Result delete(long id) {
        boolean result = userService.deleteUser(id);
        return new Result(result);
    }
}
