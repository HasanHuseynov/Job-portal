package com.example.jobportal.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public enum Permission {

    ADMIN_READ("admin:read"),
    ADMIN_UPDATE("admin:update"),
    ADMIN_CREATE("admin:create"),
    ADMIN_DELETE("admin:delete"),
    RECRUITER_READ("recruiter:read"),
    RECRUITER_UPDATE("recruiter:update"),
    RECRUITER_CREATE("recruiter:create"),
    RECRUITER_DELETE("recruiter:delete"),
    APPLICANT_READ("applicant:read"),
    APPLICANT_UPDATE("applicant:update"),
    APPLICANT_CREATE("applicant:create"),
    APPLICANT_DELETE("applicant:delete");

    @Getter
    private final String permission;
}