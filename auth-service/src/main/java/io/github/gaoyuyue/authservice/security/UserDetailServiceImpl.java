package io.github.gaoyuyue.authservice.security;

import io.github.gaoyuyue.authservice.client.UserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

//import io.github.gaoyuyue.authservice.repoistory.UserRepository;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
//    @Autowired
//    private UserRepository userRepository;

    @Autowired
    private UserClient userClient;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //        Optional<User> optionalUser = userRepository.findOneWithRolesByUserName(userName);
        Map<String, Object> map = userClient.getUserByUserName(username.toLowerCase());
        return new User((String) map.get("userName"), (String) map.get("passWord"), generateGrantedAuthorities((List<String>) map.get("authorities")));

//        return optionalUser.map(user ->
//                new org.springframework.security.core.userdetails.User(user.getUserName(),
//                        user.getPassWord(), user.getAuthorities())).orElseThrow(() ->
//                new UsernameNotFoundException("用户" + userName + "不存在！"));
    }

    private List<GrantedAuthority> generateGrantedAuthorities(List<String> authorities) {
        return authorities.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());
    }
}
