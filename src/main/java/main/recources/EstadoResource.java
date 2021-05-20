package main.recources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import main.domain.Cidade;
import main.domain.Cliente;
import main.domain.Estado;
import main.dto.CidadeDTO;
import main.dto.EstadoDTO;
import main.services.CidadeService;
import main.services.EstadoService;

@RestController
@RequestMapping(value = "/estados")
public class EstadoResource {
	@Autowired
	private EstadoService service;
	@Autowired
	private CidadeService cidadeService;

	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<EstadoDTO>> findAll() {
		List<Estado> list = service.findAll();
		List<EstadoDTO> listDto = list.stream().map(obj -> new EstadoDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<EstadoDTO> find(@PathVariable Integer id) {
		Estado obj = service.find(id);
		EstadoDTO objDto= new EstadoDTO(obj);
		return ResponseEntity.ok().body(objDto);
	}
	@RequestMapping(value="{estado}/cidades" ,method = RequestMethod.GET)
	public ResponseEntity<List<CidadeDTO>> findAll(@PathVariable Integer estado) {
		List<Cidade> list = cidadeService.findAll(estado);
		List<CidadeDTO> listDto = list.stream().map(obj -> new CidadeDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
}