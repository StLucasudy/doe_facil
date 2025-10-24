package br.com.doefacil.srv.ongs.controller.dto.req;

import jakarta.validation.constraints.NotBlank;

public record OngReqDto(
        @NotBlank
        String nome,
        @NotBlank
        String cnpj,
        @NotBlank
        String telefone,
        @NotBlank
        String email,
        @NotBlank
        String area_autacao,
        @NotBlank
        String nome_rua,
        @NotBlank
        String senha,
        @NotBlank
        String confirmacao_senha
){
}
