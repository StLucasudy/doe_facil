package br.com.doefacil.srv.colaboradores.controller.req;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.br.CPF;

public record ColaboradorReqDto(
        @NotBlank
        String nome,
        @NotBlank
        @CPF
        String cpf,
        @NotBlank
        @Email
        String email,
        @NotBlank
        //@Pattern("") -> regex para validar o telefone
        String telefone,
        @NotBlank
        String cargo,
        @NotNull
        Integer idOng
) {
}
