package com.nnk.springboot.config;

import com.nnk.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import java.util.concurrent.TimeUnit;

@EnableWebSecurity
@Configuration
public class SecurityConfig {
    @Autowired
    private UserService userService;
    @Bean
    BCryptPasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    public AuthenticationProvider daoAuthenticationProvider(){
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(encoder());
        daoAuthenticationProvider.setUserDetailsService(userService);
        return daoAuthenticationProvider;
    }
    @Bean
    public SecurityFilterChain securityFilterChain (HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/user/add", "/user/validate").permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .loginPage("/login").permitAll()
                .usernameParameter("email")
                .passwordParameter("password")
                .defaultSuccessUrl("/home",true)
                .and()
                .rememberMe()
                .rememberMeParameter("remember-Me")
                .key("somethingSecure")
                .tokenValiditySeconds((int) TimeUnit.DAYS.toSeconds(21))
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/login")
                .and()
                .exceptionHandling()
                .accessDeniedPage("/access-denied");
        return http.build();
    }
}
