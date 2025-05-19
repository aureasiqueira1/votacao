package com.exemplo.projeto.domain.port.output;

import com.exemplo.projeto.domain.model.Voto;

public interface VotoRepositoryPort {
    boolean existsByAssociadoIdAndIdPauta(Long associadoId, Long idPauta);
    void save(Voto voto, Long idPauta);
    long countByIdPautaAndVoto(Long idPauta, boolean voto);
}
