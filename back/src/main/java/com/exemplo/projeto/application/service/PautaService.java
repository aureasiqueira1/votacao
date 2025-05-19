package com.exemplo.projeto.application.service;

import com.exemplo.projeto.domain.model.Pauta;
import com.exemplo.projeto.domain.model.Sessao;
import com.exemplo.projeto.domain.model.Voto;
import com.exemplo.projeto.domain.port.input.PautaUseCase;
import com.exemplo.projeto.domain.port.output.PautaRepositoryPort;
import com.exemplo.projeto.domain.port.output.VotoRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PautaService implements PautaUseCase {
    private final PautaRepositoryPort pautaRepo;
    private final VotoRepositoryPort votoRepo;

    @Override
    public List<Pauta> buscar() {
        return pautaRepo.findAll();
    }

    @Override
    public Optional<Pauta> buscarPorId(Long id) {
        return pautaRepo.findById(id);
    }

    @Override
    public Pauta criar(Pauta pauta) {
        return pautaRepo.save(pauta);
    }

    @Override
    public void votar(Long idPauta, Long associadoId, boolean votoSim) {
        Pauta pauta = pautaRepo.findById(idPauta)
                .orElseThrow(() -> new RuntimeException("Pauta não encontrada"));

        if (pauta.getSessao() == null || !pauta.getSessao().isAberta())
            throw new RuntimeException("Sessão encerrada");

        if (votoRepo.existsByAssociadoIdAndIdPauta(associadoId, idPauta))
            throw new RuntimeException("Associado já votou");

        Voto voto = new Voto();
        voto.setAssociadoId(associadoId);
        voto.setVoto(votoSim);
        votoRepo.save(voto, idPauta);
    }

    @Override
    public Map<String, Long> resultado(Long idPauta) {
        long sim = votoRepo.countByIdPautaAndVoto(idPauta, true);
        long nao = votoRepo.countByIdPautaAndVoto(idPauta, false);
        return Map.of("Sim", sim, "Não", nao);
    }
}
