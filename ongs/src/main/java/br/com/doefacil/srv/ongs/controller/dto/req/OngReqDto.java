package br.com.doefacil.srv.ongs.controller.dto.req;

import jakarta.validation.constraints.NotBlank;

public record OngReqDto(
        @NotBlank
        String nome,
        @NotBlank
        String area_autacao,
        @NotBlank
        String cnpj,
        @NotBlank
        String cep,
        @NotBlank
        String senha,
        @NotBlank
        String confirmacao_senha,
        @NotBlank
        String email,
        @NotBlank
        String telefone,
        @NotBlank
        String responsavel,
        @NotBlank
        String cpf
){
}