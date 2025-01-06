package Treinamento.Revenda;



import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class For_FornecedorController {
	private For_FornecedorService service;

	@GetMapping(value = "/fornecedor/getAll", produces =  { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public List<For_Fornecedor> findAll() {
		return service.getFornecedorAll();
	}

	@GetMapping(value = "/fornecedor/{cpf}", produces = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public For_Fornecedor findByCpf(@PathVariable(value = "cpf") String cpf) {
		return service.getFornecedorPorCpf(cpf);
	}

	@DeleteMapping(value = "/fornecedor/remover/{cpf}")
	public ResponseEntity<String> deletarFornecedor(@PathVariable(value = "cpf") String cpf) {
		For_Fornecedor f1 = service.getFornecedorPorCpf(cpf);
		boolean uD = service.removeFornecedor(f1);
		if (uD) {
			return ResponseEntity.ok("Funcionário Deletado\n" + f1);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não localizado");
		}
	}

	@PostMapping("/fornecedor/adicionar/{nome}/{cpf}/{numTelefone}/{email}/{codConta}/{agencia}")
	public ResponseEntity<String> addUsuario(@PathVariable(value = "nome") String nome,
			@PathVariable(value = "cpf") String cpf, @PathVariable(value = "numTelefone") String numTelefone,
			@PathVariable(value = "email") String email, @PathVariable(value = "codConta") String codConta,
			@PathVariable(value = "agencia") String agencia) {
		For_Fornecedor fornecedor = new For_Fornecedor(nome, cpf, numTelefone, email, codConta, agencia);
		int response = service.addFornecedor(fornecedor);
		if (response == 0) {
			return ResponseEntity.ok("Funcionario adicionado\n" + fornecedor);
		} else if (response == 1) {
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("Erro na adição do funcionario");
		} else if (response == 2) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Funcionario já cadastrado");
		} else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro com o sql");
		}
	}
	
	@PutMapping("/fornecedor/mudar/{cpf}")
	public ResponseEntity<String> updateFornecedor(@RequestParam(value = "nome", required = false) String nome,
			@PathVariable(value = "cpf") String cpf,
			@RequestParam(value = "numTelefone", required = false) String numTelefone,
			@RequestParam(value = "cpf", required = false) String cpfNovo,
			@RequestParam(value = "email", required = false) String email,
			@RequestParam(value = "codConta", required = false) String codConta,
			@RequestParam(value = "agencia", required = false) String agencia) {
		For_Fornecedor funcionario = service.getFornecedorPorCpf(cpf);
		boolean response = false;
		if (funcionario != null) {
			if (nome != null) {
				service.atualzarFornecedor("nome", nome, cpf);
				response = true;
			}

			if (numTelefone != null) {
				service.atualzarFornecedor("numTelefone", numTelefone, cpf);
				response = true;
			}

			if (email != null) {
				service.atualzarFornecedor("email", email, cpf);
				response = true;
			}


			if (codConta != null) {
				service.atualzarFornecedor("codConta", codConta, cpf);
				response = true;
			}

			if (agencia != null) {
				service.atualzarFornecedor("agencia", agencia, cpf);
				response = true;
			}
			if (cpf != null) {
				service.atualzarFornecedor("cpf", cpfNovo, cpf);
				cpf = cpfNovo;
				response = true;
			}

			if (response) {
				return ResponseEntity.ok("Atualização do funcionário realizada" + service.getFornecedorPorCpf(cpf));
			} else {
				return ResponseEntity.status(HttpStatus.CONFLICT).body("Erro na atualização");
			}
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Funcionario não localizado");

	}
	
	@PatchMapping("/fornecedor/{info}/{dadoNovo}/{cpf}")
	public ResponseEntity<String> patchFunc(@PathVariable(value = "cpf") String cpf,
			@PathVariable(value = "info") String info, @PathVariable(value = "dadoNovo") String dadoNovo) {
		boolean response = service.atualzarFornecedor(info, dadoNovo, cpf);
		if (response) {
			return ResponseEntity.ok(info + " do Funcioário atualizada\n" + service.getFornecedorPorCpf(cpf));
		} else {
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("Erro na atualização");
		}
	}
}
