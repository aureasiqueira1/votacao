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
    public Pauta abrirSessao(Long pautaId, Integer minutos) {
        Pauta pauta = pautaRepo.findById(pautaId)
                .orElseThrow(() -> new RuntimeException("Pauta não encontrada"));
        Sessao sessao = new Sessao();
        sessao.setInicio(LocalDateTime.now());
        sessao.setFim(sessao.getInicio().plusMinutes(minutos != null ? minutos : 1));
        pauta.setSessao(sessao);
        return pautaRepo.save(pauta);
    }

    @Override
    public void votar(Long pautaId, Long associadoId, boolean votoSim) {
        Pauta pauta = pautaRepo.findById(pautaId)
                .orElseThrow(() -> new RuntimeException("Pauta não encontrada"));

        if (pauta.getSessao() == null || !pauta.getSessao().isAberta())
            throw new RuntimeException("Sessão encerrada");

        if (votoRepo.existsByAssociadoIdAndPautaId(associadoId, pautaId))
            throw new RuntimeException("Associado já votou");

        Voto voto = new Voto();
        voto.setAssociadoId(associadoId);
        voto.setVoto(votoSim);
        votoRepo.save(voto, pautaId);
    }

    @Override
    public Map<String, Long> resultado(Long pautaId) {
        long sim = votoRepo.countByPautaIdAndVoto(pautaId, true);
        long nao = votoRepo.countByPautaIdAndVoto(pautaId, false);
        return Map.of("Sim", sim, "Não", nao);
    }
}
