package com.eazyschool.webapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

/*
    ⚠️ Important Note:
    You should NOT define multiple `authorizeHttpRequests(...)` chains in the same HttpSecurity configuration.
    For example, using both `permitAll()` and `denyAll()` in the same config block is not valid.
    Only the last one will take effect, which can cause unexpected behavior or errors.

    Always choose a single strategy: either permit all or deny all — not both.
 */


@Configuration
public class ProjectSecurityConfig {
    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {


//        http.authorizeHttpRequests().
//                antMatchers("",""/","/home").permitAll()
//                .antMatchers("/holidays/**").permitAll()
//                .antMatchers("/contact").permitAll()
//                .antMatchers("/saveMsg").permitAll()
//                .antMatchers("/courses").permitAll()
//                .antMatchers("/about").permitAll()
//                .antMatchers("/assets/**").permitAll()
//                .and().formLogin()
//                .and().httpBasic();





        // Disable CSRF protection
        // CSRF stands for Cross-Site Request Forgery.
        // It is a type of attack that tricks the victim into submitting a malicious request.
        // Spring Security enables CSRF protection by default to prevent this.
        // However, in non-browser clients (like REST APIs, Postman, etc.) or during development/testing,
        // it's common to disable CSRF using .csrf().disable().

        http.csrf().disable()
                .authorizeHttpRequests(auth -> auth
                .antMatchers("/","/home", "/holidays/**", "/contact", "/saveMsg", "/courses", "/about","/assets/**").permitAll()
                .anyRequest().authenticated()
        )
                .formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults());




        // Deny All Requests inside the Web Application (Imperative Style)
        /*
        http.authorizeHttpRequests().anyRequest().denyAll().
                and().formLogin().
                and().httpBasic();
         */

        // Deny All Requests inside the Web Application (Lambda DSL)
        /*
            http.authorizeHttpRequests(requests -> requests.anyRequest().denyAll())
                .formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults());
         */

        return http.build();

    }
}
