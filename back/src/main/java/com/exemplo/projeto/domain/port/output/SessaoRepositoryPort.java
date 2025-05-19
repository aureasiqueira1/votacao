package com.exemplo.projeto.domain.port.output;

import com.exemplo.projeto.domain.model.Sessao;

public interface SessaoRepositoryPort {
    Sessao save(Sessao sessao);
}
