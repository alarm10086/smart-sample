package org.smart4j.sample.service.impl;

import java.util.List;
import org.smart4j.framework.orm.DataSet;
import org.smart4j.framework.tx.annotation.Service;
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
    public List<User> getUserList() {
        return DataSet.selectList(User.class);
    }
}
