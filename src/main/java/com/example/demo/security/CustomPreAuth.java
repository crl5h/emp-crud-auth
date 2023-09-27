package com.example.demo.security;

import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.io.Serializable;

public class CustomPreAuth implements PermissionEvaluator {
    @Override
    public boolean hasPermission(Authentication auth, Object targetDomainObject, Object permission) {
//        if ((auth == null) || (targetDomainObject == null) || !(permission instanceof String)) {
//            return false;
//        }
//        String targetType = targetDomainObject.getClass().getSimpleName().toUpperCase();
//        System.out.println(targetType);
        System.out.println("Works1");
        return false;
    }

    @Override
    public boolean hasPermission(Authentication auth, Serializable targetId, String targetType, Object permission) {
        if ((auth == null) || (targetType == null) || !(permission instanceof String)) {
            return false;
        }

        System.out.println(auth.getAuthorities());
        System.out.println(targetType + " " + permission);

        for (GrantedAuthority u_auth : auth.getAuthorities()) {
            if (u_auth.getAuthority().equals(permission)) {
                return true;
            }
        }
        return false;
    }
}
