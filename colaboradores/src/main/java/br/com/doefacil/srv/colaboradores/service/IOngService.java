package br.com.doefacil.srv.colaboradores.service;

import br.com.doefacil.srv.colaboradores.repository.entity.OngEntity;

public interface IOngService {

    void createOng(OngEntity ong);

    OngEntity findById(Long id);
}
