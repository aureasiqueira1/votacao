package com.exemplo.projeto.adapter.persistence.repository;

import com.exemplo.projeto.adapter.persistence.entity.VotoEntity;
import com.exemplo.projeto.adapter.persistence.mapper.PautaMapper;
import com.exemplo.projeto.adapter.persistence.mapper.VotoMapper;
import com.exemplo.projeto.domain.model.Voto;
import com.exemplo.projeto.domain.port.output.VotoRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class VotoRepositoryAdapter implements VotoRepositoryPort {

    private final SpringVotoRepository repository;
    private final VotoMapper votoMapper;

    @Override
    public boolean existsByAssociadoIdAndIdPauta(Long associadoId, Long idPauta) {
        return repository.existsByAssociadoIdAndIdPauta(associadoId, idPauta);
    }

    @Override
    public void save(Voto voto, Long idPauta) {
        VotoEntity entity = votoMapper.toEntity(voto);
        entity.setIdPauta(idPauta);
        repository.save(entity);
    }

    @Override
    public long countByIdPautaAndVoto(Long idPauta, boolean voto) {
        return repository.countByIdPautaAndVoto(idPauta, voto);
    }
}
