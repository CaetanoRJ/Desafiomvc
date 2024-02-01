package com.pedro.desafio.repositories;

import com.pedro.desafio.entities.ProjetoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjetoRepository extends JpaRepository<ProjetoEntity, Long> {
}
