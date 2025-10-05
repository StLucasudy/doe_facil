package br.com.doefacil.srv.ongs.repository;

import br.com.doefacil.srv.ongs.repository.entity.OngsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface OngRepository extends JpaRepository<OngsEntity, Long> {
}
