package smart.sample.test;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import smart.framework.annotation.Order;
import smart.framework.base.BaseTest;
import smart.framework.helper.BeanHelper;
import smart.sample.service.UserService;
import smart.sample.service.impl.UserServiceImpl;

public class UserServiceTest extends BaseTest {

    private UserService userService = BeanHelper.getBean(UserServiceImpl.class);

    @BeforeClass
    @AfterClass
    public static void init() {
        initSQL("sql/user.sql");
    }

    @Test
    @Order(1)
    public void loginTest() {
        String username = "admin";
        String password = "admin";

        userService.login(username, password);
    }
}
