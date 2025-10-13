package br.com.doefacil.doacao.service;

import br.com.doefacil.doacao.controller.dto.req.DoacaoRequestDto;
import br.com.doefacil.doacao.repository.ColaboradorRepository;
import br.com.doefacil.doacao.repository.DoacaoRepository;
import br.com.doefacil.doacao.repository.OngRepository;
import br.com.doefacil.doacao.repository.entity.DoacaoEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class DoeacaoService implements IDoeacaoService {

    DoacaoRepository doacaoRepository;
    OngRepository ongRepository;
    ColaboradorRepository colaboradorRepository;

    public DoeacaoService(DoacaoRepository doacaoRepository, OngRepository ongRepository, ColaboradorRepository colaboradorRepository) {
        this.doacaoRepository = doacaoRepository;
        this.ongRepository = ongRepository;
        this.colaboradorRepository = colaboradorRepository;
    }

    @Override
    public void createDoacao(DoacaoRequestDto req) {

        Long idCola = Long.parseLong(req.colaborador_id());
        Long idOng = Long.parseLong(req.ong_id());
        LocalDate date = LocalDate.parse(req.data_doacao(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        doacaoRepository.save(
                new DoacaoEntity(
                        req.tipo(),
                        req.descricao(),
                        req.valor(),
                        date,
                        req.doador(),
                        colaboradorRepository.findById(idCola).orElseThrow(),
                        ongRepository.findById(idOng).orElseThrow()
                )
        );
    }

    @Override
    public DoacaoEntity findDoacao(Long id) {
        return doacaoRepository.findById(id).orElseThrow();
    }
}
