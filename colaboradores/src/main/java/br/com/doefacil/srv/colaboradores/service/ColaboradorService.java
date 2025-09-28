package br.com.doefacil.srv.colaboradores.service;

import br.com.doefacil.srv.colaboradores.controller.req.ColaboradorReqDto;
import br.com.doefacil.srv.colaboradores.repository.ColaboradorRepository;
import br.com.doefacil.srv.colaboradores.repository.entity.ColaboradorEntity;
import org.springframework.stereotype.Service;

@Service
public class ColaboradorService implements IColaboradorService {

    private IEnderecoService enderecoService;
    private IOngService ongService;
    private ColaboradorRepository repository;

    public ColaboradorService(IEnderecoService enderecoService, IOngService ongService, ColaboradorRepository repository) {
        this.enderecoService = enderecoService;
        this.ongService = ongService;
        this.repository = repository;
    }

    @Override
    public void creatColaborador(ColaboradorReqDto colaborador) {


        repository.save(new ColaboradorEntity(
                colaborador.nome(),
                colaborador.cpf(),
                colaborador.email(),
                colaborador.telefone(),
                colaborador.cargo(),
                enderecoService.findByID(colaborador.idEndereco().longValue()),
                ongService.findById(colaborador.idOng().longValue())
        ));
    }

    @Override
    public ColaboradorEntity findById(Long id) {
        return null;
    }
}
