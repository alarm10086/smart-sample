package org.smart4j.sample.service;

import java.util.List;
import org.smart4j.sample.entity.User;

public interface UserService {

    void login(String username, String password);

    List<User> getUserList();
}
