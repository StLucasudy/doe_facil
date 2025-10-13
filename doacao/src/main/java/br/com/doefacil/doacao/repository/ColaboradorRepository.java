package br.com.doefacil.doacao.repository;

import br.com.doefacil.doacao.repository.entity.ColaboradorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColaboradorRepository extends JpaRepository<ColaboradorEntity, Long> {
}
