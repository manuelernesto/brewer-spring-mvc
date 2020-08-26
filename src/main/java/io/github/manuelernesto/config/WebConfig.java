package io.github.manuelernesto.config;

import io.github.manuelernesto.controller.CervejaController;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@ComponentScan(basePackageClasses = CervejaController.class)
@EnableWebMvc
public class WebConfig extends WebMvcConfigurerAdapter {

}
