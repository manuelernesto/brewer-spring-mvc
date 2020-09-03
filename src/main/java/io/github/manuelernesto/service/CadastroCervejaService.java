package io.github.manuelernesto.service;

import io.github.manuelernesto.Model.Cerveja;
import io.github.manuelernesto.repository.Cervejas;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CadastroCervejaService {

    private final Cervejas cervejas;

    public CadastroCervejaService(Cervejas cervejas) {
        this.cervejas = cervejas;
    }

    @Transactional
    public void salvar(Cerveja cerveja) {
        cervejas.save(cerveja);
    }
}

