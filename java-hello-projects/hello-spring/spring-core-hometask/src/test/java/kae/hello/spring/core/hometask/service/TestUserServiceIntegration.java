package kae.hello.spring.core.hometask.service;

import kae.hello.spring.core.hometask.domain.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/spring.xml"})
public class TestUserServiceIntegration {

    @Autowired
    private UserService userService;

    @Test
    public void testGetUserByEmail() throws Exception {
        User user = userService.getUserByEmail("john.doe@gmail.com");
        Assert.assertNotNull(user);
    }
}
