package com.exemplo.projeto.adapter.persistence.mapper;

import com.exemplo.projeto.adapter.persistence.entity.SessaoEntity;
import com.exemplo.projeto.adapter.web.dto.SessaoResponseDTO;
import com.exemplo.projeto.domain.model.Sessao;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SessaoMapper {
    SessaoResponseDTO toResponse(Sessao sessao);

    SessaoEntity toEntity(Sessao pauta);

    Sessao toDomain(SessaoEntity entity);
}