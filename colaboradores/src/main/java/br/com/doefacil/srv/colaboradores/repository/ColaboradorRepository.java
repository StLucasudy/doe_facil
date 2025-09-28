package br.com.doefacil.srv.colaboradores.repository;

import br.com.doefacil.srv.colaboradores.repository.entity.ColaboradorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ColaboradorRepository extends JpaRepository<ColaboradorEntity, Long> {
}
