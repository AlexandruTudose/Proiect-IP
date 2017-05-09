package com.fiivirtualcatalog.modules.user.repositories;

import com.fiivirtualcatalog.modules.user.models.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runner.notification.RunListener;
import org.omg.PortableInterceptor.USER_EXCEPTION;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Propagation;
import javax.transaction.Transactional;

import static org.junit.Assert.*;

//Alexandra Folvaiter: fix me!
@RunWith(SpringJUnit4ClassRunner.class)
public class UserRepositoryTest {
    @Autowired
    UserRepository userRepository;

    @Test
    public void test() {
        User user = new User();
        user.setId(1);
        user.setName("maria");
        user.setRole("Student");
        assertEquals(userRepository.save(user), user);
    }

}