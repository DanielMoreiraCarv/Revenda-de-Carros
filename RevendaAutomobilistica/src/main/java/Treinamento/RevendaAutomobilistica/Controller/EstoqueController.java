package Treinamento.RevendaAutomobilistica.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Treinamento.RevendaAutomobilistica.Class.Estoque;
import Treinamento.RevendaAutomobilistica.Service.EstoqueService;

@RestController
@RequestMapping("/estoque")
public class EstoqueController {
	@Autowired
	private EstoqueService estoqueService;

	@GetMapping()
	public List<Estoque> getEstoqueAll() {
		return estoqueService.getEstoqueAll();
	}

	@SuppressWarnings("unchecked")
	@GetMapping(value = "/buscar")
	public List<Estoque> getEstoqueByEndereco(@RequestParam(value = "endereco") String endereco,
			@RequestParam(value = "numEndereco",required = false) Integer numEndereco) {
		if(numEndereco==null) {
			return estoqueService.getEstoqueByEndereco(endereco);
		}else {
			return (List<Estoque>) estoqueService.getEstoqueByEndereco(endereco,numEndereco);
		}
	}
	
	@PostMapping(value = "/add",consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> saveEstoque(@RequestBody Estoque estoque){
		Estoque estoqueAux = estoqueService.getEstoqueByEndereco(estoque.getEndereco(), estoque.getNumEndereco());
		if(estoqueAux==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Estoque já cadastrado");
		}else {
			Estoque estoqueEs = estoqueService.saveEstoque(estoque);
			return ResponseEntity.ok("Estoque cadastrado\n"+estoqueEs);
		}
	}
	
	@DeleteMapping(value = "/delete")
	public ResponseEntity<String> deleteEstoque(@RequestParam(value = "endereco") String endereco,
			@RequestParam(value = "numEndereco") Integer numEndereco){
		Estoque estoque = estoqueService.getEstoqueByEndereco(endereco, numEndereco);
		if(estoque==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Estoque nesse endereço inexistente");
		}else {
			estoqueService.deleteEstoque(estoque);
			return ResponseEntity.ok("Estoque deletado");
		}
	}
}
