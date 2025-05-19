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
    public boolean existsByAssociadoIdAndPautaId(Long associadoId, Long pautaId) {
        return repository.existsByAssociadoIdAndPautaId(associadoId, pautaId);
    }

    @Override
    public void save(Voto voto, Long pautaId) {
        VotoEntity entity = votoMapper.toEntity(voto);
        entity.setPautaId(pautaId); // garante que o pautaId seja vinculado corretamente
        repository.save(entity);
    }

    @Override
    public long countByPautaIdAndVoto(Long pautaId, boolean voto) {
        return repository.countByPautaIdAndVoto(pautaId, voto);
    }
}
