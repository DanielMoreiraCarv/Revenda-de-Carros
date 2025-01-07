package Treinamento.Revenda.Controller;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Treinamento.Revenda.Est_Estoque;
import Treinamento.Revenda.Service.Est_EstoqueService;

@RestController
public class Est_EstoqueController {
	@Autowired
	private Est_EstoqueService service;

	@GetMapping(value = "/estoque", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public List<Est_Estoque> findAll() {
		return service.getEstoqueAll();
	}

	@GetMapping(value = "/estoque/buscar/{rua}", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public List<Est_Estoque> findByCpf(@PathVariable(value = "rua") String rua) {
		return service.getEstoqueAllRua(rua);
	}

	@GetMapping(value = "/estoque/buscar/{rua}/{num}", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public Est_Estoque findByCpf(@PathVariable(value = "rua") String rua, @PathVariable(value = "num") int num) {
		return service.getEstoquePorEnderecoCompleto(rua, num);
	}

	@DeleteMapping(value = "/estoque/remover/{cpf}")
	public ResponseEntity<String> deletarestoque(@PathVariable(value = "rua") String rua,
			@PathVariable(value = "num") int num) {
		Est_Estoque e1 = service.getEstoquePorEnderecoCompleto(rua, num);
		boolean uD = service.removeEstoque(e1);
		if (uD) {
			return ResponseEntity.ok("estoque Deletado\n" + e1);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não localizado");
		}
	}

	@PostMapping("/estoque/adicionar/{rua}/{num}/{filial}")
	public ResponseEntity<String> addestoque(@PathVariable(value = "rua") String rua,
			@PathVariable(value = "num") int num, @PathVariable(value = "filial") int filial) {
		Est_Estoque estoque = new Est_Estoque(rua, num, filial);
		int response = service.addEstoque(estoque);
		if (response == 0) {
			return ResponseEntity.ok("estoque adicionado\n" + estoque);
		} else if (response == 1) {
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("Erro na adição do estoque");
		} else if (response == 2) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("estoque já cadastrado");
		} else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro com o sql");
		}
	}

	@PutMapping("/estoque/mudar/{rua}/{num}")
	public ResponseEntity<String> updateestoque(@RequestParam(value = "ruaAlt", required = false) String ruaAlt,
			@PathVariable(value = "rua") String rua, @PathVariable(value = "num") int num,
			@RequestParam(value = "numAlt", required = false) int numAlt,
			@RequestParam(value = "filial", required = false) int filial) {
		Est_Estoque estoque = service.getEstoquePorEnderecoCompleto(rua, num);
		boolean response = false;
		if (estoque != null) {
			if (ruaAlt != null) {
				service.atualzarEstoqueDsc(ruaAlt, estoque);
				response = true;
			}

			if (numAlt != 0) {
				service.atualzarEstoqueNumOuFilial("Num", numAlt, estoque);
				response = true;
			}

			if (filial != 0) {
				service.atualzarEstoqueNumOuFilial("Filial", filial, estoque);
				response = true;
			}


			if (response) {
				return ResponseEntity.ok("Atualização do funcionário realizada" + service.getEstoquePorEnderecoCompleto(rua,num));
			} else {
				return ResponseEntity.status(HttpStatus.CONFLICT).body("Erro na atualização");
			}
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Funcionario não localizado");

	}
}
