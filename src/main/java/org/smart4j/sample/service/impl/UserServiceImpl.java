package org.smart4j.sample.service.impl;

import java.util.List;
import java.util.Map;
import org.smart4j.framework.orm.DataSet;
import org.smart4j.framework.tx.annotation.Service;
import org.smart4j.framework.tx.annotation.Transaction;
import org.smart4j.framework.util.CastUtil;
import org.smart4j.framework.util.StringUtil;
import org.smart4j.plugin.security.SecurityHelper;
import org.smart4j.sample.entity.User;
import org.smart4j.sample.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public void login(String username, String password) {
        SecurityHelper.login(username, password, false);
    }

    @Override
    public List<User> findUserList() {
        return DataSet.selectList(User.class);
    }

    @Override
    public List<User> findUserListByUsername(String username) {
        return DataSet.selectListWithCondition(User.class, "username like ?", "%" + username + "%");
    }

    @Override
    public User findUser(long id) {
        return DataSet.select(User.class, "id = ?", id);
    }

    @Override
    @Transaction
    public boolean saveUser(Map<String, Object> fieldMap) {
        // 加密密码
        String password = CastUtil.castString(fieldMap.get("password"));
        password = SecurityHelper.encrypt(password);
        fieldMap.put("password", password);
        // 插入用户
        return DataSet.insert(User.class, fieldMap);
    }

    @Override
    @Transaction
    public boolean updateUser(long id, Map<String, Object> fieldMap) {
        // 若密码不为空，则加密密码，否则不更新密码
        String password = CastUtil.castString(fieldMap.get("password"));
        if (StringUtil.isNotEmpty(password)) {
            password = SecurityHelper.encrypt(password);
            fieldMap.put("password", password);
        } else {
            fieldMap.remove("password");
        }
        // 更新用户
        return DataSet.update(User.class, fieldMap, "id = ?", id);
    }

    @Override
    @Transaction
    public boolean deleteUser(long id) {
        return DataSet.delete(User.class, "id = ?", id);
    }
}
