package org.smart4j.sample;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import org.smart4j.framework.dao.DatabaseHelper;
import org.smart4j.plugin.security.SmartSecurity;

public class CustomSmartSecurity implements SmartSecurity {

    @Override
    public String getPassword(String username) {
        String sql = "select password from user where username = ?";
        return DatabaseHelper.queryColumn(sql, username);
    }

    @Override
    public Set<String> getRoleNameSet(String username) {
        String sql = "select distinct r.role_name from user u, user_role ur, role r where u.id = ur.user_id and r.id = ur.role_id and u.username = ?";
        List<String> list = DatabaseHelper.queryColumnList(sql, username);
        return new LinkedHashSet<String>(list);
    }

    @Override
    public Set<String> getPermissionNameSet(String roleName) {
        String sql = "select distinct p.permission_name from role r, role_permission rp, permission p where r.id = rp.role_id and p.id = rp.permission_id and r.role_name = ?";
        List<String> list = DatabaseHelper.queryColumnList(sql, roleName);
        return new LinkedHashSet<String>(list);
    }
}
