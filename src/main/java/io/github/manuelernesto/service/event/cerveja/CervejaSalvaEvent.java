package io.github.manuelernesto.service.event.cerveja;

import io.github.manuelernesto.Model.Cerveja;

public class CervejaSalvaEvent {

    private Cerveja cerveja;

    public CervejaSalvaEvent(Cerveja cerveja) {
        this.cerveja = cerveja;
    }

    public Cerveja getCerveja() {
        return cerveja;
    }
}
