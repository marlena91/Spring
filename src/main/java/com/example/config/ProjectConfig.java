package com.example.config;

import org.springframework.context.annotation.*;


@Configuration
@ComponentScan(basePackages = {"com.example.implementation", "com.example.services", "com.example.aspects"})
@EnableAspectJAutoProxy
public class ProjectConfig {

}