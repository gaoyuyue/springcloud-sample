package io.github.gaoyuyue.authservice.security;

import io.github.gaoyuyue.authservice.domain.User;
import io.github.gaoyuyue.authservice.repoistory.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String userName = username.toLowerCase();
        Optional<User> optionalUser = userRepository.findOneWithRolesByUserName(userName);
        return optionalUser.map(user ->
                new org.springframework.security.core.userdetails.User(user.getUserName(),
                        user.getPassWord(), user.getAuthorities())).orElseThrow(() ->
                new UsernameNotFoundException("用户" + userName + "不存在！"));
    }
}
