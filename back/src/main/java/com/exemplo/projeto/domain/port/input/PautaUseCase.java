package com.exemplo.projeto.domain.port.input;

import com.exemplo.projeto.domain.model.Pauta;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface PautaUseCase {
    List<Pauta> buscar();
    Optional<Pauta> buscarPorId(Long id);
    Pauta criar(Pauta pauta);
    void votar(Long idPauta, Long associadoId, boolean voto);
    Map<String, Long> resultado(Long idPauta);
}
