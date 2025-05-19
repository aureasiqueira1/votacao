package com.exemplo.projeto.adapter.persistence.repository;

import com.exemplo.projeto.adapter.persistence.entity.PautaEntity;
import com.exemplo.projeto.adapter.persistence.mapper.PautaMapper;
import com.exemplo.projeto.domain.model.Pauta;
import com.exemplo.projeto.domain.port.output.PautaRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class PautaRepositoryAdapter implements PautaRepositoryPort {

    private final SpringPautaRepository repository;
    private final PautaMapper pautaMapper;

    @Override
    public List<Pauta> findAll() {
        return repository.findAll().stream()
                .map(pautaMapper::toDomain)
                .toList();
    }

    @Override
    public Pauta save(Pauta pauta) {
        PautaEntity entity = pautaMapper.toEntity(pauta);
        PautaEntity saved = repository.save(entity);
        return pautaMapper.toDomain(saved);
    }

    @Override
    public Optional<Pauta> findById(Long id) {
        return repository.findById(id)
                .map(pautaMapper::toDomain);
    }

}
