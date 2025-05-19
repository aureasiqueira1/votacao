package com.exemplo.projeto.adapter.web.controller;

import com.exemplo.projeto.adapter.persistence.mapper.SessaoMapper;
import com.exemplo.projeto.adapter.web.dto.SessaoRequest;
import com.exemplo.projeto.adapter.web.dto.SessaoResponseDTO;
import com.exemplo.projeto.domain.model.Sessao;
import com.exemplo.projeto.domain.port.input.SessaoUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/sessoes")
@RequiredArgsConstructor
public class SessaoController {

    private final SessaoUseCase sessaoUseCase;
    private final SessaoMapper sessaoMapper;

    @PostMapping
    public ResponseEntity<SessaoResponseDTO> abrirSessao(@RequestBody SessaoRequest request) {
        Sessao sessao = sessaoUseCase.abrirSessao(request.getIdPauta(), request.getMinutos());
        return ResponseEntity.ok(sessaoMapper.toResponse(sessao));
    }
}
