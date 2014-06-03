package org.smart4j.sample.test;

import org.apache.shiro.authc.credential.DefaultPasswordService;
import org.apache.shiro.authc.credential.PasswordService;
import org.junit.Assert;
import org.junit.Test;

public class ShiroTest {

    @Test
    public void passwordTest() {
        String plaintextPassword = "admin";
        PasswordService passwordService = new DefaultPasswordService();
        String encryptPassword = passwordService.encryptPassword(plaintextPassword);
        System.out.println("encryptPassword: " + encryptPassword);
        Assert.assertTrue(passwordService.passwordsMatch(plaintextPassword, encryptPassword));
    }
}
