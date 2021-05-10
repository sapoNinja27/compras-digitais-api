package main.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.domain.Cidade;
import main.domain.Estado;
import main.repositories.CidadeRepository;
import main.repositories.EstadoRepository;

@Service
public class CidadeService {
	@Autowired
	private CidadeRepository repo;
	@Autowired
	private EstadoRepository estadoRepository;


	public List<Cidade> findAll(Integer estado) {
		Estado obj= estadoRepository.getOne(estado);
		return repo.findByEstado(obj);
	}

	
}
