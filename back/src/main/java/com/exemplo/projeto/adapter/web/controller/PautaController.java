package com.exemplo.projeto.adapter.web.controller;

import com.exemplo.projeto.adapter.persistence.entity.PautaEntity;
import com.exemplo.projeto.adapter.persistence.mapper.PautaMapper;
import com.exemplo.projeto.adapter.web.dto.PautaRequest;
import com.exemplo.projeto.adapter.web.dto.PautaResponseDTO;
import com.exemplo.projeto.adapter.web.dto.VotoRequest;
import com.exemplo.projeto.domain.model.Pauta;
import com.exemplo.projeto.domain.port.input.PautaUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/pautas")
@RequiredArgsConstructor
public class PautaController {
    private final PautaUseCase pautaUseCase;
    private  final PautaMapper pautaMapper;

    @GetMapping
    public ResponseEntity<List<PautaResponseDTO>> listarPautas() {
        List<Pauta> pautas = pautaUseCase.buscar();

        if (pautas.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        List<PautaResponseDTO> dtoList = pautas.stream()
                .map(pautaMapper::toDto)
                .toList();

        return ResponseEntity.ok(dtoList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PautaResponseDTO> buscarPorId(@PathVariable Long id) {
        Optional<Pauta> pautaOptional = pautaUseCase.buscarPorId(id);

        if (pautaOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        PautaResponseDTO dto = pautaMapper.toDto(pautaOptional.get());
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<PautaResponseDTO> criar(@RequestBody PautaRequest req) {
        PautaEntity pautaEntity = new PautaEntity();
        pautaEntity.setTitulo(req.getTitulo());
        pautaEntity.setDescricao(req.getDescricao());

        Pauta pauta = pautaMapper.toDomain(pautaEntity);
        Pauta pautaCriada = pautaUseCase.criar(pauta);

        return ResponseEntity.ok(new PautaResponseDTO(
                pautaCriada.getId(),
                pautaCriada.getTitulo(),
                pautaCriada.getDescricao(),
                pautaCriada.getSessao().getInicio(),
                pautaCriada.getSessao().getFim()
        ));
    }

    @PostMapping("/{id}/votar")
    public ResponseEntity<Void> votar(@PathVariable Long id,
                                      @RequestBody VotoRequest req) {
        pautaUseCase.votar(id, req.getAssociadoId(), req.getVoto().equalsIgnoreCase("sim"));
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}/resultado")
    public ResponseEntity<Map<String, Long>> resultado(@PathVariable Long id) {
        return ResponseEntity.ok(pautaUseCase.resultado(id));
    }
}
