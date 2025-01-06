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

public class Cli_ClienteController {
	private Cli_ClienteService service;

	@GetMapping(value = "/cliente", produces =  { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public List<Cli_Cliente> findAll() {
		return service.getClienteAll();
	}

	@GetMapping(value = "/cliente/{cpf}", produces = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public Cli_Cliente findByCpf(@PathVariable(value = "cpf") String cpf) {
		return service.getClientePorCpf(cpf);
	}

	@DeleteMapping(value = "/cliente/remover/{cpf}")
	public ResponseEntity<String> deletarcliente(@PathVariable(value = "cpf") String cpf) {
		Cli_Cliente c1 = service.getClientePorCpf(cpf);
		boolean uD = service.removeClietne(c1);
		if (uD) {
			return ResponseEntity.ok("Cliente Deletado\n" + c1);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não localizado");
		}
	}

	@PostMapping("/cliente/adicionar/{nome}/{cpf}/{numTelefone}/{email}/{codConta}/{agencia}")
	public ResponseEntity<String> addCliente(@PathVariable(value = "nome") String nome,
			@PathVariable(value = "cpf") String cpf, @PathVariable(value = "numTelefone") String numTelefone,
			@PathVariable(value = "email") String email, @PathVariable(value = "codConta") String codConta,
			@PathVariable(value = "agencia") String agencia) {
		Cli_Cliente cliente = new Cli_Cliente(nome, cpf, numTelefone, email);
		int response = service.addCliente(cliente);
		if (response == 0) {
			return ResponseEntity.ok("Cliente adicionado\n" + cliente);
		} else if (response == 1) {
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("Erro na adição do cliente");
		} else if (response == 2) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Cliente já cadastrado");
		} else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro com o sql");
		}
	}
	
	@PutMapping("/cliente/mudar/{cpf}")
	public ResponseEntity<String> updateCliente(@RequestParam(value = "nome", required = false) String nome,
			@PathVariable(value = "cpf") String cpf,
			@RequestParam(value = "numTelefone", required = false) String numTelefone,
			@RequestParam(value = "cpf", required = false) String cpfNovo,
			@RequestParam(value = "email", required = false) String email,
			@RequestParam(value = "codConta", required = false) String codConta,
			@RequestParam(value = "agencia", required = false) String agencia) {
		Cli_Cliente cliente = service.getClientePorCpf(cpf);
		boolean response = false;
		if (cliente != null) {
			if (nome != null) {
				service.atualzarCliente("nome", agencia, cpfNovo);
				response = true;
			}

			if (numTelefone != null) {
				service.atualzarCliente("numTelefone", numTelefone, cpf);
				response = true;
			}

			if (email != null) {
				service.atualzarCliente("email", email, cpf);
				response = true;
			}

			if (cpf != null) {
				service.atualzarCliente("cpf", cpfNovo, cpf);
				cpf = cpfNovo;
				response = true;
			}

			if (response) {
				return ResponseEntity.ok("Atualização do funcionário realizada" + service.getClientePorCpf(cpf));
			} else {
				return ResponseEntity.status(HttpStatus.CONFLICT).body("Erro na atualização");
			}
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Funcionario não localizado");

	}
	
	@PatchMapping("/cliente/{info}/{dadoNovo}/{cpf}")
	public ResponseEntity<String> patchCli(@PathVariable(value = "cpf") String cpf,
			@PathVariable(value = "info") String info, @PathVariable(value = "dadoNovo") String dadoNovo) {
		boolean response = service.atualzarCliente(info, dadoNovo, cpf);
		if (response) {
			return ResponseEntity.ok(info + " do Funcioário atualizada\n" + service.getClientePorCpf(cpf));
		} else {
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("Erro na atualização");
		}
	}
}
