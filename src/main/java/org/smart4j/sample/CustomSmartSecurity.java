package org.smart4j.sample;

import java.util.Set;
import org.smart4j.framework.dao.DatabaseHelper;
import org.smart4j.security.SmartSecurity;

public class CustomSmartSecurity implements SmartSecurity {

    @Override
    public String getPassword(String username) {
        String sql = "select password from user where username = ?";
        return DatabaseHelper.queryField(sql, username);
    }

    @Override
    public Set<String> getRoleNameSet(String username) {
        String sql = "select r.role_name from user u, user_role ur, role r where u.id = ur.user_id and r.id = ur.role_id and u.username = ?";
        return DatabaseHelper.queryFieldSet(sql, username);
    }

    @Override
    public Set<String> getPermNameSet(String roleName) {
        String sql = "select p.permission_name from role r, role_permission rp, permission p where r.id = rp.role_id and p.id = rp.permission_id and r.role_name = ?";
        return DatabaseHelper.queryFieldSet(sql, roleName);
    }
}
