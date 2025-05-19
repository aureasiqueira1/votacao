package com.exemplo.projeto.domain.port.output;

import com.exemplo.projeto.domain.model.Pauta;

import java.util.List;
import java.util.Optional;

public interface PautaRepositoryPort {
    List<Pauta> findAll();
    Pauta save(Pauta pauta);
    Optional<Pauta> findById(Long id);
}
