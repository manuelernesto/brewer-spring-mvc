package io.github.manuelernesto.config;

import io.github.manuelernesto.service.CadastroCervejaService;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = CadastroCervejaService.class)
public class ServiceConfig {
}
