package com.exemplo.projeto.domain.port.output;

import com.exemplo.projeto.domain.model.Sessao;

import java.util.Optional;

public interface SessaoRepositoryPort {
    Optional<Sessao> buscarPorPauta(Long idPauta);
    Sessao save(Sessao sessao);
}
