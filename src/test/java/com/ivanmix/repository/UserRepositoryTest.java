package com.ivanmix.repository;



import com.ivanmix.config.SpringConfig;
import org.junit.Ignore;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.ivanmix.entity.User;
import org.springframework.test.context.web.WebAppConfiguration;


import static org.junit.Assert.assertNotNull;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class UserRepositoryTest {

    @Autowired
    private UserRepository repository;

    @Test
    public void testFindAll() {
        System.out.println(repository.findAll());
        Iterable<User> users = repository.findAll();

        assertNotNull(users);
    }

}
