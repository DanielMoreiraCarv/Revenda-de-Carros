package Treinamento.RevendaAutomobilistica.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Treinamento.RevendaAutomobilistica.Class.Marca;
import Treinamento.RevendaAutomobilistica.Service.MarcaService;

@RestController
@RequestMapping("/marca")
public class MarcaController {
	@Autowired
	private MarcaService marcaService;

	@GetMapping()
	public List<Marca> getMarcaAll() {
		return marcaService.getMarcaAll();
	}
	
	@GetMapping(value = "/buscar")
	public List<Marca> getMarcaLike(@RequestParam(value = "nome")String nome) {
		return marcaService.getMarcaLike(nome);
	}

	@PostMapping(value = "/add/json", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> criarProduto(@RequestBody Marca marca) {
		Marca MarcaVerificador = marcaService.getMarca(marca.getNome());
		if (MarcaVerificador != null) {
			return ResponseEntity.status(HttpStatus.FOUND).body("Funcionário já existente com esse cpf!");
		} else {
			marcaService.salvarMarca(marca);
			return ResponseEntity.ok("Funcionario Cadastrado com sucesso\n" + marca);
		}

	}

	@DeleteMapping(value = "/delete")
	public ResponseEntity<String> deleteMarca(@RequestParam(value = "nome") String nome) {
		Marca marca = marcaService.getMarca(nome);
		if (marca == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Marca não encontrada");
		} else {
			marcaService.deleteMarca(marca);
			return ResponseEntity.ok("Marca deletada");
		}
	}

	@PutMapping(value = "/atualizar/{nomeAtual}")
	public ResponseEntity<String> atualizarNome(@RequestParam(value = "nome") String nome,
			@PathVariable(value = "nomeAtual") String nomeAtual) {
		Marca marca = marcaService.getMarca(nomeAtual);
		if(marca==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Marca com esse nome não existente");
		}else {
			marcaService.atualizarNome(marca.getId(), nome);
			return ResponseEntity.ok("Nome da Marca atualizado");
		}
	}
}
