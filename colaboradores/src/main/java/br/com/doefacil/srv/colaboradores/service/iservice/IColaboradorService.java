package br.com.doefacil.srv.colaboradores.service.iservice;

import br.com.doefacil.srv.colaboradores.controller.req.ColaboradorReqDto;
import br.com.doefacil.srv.colaboradores.repository.entity.ColaboradorEntity;

public interface IColaboradorService {
    void creatColaborador(ColaboradorReqDto colaborador);
    ColaboradorEntity findById(Long id);
}
