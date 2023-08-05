package org.chinacalcweb.webgui.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    private UserDetailsService userDetailsService;

    @Autowired
    public WebSecurityConfig(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> {
                    try {
                        csrf
                                .disable()
                                .authorizeHttpRequests()
                                .requestMatchers("/admin/**").hasRole("ADMIN")
                                .requestMatchers("/").permitAll()
                                .anyRequest().authenticated();
                    } catch (Exception e) {
                        e = new Exception ("Авторизуйтесь для просмотра страницы");
                    }
                })
                .formLogin(login -> login
                        .loginPage("/login")
                        .defaultSuccessUrl("/home")
                        .permitAll())
                .logout(logout -> logout
                        .permitAll()
                        .logoutSuccessUrl("/"));
            return http.build();
    }
    
}
