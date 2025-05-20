package com.exemplo.projeto.adapter.output.mapper;

import com.exemplo.projeto.adapter.input.dto.PautaResponseDTO;
import com.exemplo.projeto.adapter.output.entity.PautaEntity;
import com.exemplo.projeto.domain.model.Pauta;
import com.exemplo.projeto.domain.model.Sessao;
import java.time.LocalDateTime;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-20T12:12:42-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.12 (Oracle Corporation)"
)
@Component
public class PautaMapperImpl implements PautaMapper {

    @Override
    public PautaResponseDTO toDto(Pauta pauta) {
        if ( pauta == null ) {
            return null;
        }

        LocalDateTime inicioSessao = null;
        LocalDateTime fimSessao = null;
        Long id = null;
        String titulo = null;
        String descricao = null;

        inicioSessao = pautaSessaoInicio( pauta );
        fimSessao = pautaSessaoFim( pauta );
        id = pauta.getId();
        titulo = pauta.getTitulo();
        descricao = pauta.getDescricao();

        PautaResponseDTO pautaResponseDTO = new PautaResponseDTO( id, titulo, descricao, inicioSessao, fimSessao );

        return pautaResponseDTO;
    }

    @Override
    public PautaEntity toEntity(Pauta pauta) {
        if ( pauta == null ) {
            return null;
        }

        PautaEntity pautaEntity = new PautaEntity();

        pautaEntity.setInicioSessao( pautaSessaoInicio( pauta ) );
        pautaEntity.setFimSessao( pautaSessaoFim( pauta ) );
        pautaEntity.setId( pauta.getId() );
        pautaEntity.setTitulo( pauta.getTitulo() );
        pautaEntity.setDescricao( pauta.getDescricao() );

        return pautaEntity;
    }

    @Override
    public Pauta toDomain(PautaEntity entity) {
        if ( entity == null ) {
            return null;
        }

        Pauta pauta = new Pauta();

        pauta.setDescricao( entity.getDescricao() );
        pauta.setId( entity.getId() );
        pauta.setTitulo( entity.getTitulo() );

        pauta.setSessao( toSessao(entity.getInicioSessao(), entity.getFimSessao()) );

        return pauta;
    }

    private LocalDateTime pautaSessaoInicio(Pauta pauta) {
        if ( pauta == null ) {
            return null;
        }
        Sessao sessao = pauta.getSessao();
        if ( sessao == null ) {
            return null;
        }
        LocalDateTime inicio = sessao.getInicio();
        if ( inicio == null ) {
            return null;
        }
        return inicio;
    }

    private LocalDateTime pautaSessaoFim(Pauta pauta) {
        if ( pauta == null ) {
            return null;
        }
        Sessao sessao = pauta.getSessao();
        if ( sessao == null ) {
            return null;
        }
        LocalDateTime fim = sessao.getFim();
        if ( fim == null ) {
            return null;
        }
        return fim;
    }
}
