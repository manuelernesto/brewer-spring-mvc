package io.github.manuelernesto.service;

import io.github.manuelernesto.Model.Cerveja;
import io.github.manuelernesto.repository.Cervejas;
import io.github.manuelernesto.service.event.cerveja.CervejaSalvaEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CadastroCervejaService {

    private final Cervejas cervejas;
    private final ApplicationEventPublisher publisher;

    public CadastroCervejaService(Cervejas cervejas, ApplicationEventPublisher publisher) {
        this.cervejas = cervejas;
        this.publisher = publisher;
    }

    @Transactional
    public void salvar(Cerveja cerveja) {
        cervejas.save(cerveja);
        publisher.publishEvent(new CervejaSalvaEvent(cerveja));
    }
}

