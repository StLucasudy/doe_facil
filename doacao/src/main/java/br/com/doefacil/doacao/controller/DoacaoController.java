package br.com.doefacil.doacao.controller;

import br.com.doefacil.doacao.controller.dto.req.DoacaoRequestDto;
import br.com.doefacil.doacao.controller.dto.resp.DoacaoDtoResp;
import br.com.doefacil.doacao.repository.entity.DoacaoEntity;
import br.com.doefacil.doacao.service.IDoeacaoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/doacao")
public class DoacaoController {

    IDoeacaoService service;

    public DoacaoController(IDoeacaoService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    void criarDoacao(@RequestBody @Valid DoacaoRequestDto requestDto) {
        service.createDoacao(requestDto);
    }

    @GetMapping("/{id}")
    ResponseEntity<DoacaoDtoResp> findDoacao(@PathVariable("id") Long id) {
        DoacaoEntity doacao = service.findDoacao(id);
        return ResponseEntity.ok(new DoacaoDtoResp(
                doacao.getTipo(),
                doacao.getDescricao(),
                doacao.getValor(),
                doacao.getData_doacao().toString(),
                doacao.getDoador(),
                doacao.getColaborador().getId().toString(),
                doacao.getOng().getId().toString()
        ));
    }
}
