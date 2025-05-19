package com.exemplo.projeto.domain.port.input;

import com.exemplo.projeto.adapter.web.dto.ResultadoVotacaoDTO;

public interface VotoUseCase {
    void votar(Long idPauta, Long associadoId, boolean voto);
    ResultadoVotacaoDTO consultarResultado(Long idPauta);
}
