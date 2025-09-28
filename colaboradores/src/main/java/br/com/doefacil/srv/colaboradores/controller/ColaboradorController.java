package br.com.doefacil.srv.colaboradores.controller;

import br.com.doefacil.srv.colaboradores.controller.req.ColaboradorReqDto;
import br.com.doefacil.srv.colaboradores.controller.resp.ColaboradorRespDto;
import br.com.doefacil.srv.colaboradores.repository.entity.ColaboradorEntity;
import br.com.doefacil.srv.colaboradores.service.iservice.IColaboradorService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Colaboradores")
public class ColaboradorController {

    private IColaboradorService iColaboradorService;

    public ColaboradorController(IColaboradorService iColaboradorService) {
        this.iColaboradorService = iColaboradorService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    void createNewColaborador(@RequestBody @Valid ColaboradorReqDto req) {
        iColaboradorService.creatColaborador(req);
    }

    @GetMapping("/{id}")
    ResponseEntity<ColaboradorRespDto> findColaborador(@PathVariable("id") Long id ){
        ColaboradorEntity entity =  iColaboradorService.findById(id);
        return new ResponseEntity<ColaboradorRespDto>(
                new ColaboradorRespDto(
                        entity.getNome(),
                        entity.getCpf(),
                        entity.getEmail(),
                        entity.getTelefone(),
                        entity.getCargo(),
                        entity.getEndereco().getId(),
                        entity.getOng().getId()
                ), HttpStatus.OK);
    }
}
