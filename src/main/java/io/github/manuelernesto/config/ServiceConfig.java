package io.github.manuelernesto.config;

import io.github.manuelernesto.service.CadastroCervejaService;
import io.github.manuelernesto.storage.FotoStorage;
import io.github.manuelernesto.storage.local.FotoStorageLocal;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = CadastroCervejaService.class)
public class ServiceConfig {

    @Bean
    public FotoStorage fotoStorage() {
        return new FotoStorageLocal();
    }
}
