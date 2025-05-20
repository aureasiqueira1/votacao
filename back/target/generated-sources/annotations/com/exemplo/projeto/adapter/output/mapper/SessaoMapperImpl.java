package com.exemplo.projeto.adapter.output.mapper;

import com.exemplo.projeto.adapter.input.dto.SessaoResponseDTO;
import com.exemplo.projeto.adapter.output.entity.SessaoEntity;
import com.exemplo.projeto.domain.model.Sessao;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-20T12:12:42-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.12 (Oracle Corporation)"
)
@Component
public class SessaoMapperImpl implements SessaoMapper {

    @Override
    public SessaoResponseDTO toResponse(Sessao sessao) {
        if ( sessao == null ) {
            return null;
        }

        SessaoResponseDTO sessaoResponseDTO = new SessaoResponseDTO();

        sessaoResponseDTO.setInicio( sessao.getInicio() );
        sessaoResponseDTO.setFim( sessao.getFim() );

        return sessaoResponseDTO;
    }

    @Override
    public SessaoEntity toEntity(Sessao pauta) {
        if ( pauta == null ) {
            return null;
        }

        SessaoEntity sessaoEntity = new SessaoEntity();

        sessaoEntity.setIdPauta( pauta.getIdPauta() );
        sessaoEntity.setInicio( pauta.getInicio() );
        sessaoEntity.setFim( pauta.getFim() );

        return sessaoEntity;
    }

    @Override
    public Sessao toDomain(SessaoEntity entity) {
        if ( entity == null ) {
            return null;
        }

        Sessao sessao = new Sessao();

        sessao.setInicio( entity.getInicio() );
        sessao.setFim( entity.getFim() );
        sessao.setIdPauta( entity.getIdPauta() );

        return sessao;
    }
}
