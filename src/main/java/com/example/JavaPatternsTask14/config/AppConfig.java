package com.example.JavaPatternsTask14.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableJpaRepositories(basePackages = "com.example.JavaPatternsTask14.repositories")
@EntityScan(basePackages = "com.example.JavaPatternsTask14.models")
@ComponentScan(basePackages = "com.example.JavaPatternsTask14")
@EnableAsync
@EnableScheduling
@EnableAspectJAutoProxy
@EnableWebSecurity
public class AppConfig {
}
