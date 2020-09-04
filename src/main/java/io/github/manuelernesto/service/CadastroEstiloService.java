package io.github.manuelernesto.service;

import io.github.manuelernesto.Model.Cerveja;
import io.github.manuelernesto.Model.Estilo;
import io.github.manuelernesto.repository.Cervejas;
import io.github.manuelernesto.repository.Estilos;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CadastroEstiloService {

    private final Estilos estilos;

    public CadastroEstiloService(Estilos estilos) {
        this.estilos = estilos;
    }

    @Transactional
    public void salvar(Estilo estilo) {
        estilos.save(estilo);
    }
}

