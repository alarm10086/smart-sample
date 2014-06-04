package org.smart4j.sample.bean;

import java.util.List;
import org.smart4j.sample.entity.Permission;
import org.smart4j.sample.entity.Role;
import org.smart4j.sample.entity.User;

public class UserBean {

    private User user;
    private List<Role> roleList;
    private List<Permission> permissionList;

    public UserBean(User user, List<Role> roleList, List<Permission> permissionList) {
        this.user = user;
        this.roleList = roleList;
        this.permissionList = permissionList;
    }

    public User getUser() {
        return user;
    }

    public List<Role> getRoleList() {
        return roleList;
    }

    public List<Permission> getPermissionList() {
        return permissionList;
    }
}
