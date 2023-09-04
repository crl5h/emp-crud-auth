package com.example.demo.security;

import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.var;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserService userService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        var userFromDb = userService.findUserFromDb(email);
        return UserPrincipal.builder()
                .userId(userFromDb.getId())
                .email(userFromDb.getEmail())
                .authorities(List.of(new SimpleGrantedAuthority(userFromDb.getRole())))
                .build();
    }
}