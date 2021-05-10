package main.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import main.domain.Cidade;
import main.domain.Estado;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Integer> {
	@Transactional(readOnly=true)
	List<Cidade> findByEstado(Estado estado);
}
