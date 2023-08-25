package com.example.jobportal.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
public enum Role {

    USER(Collections.emptySet()),
    ROLE_ADMIN(Collections.emptySet()),
    ADMIN(
            Set.of(
                    Permission.ADMIN_READ,
                    Permission.ADMIN_UPDATE,
                    Permission.ADMIN_DELETE,
                    Permission.ADMIN_CREATE,
                    Permission.RECRUITER_READ,
                    Permission.RECRUITER_UPDATE,
                    Permission.RECRUITER_DELETE,
                    Permission.RECRUITER_CREATE,
                    Permission.APPLICANT_READ,
                    Permission.APPLICANT_UPDATE,
                    Permission.APPLICANT_DELETE,
                    Permission.APPLICANT_CREATE
            )
    ),
    RECRUITER(
            Set.of(
                    Permission.RECRUITER_READ,
                    Permission.RECRUITER_UPDATE,
                    Permission.RECRUITER_DELETE,
                    Permission.RECRUITER_CREATE
            )
    ),
    APPLICANT(
            Set.of(
                    Permission.APPLICANT_READ,
                    Permission.APPLICANT_UPDATE,
                    Permission.APPLICANT_DELETE,
                    Permission.APPLICANT_CREATE
            )
    );


    @Getter
    private final Set<Permission> permissions;

    public List<SimpleGrantedAuthority> getAuthorities() {
        var authorities = getPermissions()
                .stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toList());
        authorities.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return authorities;
    }
}