package io.github.manuelernesto.repository;

import io.github.manuelernesto.Model.Cerveja;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Cervejas extends JpaRepository<Cerveja, Long> {

}
