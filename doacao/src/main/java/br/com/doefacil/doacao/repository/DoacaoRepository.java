package br.com.doefacil.doacao.repository;

import br.com.doefacil.doacao.repository.entity.DoacaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoacaoRepository extends JpaRepository<DoacaoEntity, Long> {
}
