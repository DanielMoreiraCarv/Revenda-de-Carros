package Treinamento.Revenda;

import static Treinamento.Revenda.Fun_FuncionarioService.getFuncionarioPorCpf;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Fun_FuncionarioController {

	@Autowired
	private Fun_FuncionarioService service;

	@GetMapping(value = "/funcionario", produces = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public List<Fun_Funcionario> findAll() {
		return service.getFuncionarioAll();
	}

	@GetMapping(value = "/{cpf}", produces = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public Fun_Funcionario findByCpf(@PathVariable(value = "cpf") String cpf) {
		return getFuncionarioPorCpf(cpf);
	}

	@DeleteMapping(value = "/funcionario/remover/{cpf}")
	public ResponseEntity<String> deletarUsuario(@PathVariable(value = "cpf") String cpf) {
		Fun_Funcionario f1 = getFuncionarioPorCpf(cpf);
		boolean uD = service.removeFuncionario(cpf);
		if (uD) {
			return ResponseEntity.ok("Funcionário Deletado\n" + f1);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não localizado");
		}
	}

	@PostMapping("/adicionar/{nome}/{cpf}/{numTelefone}/{email}/{dia}/{mes}/{ano}/{codConta}/{agencia}")
	public ResponseEntity<String> addUsuario(@PathVariable(value = "nome") String nome,
			@PathVariable(value = "cpf") String cpf, @PathVariable(value = "numTelefone") String numTelefone,
			@PathVariable(value = "email") String email, @PathVariable(value = "dia") String dia,
			@PathVariable(value = "mes") String mes, @PathVariable(value = "ano") String ano,
			@PathVariable(value = "codConta") String codConta, @PathVariable(value = "agencia") String agencia) {
		String datNasc = dia + "/" + mes + "/" + ano;
		Fun_Funcionario funcionarioAdd = new Fun_Funcionario(nome, cpf, numTelefone, email, datNasc, codConta, agencia);
		int response = service.addFuncionario(funcionarioAdd);
		if (response == 0) {
			return ResponseEntity.ok("Funcionario adicionado\n" + funcionarioAdd);
		} else if (response == 1) {
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("Erro na adição do funcionario");
		} else if (response == 2) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Funcionario já cadastrado");
		} else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro com o sql");
		}
	}

	@PutMapping("/mudar/{cpf}")
	public ResponseEntity<String> updateFunc(@RequestParam(value = "nome", required = false) String nome,
			@PathVariable(value = "cpf") String cpf,
			@RequestParam(value = "numTelefone", required = false) String numTelefone,
			@RequestParam(value = "cpf", required = false) String cpfNovo,
			@RequestParam(value = "email", required = false) String email,
			@RequestParam(value = "data", required = false) String data,
			@RequestParam(value = "codConta", required = false) String codConta,
			@RequestParam(value = "agencia", required = false) String agencia) {
		Fun_Funcionario funcionario = getFuncionarioPorCpf(cpf);
		boolean response = false;
		if (funcionario != null) {
			if (nome != null) {
				service.atualzarFuncionario("nome", nome, cpf);
				response = true;
			}

			if (numTelefone != null) {
				service.atualzarFuncionario("numTelefone", numTelefone, cpf);
				response = true;
			}

			if (email != null) {
				service.atualzarFuncionario("email", email, cpf);
				response = true;
			}

			if (data != null) {
				service.atualzarFuncionario("data", data, cpf);
				response = true;
			}

			if (codConta != null) {
				service.atualzarFuncionario("codConta", codConta, cpf);
				response = true;
			}

			if (agencia != null) {
				service.atualzarFuncionario("agencia", agencia, cpf);
				response = true;
			}
			if (cpf != null) {
				service.atualzarFuncionario("cpf", cpfNovo, cpf);
				cpf = cpfNovo;
				response = true;
			}

			if (response) {
				return ResponseEntity.ok("Atualização do funcionário realizada" + getFuncionarioPorCpf(cpf));
			} else {
				return ResponseEntity.status(HttpStatus.CONFLICT).body("Erro na atualização");
			}
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Funcionario não localizado");

	}

	@PatchMapping("/{info}/{dadoNovo}/{cpf}")
	public ResponseEntity<String> patchFunc(@PathVariable(value = "cpf") String cpf,
			@PathVariable(value = "info") String info, @PathVariable(value = "dadoNovo") String dadoNovo) {
		boolean response = service.atualzarFuncionario(info, dadoNovo, cpf);
		if (response) {
			return ResponseEntity.ok(info + " do Funcioário atualizada\n" + getFuncionarioPorCpf(cpf));
		} else {
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("Erro na atualização");
		}
	}

}
