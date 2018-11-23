package io.github.gaoyuyue.userservice.service;

import io.github.gaoyuyue.userservice.domain.Authority;
import io.github.gaoyuyue.userservice.domain.User;
import io.github.gaoyuyue.userservice.repoistory.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public Map<String, Object> getSecurityUserByUserName(@NotNull String userName) {
        User user = userRepository.findOneWithRolesByUserName(userName);
        Map<String, Object> map = new HashMap<>();
        map.put("userName", user.getUserName());
        map.put("passWord", user.getPassWord());
        map.put("authorities", getAuthorities(user));
        return map;
    }

    private Set<String> getAuthorities(User user) {
        Set<String> authorities = new HashSet<>();
        user.getRoles().forEach(role ->
                authorities.addAll(role.getAuthorities()
                        .stream().map(Authority::getValue)
                        .collect(Collectors.toSet())));
        return authorities;
    }
}
