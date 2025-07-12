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

        // Permit All Requests inside the Web Application (Imperative Style)
        /*
        http.authorizeHttpRequests().anyRequest().permitAll().
                and().formLogin().
                and().httpBasic();
         */

        // Permit All Requests inside the Web Application (Lambda DSL)
        http.authorizeHttpRequests(requests -> requests.anyRequest().permitAll())
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
