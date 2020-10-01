package io.github.manuelernesto.repository.helper.cerveja;

import io.github.manuelernesto.Model.Cerveja;
import io.github.manuelernesto.repository.filter.CervejaFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CervejasQueries {
    Page<Cerveja> filtrar(CervejaFilter filter, Pageable pageable);
}
