package br.com.doefacil.srv.ongs.controller;

import br.com.doefacil.srv.ongs.controller.dto.req.OngReqDto;
import br.com.doefacil.srv.ongs.controller.dto.resp.OngRespDto;
import br.com.doefacil.srv.ongs.repository.entity.OngsEntity;
import br.com.doefacil.srv.ongs.service.IOngsService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ongs")
public class OngsController {

    IOngsService service;

    public OngsController(IOngsService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    void createOng(@RequestBody @Valid OngReqDto req) {
        service.saveNewRepo(req);
    }

    @GetMapping("/{id}")
    ResponseEntity<OngRespDto> findOng(@PathVariable Long id) {
        OngsEntity ong = service.findById(id);

        return ResponseEntity.ok(
                new OngRespDto(
                        ong.getNome(),
                        ong.getcnpj(),
                        ong.getTelefone(),
                        ong.getTelefone(),
                        ong.getAreaAtuacao(),
                        ong.getEndereco().getRua()
                )
        );
    }
}