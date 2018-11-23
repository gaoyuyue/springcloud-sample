package io.github.gaoyuyue.authservice.domain;

import io.github.gaoyuyue.authservice.repoistory.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDomainTest {

    private User user;

//    @Autowired
//    private UserRepository userRepository;

    @Before
    public void before() {
        user = new User();
        user.setUserName("system");
        user.setPassWord("system");
    }

    @Test
    public void create() {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassWord(encoder.encode(user.getPassWord().trim()));
        System.out.println(user.getPassWord());
//        userRepository.save(user);
    }
}
