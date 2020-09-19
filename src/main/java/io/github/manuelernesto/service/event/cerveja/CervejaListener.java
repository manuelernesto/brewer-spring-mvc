package io.github.manuelernesto.service.event.cerveja;

import io.github.manuelernesto.storage.FotoStorage;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class CervejaListener {

    private final FotoStorage fotoStorage;

    public CervejaListener(FotoStorage fotoStorage) {
        this.fotoStorage = fotoStorage;
    }

    @EventListener(condition = "#event.isFoto()")
    public void cervejaSalva(CervejaSalvaEvent event) {
        fotoStorage.salvar(event.getCerveja().getFoto());
    }
}
