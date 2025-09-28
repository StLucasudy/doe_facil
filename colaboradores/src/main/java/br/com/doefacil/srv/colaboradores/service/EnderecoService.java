package br.com.doefacil.srv.colaboradores.service;

import br.com.doefacil.srv.colaboradores.repository.EnderecoRepository;
import br.com.doefacil.srv.colaboradores.repository.entity.EnderecoEntity;
import org.springframework.stereotype.Service;

@Service
public class EnderecoService implements IEnderecoService {

    private EnderecoRepository repository;

    public EnderecoService(EnderecoRepository repository) {
        this.repository = repository;
    }

    @Override
    public void createEndereco(EnderecoEntity endereco) {

    }

    @Override
    public EnderecoEntity findByID(Long id) {
        return repository.findById(id).orElseThrow();
    }
}
