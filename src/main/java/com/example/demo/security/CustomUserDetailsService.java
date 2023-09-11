package com.example.demo.security;

import com.example.demo.entity.UserEntity;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
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
        UserEntity userFromDb = userService.findUserFromDb(email).get();
        // building the userPrincipal from db
        return UserPrincipal.builder()
                .userId(userFromDb.getId())
                .email(userFromDb.getEmail())
                .username(userFromDb.getUsername())
                .password(userFromDb.getPassword())
                .authorities(List.of(new SimpleGrantedAuthority(userFromDb.getRole())))
                .build();
    }
}
