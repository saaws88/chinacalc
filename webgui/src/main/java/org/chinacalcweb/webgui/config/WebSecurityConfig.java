package org.chinacalcweb.webgui.config;

import org.chinacalcweb.webgui.service.ChinacalcUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

  @Bean
  public BCryptPasswordEncoder encoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  public UserDetailsService userDetailsService() {
    return new ChinacalcUserDetailsService();
  }

  @Bean
  public AuthenticationManager authenticationManager() {
    var authProvider = new DaoAuthenticationProvider();
    authProvider.setUserDetailsService(userDetailsService());
    authProvider.setPasswordEncoder(encoder());
    return new ProviderManager(authProvider);
  }

  //TODO set permits
  @Bean
  protected SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http
          .csrf(csrf->csrf.disable())
          .authorizeHttpRequests((requests) -> requests            
            .requestMatchers("/", "/main", "api/v1/**", "/signup").permitAll()
            .anyRequest().authenticated()
          )
          .formLogin(login->login
            .loginPage("/login")
            .defaultSuccessUrl("/home")
            .permitAll())
          .logout(logout -> logout
              .permitAll());
          
    return http.build();
  }

    
}
