package com.lesniewski.aop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Created by adrian on 25.03.17.
 */
@Configuration
@ComponentScan("com.lesniewski.aop")
@EnableAspectJAutoProxy
public class AppConfiguration {
}
