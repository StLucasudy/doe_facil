package br.com.doefacil.doacao.controller.dto.resp;

import jakarta.validation.constraints.NotBlank;

public record DoacaoDtoResp(
        String tipo,
        String descricao,
        Float valor,
        String data_doacao,
        String doador,
        String colaborador_id,
        String ong_id
) {
}