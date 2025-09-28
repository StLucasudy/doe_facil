package br.com.doefacil.srv.colaboradores.controller;

import br.com.doefacil.srv.colaboradores.controller.req.ColaboradorReqDto;
import br.com.doefacil.srv.colaboradores.service.IColaboradorService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
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
}
