package io.github.manuelernesto.controller.converter;

import io.github.manuelernesto.Model.Estilo;
import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

public class EstiloConverter implements Converter<String, Estilo> {

    @Override
    public Estilo convert(String codigo) {
        Estilo estilo = new Estilo();
        estilo.setCodigo(Long.valueOf(codigo));
        return estilo;

    }
}
