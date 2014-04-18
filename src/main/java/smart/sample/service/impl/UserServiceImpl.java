package smart.sample.service.impl;

import smart.framework.annotation.Service;
import smart.sample.service.UserService;
import smart.security.SmartSecurityHelper;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public void login(String username, String password) {
        SmartSecurityHelper.login(username, password, false);
    }
}
