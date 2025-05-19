package com.exemplo.projeto.adapter.web.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SessaoResponseDTO {
    private LocalDateTime inicio;
    private LocalDateTime fim;
}
