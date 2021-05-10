package main.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Autowired;

import main.domain.Cidade;
import main.domain.Estado;
import main.repositories.EstadoRepository;

public class CidadeDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	@NotEmpty(message = "Preenchimento obrigatório")
	@Length(min = 4, max = 20, message = "Nome de estado fora dos parametros")
	private String nome;
	@NotEmpty(message = "Preenchimento obrigatório")
	private String estado;
	public CidadeDTO() {

	}
	public CidadeDTO(Cidade obj) {
		id = obj.getId();
		nome = obj.getNome();
		estado=obj.getEstado().getNome();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
//	public String getEstado() {
//		return estado;
//	}
	public void setEstado(Estado estado) {
		this.estado = estado.getNome();
	}
	
}
