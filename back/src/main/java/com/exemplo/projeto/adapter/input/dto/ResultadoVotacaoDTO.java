package com.exemplo.projeto.adapter.input.dto;

import lombok.Data;

@Data
public class ResultadoVotacaoDTO {
    private Long idPauta;
    private long totalVotos;
    private long votosSim;
    private long votosNao;
    private String resultado;

    public ResultadoVotacaoDTO(Long idPauta, long totalVotos, long votosSim, long votosNao, String resultado) {
        this.idPauta = idPauta;
        this.totalVotos = totalVotos;
        this.votosSim = votosSim;
        this.votosNao = votosNao;
        this.resultado = resultado;
    }
}
