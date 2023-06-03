package org.chinacalcweb.webgui.Configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/home").setViewName("home");
        registry.addViewController("/").setViewName("home"); //greetings & log in
        registry.addViewController("/login").setViewName("login"); //log in page
        registry.addViewController("/error").setViewName("error"); //error

        registry.addViewController("/admin").setViewName("admin"); //users database display

        registry.addViewController("/main").setViewName("main"); //calculator

        registry.addViewController("/orders").setViewName("orders"); //orders db display
        registry.addViewController("/customers").setViewName("customers"); //customers db display
    }
}
