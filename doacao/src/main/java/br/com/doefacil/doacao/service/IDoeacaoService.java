package br.com.doefacil.doacao.service;

import br.com.doefacil.doacao.controller.dto.req.DoacaoRequestDto;
import br.com.doefacil.doacao.repository.entity.DoacaoEntity;

public interface IDoeacaoService {

    void createDoacao(DoacaoRequestDto req);

    DoacaoEntity findDoacao(Long id);
}
