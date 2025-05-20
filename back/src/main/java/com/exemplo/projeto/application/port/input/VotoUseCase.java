package com.exemplo.projeto.application.port.input;

import com.exemplo.projeto.adapter.input.dto.ResultadoVotacaoDTO;

public interface VotoUseCase {
    void votar(Long idPauta, Long associadoId, boolean voto);
    ResultadoVotacaoDTO consultarResultado(Long idPauta);
}
