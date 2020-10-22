package io.github.manuelernesto.repository;

import io.github.manuelernesto.Model.Estilo;
import io.github.manuelernesto.repository.filter.EstiloFilter;
import io.github.manuelernesto.repository.helper.estilo.EstilosQueries;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Estilos extends JpaRepository<Estilo, Long>, EstilosQueries {

    Optional<Estilo> findByNomeIgnoreCase(String nome);
}
