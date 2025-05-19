package com.exemplo.projeto.domain.port.output;

import com.exemplo.projeto.domain.model.Voto;

public interface VotoRepositoryPort {
    boolean existsByAssociadoIdAndPautaId(Long associadoId, Long pautaId);
    void save(Voto voto, Long pautaId);
    long countByPautaIdAndVoto(Long pautaId, boolean voto);
}
