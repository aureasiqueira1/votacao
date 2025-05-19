package com.exemplo.projeto.adapter.web.dto;

import lombok.Data;

@Data
public class VotoRequest {
    private Long idPauta;
    private Long associadoId;
    private boolean voto;
}
