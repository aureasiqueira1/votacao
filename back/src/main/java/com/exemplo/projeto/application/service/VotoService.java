package com.exemplo.projeto.application.service;

import com.exemplo.projeto.adapter.input.dto.ResultadoVotacaoDTO;
import com.exemplo.projeto.domain.model.Sessao;
import com.exemplo.projeto.domain.model.Voto;
import com.exemplo.projeto.application.port.input.VotoUseCase;
import com.exemplo.projeto.application.port.output.SessaoRepositoryPort;
import com.exemplo.projeto.application.port.output.VotoRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class VotoService implements VotoUseCase {
    private final VotoRepositoryPort votoRepository;
    private final SessaoRepositoryPort sessaoRepository;

    @Override
    public void votar(Long idPauta, Long associadoId, boolean voto) {
        Sessao sessao = sessaoRepository.buscarPorPauta(idPauta)
                .orElseThrow(() -> new IllegalStateException("Sessão não encontrada"));

        if (sessao.getFim().isBefore(LocalDateTime.now())) {
            throw new IllegalStateException("Sessão encerrada");
        }

        if (votoRepository.existsByAssociadoIdAndIdPauta(associadoId, idPauta)) {
            throw new IllegalStateException("Associado já votou nesta pauta");
        }

        Voto novoVoto = new Voto();
        novoVoto.setAssociadoId(associadoId);
        novoVoto.setVoto(voto);

        votoRepository.save(novoVoto, idPauta);
    }

    @Override
    public ResultadoVotacaoDTO consultarResultado(Long idPauta) {
        long votosSim = votoRepository.countByIdPautaAndVoto(idPauta, true);
        long votosNao = votoRepository.countByIdPautaAndVoto(idPauta, false);
        long total = votosSim + votosNao;

        String resultado;
        if (votosSim > votosNao) {
            resultado = "APROVADA";
        } else if (votosSim < votosNao) {
            resultado = "REJEITADA";
        } else {
            resultado = "EMPATE";
        }

        return new ResultadoVotacaoDTO(idPauta, total, votosSim, votosNao, resultado);
    }

}
