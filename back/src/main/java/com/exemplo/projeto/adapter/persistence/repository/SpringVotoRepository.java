package com.exemplo.projeto.adapter.persistence.repository;

import com.exemplo.projeto.adapter.persistence.entity.VotoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringVotoRepository extends JpaRepository<VotoEntity, Long> {

    boolean existsByAssociadoIdAndPautaId(Long associadoId, Long pautaId);

    long countByPautaIdAndVoto(Long pautaId, boolean voto);
}
