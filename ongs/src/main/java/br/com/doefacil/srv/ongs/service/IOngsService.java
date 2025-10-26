package br.com.doefacil.srv.ongs.service;

import br.com.doefacil.srv.ongs.controller.dto.req.LoginDtoReq;
import br.com.doefacil.srv.ongs.controller.dto.req.OngReqDto;
import br.com.doefacil.srv.ongs.repository.entity.OngsEntity;

public interface IOngsService {

    void saveNewRepo(OngReqDto ong);

    OngsEntity findById(Long id);

    Boolean login(LoginDtoReq req);

}
