package br.com.doefacil.srv.ongs.service;

import br.com.doefacil.srv.ongs.controller.dto.req.OngReqDto;
import br.com.doefacil.srv.ongs.repository.EnderecoNotFound;
import br.com.doefacil.srv.ongs.repository.EnderecoRepository;
import br.com.doefacil.srv.ongs.repository.OngRepository;
import br.com.doefacil.srv.ongs.repository.entity.EnderecoEntity;
import br.com.doefacil.srv.ongs.repository.entity.OngsEntity;
import br.com.doefacil.srv.ongs.service.exception.PassWordNotMatch;
import org.springframework.stereotype.Service;

@Service
public class OngsService implements IOngsService {

    private final OngRepository ongRepository;
    private final EnderecoRepository enderecoRepository;
    private final String MESSAGE_ERRO_ENDERECO = "Endereco não localizado, verifique se a rua está com o nome certo.";

    public OngsService(OngRepository ongRepository, EnderecoRepository enderecoRepository) {
        this.ongRepository = ongRepository;
        this.enderecoRepository = enderecoRepository;
    }

    @Override
    public void saveNewRepo(OngReqDto req) {

        validaSenha(req);

        EnderecoEntity endereco = enderecoRepository.findByRuaLike(req.nome_rua())
                .orElseThrow(() -> new EnderecoNotFound(MESSAGE_ERRO_ENDERECO));

        ongRepository.save(
                new OngsEntity(
                        req.nome(),
                        req.cnpj(),
                        req.email(),
                        req.telefone(),
                        req.area_autacao(),
                        req.senha(),
                        endereco
                )
        );
    }

    @Override
    public OngsEntity findById(Long id) {
        return ongRepository.findById(id).orElseThrow();
    }

    public void validaSenha(OngReqDto req){
        if (!req.senha().equals(req.confirmacao_senha()))
            throw new PassWordNotMatch("As senhas precisam ser as mesmas.");
    }

}
