package com.example.jobportal.config;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Setter
@Getter
@Configuration
@ConfigurationProperties(prefix = "spring.mail")
@Slf4j
public class MailProperties {
    private String host;
    private Integer port;
    private String username;
    private String password;

}
