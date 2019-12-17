package com.example.demo.configurer;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class App2ConfigurationAdapter extends WebSecurityConfigurerAdapter {

//    protected void configure(HttpSecurity http) throws Exception {
//        http.antMatcher("/user/**")
//                .authorizeRequests().anyRequest().hasRole("USER")
//                .and()
//                .exceptionHandling()
//                .defaultAuthenticationEntryPointFor(
//                        loginUrlauthenticationEntryPointWithWarning(),
//                        new AntPathRequestMatcher("/user/private/**"))
//                .defaultAuthenticationEntryPointFor(
//                        loginUrlauthenticationEntryPoint(),
//                        new AntPathRequestMatcher("/user/general/**"));
//    }
}