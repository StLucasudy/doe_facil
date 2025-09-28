package br.com.doefacil.srv.colaboradores.service;

import br.com.doefacil.srv.colaboradores.repository.entity.EnderecoEntity;

public interface IEnderecoService {

    void createEndereco(EnderecoEntity endereco);

    EnderecoEntity findByID(Long id);

}
