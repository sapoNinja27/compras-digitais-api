package main;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import main.domain.Categoria;
import main.domain.Cidade;
import main.domain.Cliente;
import main.domain.Estado;
import main.domain.Produto;
import main.domain.enums.TipoCliente;
import main.repositories.CategoriaRepository;
import main.repositories.CidadeRepository;
import main.repositories.EstadoRepository;
import main.repositories.ProdutoRepository;

@SpringBootApplication
public class McApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private EstadoRepository estadoRepository;

	public static void main(String[] args) {
		SpringApplication.run(McApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null, "Informatica");
		Categoria cat2 = new Categoria(null, "Escritorio");
		
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);

		cat1.getProdutos().addAll(Arrays.asList(p1, p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));

		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1, p2,p3));
		
		Estado est1 = new Estado(null,"Minas Gerais");
		Estado est2 = new Estado(null,"Sao Paulo");
		
		Cidade c1 = new Cidade(null,"Uberlandia",est1);
		Cidade c2 = new Cidade(null,"Sao Paulo",est2);
		Cidade c3 = new Cidade(null,"Campinas",est2);
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2,c3));
		estadoRepository.saveAll(Arrays.asList(est1,est2));
		cidadeRepository.saveAll(Arrays.asList(c1,c2,c3));
		
		Cliente cli1 = new Cliente(null,"Maria Silva","maria@gmail.com","36378912377",TipoCliente.PESSOAFISICA);
		
	}

}
