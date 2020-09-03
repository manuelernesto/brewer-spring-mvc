package io.github.manuelernesto.repository;

import io.github.manuelernesto.Model.Estilo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Estilos extends JpaRepository<Estilo, Long> {

}
