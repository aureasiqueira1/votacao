package com.exemplo.projeto.domain.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Sessao {
    private LocalDateTime inicio;
    private LocalDateTime fim;

    public boolean isAberta() {
        return LocalDateTime.now().isBefore(fim);
    }
}
