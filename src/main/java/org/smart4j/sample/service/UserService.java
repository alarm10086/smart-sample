package org.smart4j.sample.service;

import java.util.List;
import java.util.Map;
import org.smart4j.sample.entity.User;

public interface UserService {

    void login(String username, String password);

    List<User> findUserList();

    List<User> findUserListByUsername(String username);

    User findUser(long id);

    boolean saveUser(Map<String, Object> fieldMap);

    boolean updateUser(long id, Map<String, Object> fieldMap);

    boolean deleteUser(long id);
}
