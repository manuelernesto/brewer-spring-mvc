package io.github.manuelernesto.service.event.cerveja;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class CervejaListener {

    @EventListener
    public void cervejaSalva(CervejaSalvaEvent event){

    }
}
