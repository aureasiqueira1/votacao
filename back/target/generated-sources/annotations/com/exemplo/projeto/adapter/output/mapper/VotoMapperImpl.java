package com.exemplo.projeto.adapter.output.mapper;

import com.exemplo.projeto.adapter.output.entity.VotoEntity;
import com.exemplo.projeto.domain.model.Voto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-20T12:12:42-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.12 (Oracle Corporation)"
)
@Component
public class VotoMapperImpl implements VotoMapper {

    @Override
    public VotoEntity toEntity(Voto voto) {
        if ( voto == null ) {
            return null;
        }

        VotoEntity votoEntity = new VotoEntity();

        votoEntity.setAssociadoId( voto.getAssociadoId() );
        votoEntity.setVoto( voto.isVoto() );

        return votoEntity;
    }

    @Override
    public Voto toDomain(VotoEntity entity) {
        if ( entity == null ) {
            return null;
        }

        Voto voto = new Voto();

        voto.setAssociadoId( entity.getAssociadoId() );
        voto.setVoto( entity.isVoto() );

        return voto;
    }
}
