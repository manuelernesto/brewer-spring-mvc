package io.github.manuelernesto.repository.helper.cerveja;

import io.github.manuelernesto.Model.Cerveja;
import io.github.manuelernesto.repository.filter.CervejaFilter;

import java.util.List;

public interface CervejasQueries {
    public List<Cerveja> filtrar(CervejaFilter filter);
}
