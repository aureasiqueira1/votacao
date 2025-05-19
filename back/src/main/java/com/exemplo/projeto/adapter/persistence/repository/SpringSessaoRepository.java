package com.exemplo.projeto.adapter.persistence.repository;

import com.exemplo.projeto.adapter.persistence.entity.SessaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringSessaoRepository extends JpaRepository<SessaoEntity, Long> {
}
