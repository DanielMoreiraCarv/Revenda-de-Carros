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

import Treinamento.RevendaAutomobilistica.Class.Fornecedor;
import Treinamento.RevendaAutomobilistica.Service.FornecedorService;

@RestController
@RequestMapping("/fornecedor")
public class FornecedorController {
	@Autowired
	private FornecedorService fornecedorService;

	@PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> addFornecedor(@RequestBody Fornecedor fornecedor) {
		Fornecedor fornecedorVerificador = fornecedorService.getByIdentificador(fornecedor.getIdentificador());
		if (fornecedorVerificador == null) {
			fornecedorService.salvarFornecedor(fornecedor);
			return ResponseEntity.ok("Fornecedor Adicionado ao sistema com sucesso!\n"
					+ fornecedorService.getByIdentificador(fornecedor.getIdentificador()));

		} else {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Fornecedor já cadastrado com esse identificador"
					+ fornecedorService.getByIdentificador(fornecedor.getIdentificador()));
		}
	}

	@GetMapping()
	public List<Fornecedor> getAll() {
		return fornecedorService.getAll();
	}

	@GetMapping(value = "/{identificador}")
	public Fornecedor getFornecedorByIdentificador(@PathVariable(value = "identificador") String identificador) {
		return fornecedorService.getByIdentificador(identificador);
	}

	@DeleteMapping(value = "/delete")
	public ResponseEntity<String> deleteFornecedor(@RequestParam(value = "identificador") String identificador) {
		fornecedorService.deleteFornecedor(fornecedorService.getByIdentificador(identificador));
		return ResponseEntity.ok("Fornecedor Deletado");
	}

	@PutMapping(value = "/atualizar")
	public ResponseEntity<String> atualizarNome(@RequestParam(value = "nome") String nome,
			@RequestParam(value = "identificador") String identificador) {
		Fornecedor fornecedor = fornecedorService.getByIdentificador(identificador);
		if(fornecedor==null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Fornecedor não localizado!");
		}else {
			fornecedorService.atualizarNome(fornecedor, nome);
			return ResponseEntity.ok("Fornecedor Atualizado");
		}
	}
	
	@GetMapping(value = "/buscar/{nome}")
	public List<Fornecedor> fornecedorByName(@PathVariable(value = "nome")String nome){
		return fornecedorService.findNameLike(nome);
	}

}
