package io.github.manuelernesto.repository.helper.estilo;

import io.github.manuelernesto.Model.Estilo;
import io.github.manuelernesto.repository.filter.EstiloFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EstilosQueries {
    Page<Estilo> filtrar(EstiloFilter filter, Pageable pageable);
}
