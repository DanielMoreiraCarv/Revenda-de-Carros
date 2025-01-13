package Treinamento.RevendaAutomobilistica.Controller;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Treinamento.RevendaAutomobilistica.Class.Funcionario;
import Treinamento.RevendaAutomobilistica.Service.FuncionarioService;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {

	@Autowired
	private FuncionarioService funcionarioService;

	@PostMapping(value = "/add")
	public Funcionario criarProduto(@RequestParam(value = "nome") String nome, @RequestParam(value = "cpf") String cpf,
			@RequestParam(value = "data") String dataS, @RequestParam(value = "codConta") String cod,
			@RequestParam(value = "agencia") String agencia, @RequestParam(value = "email") String email) {
		Funcionario funcionario = new Funcionario(nome, cpf, dataS, cod, agencia, email);
		boolean criacional = funcionarioService.salvarProduto(funcionario);
		if(criacional) {
			return funcionario;
		}else {
			return null;
		}
	}
	
	@PostMapping(value = "/add/json",consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> criarProduto(@RequestBody Funcionario funcionario) {
		Funcionario funcionarioVerificador = funcionarioService.getByCpf(funcionario.getCpf());
		if(funcionarioVerificador!=null) {
			return ResponseEntity.status(HttpStatus.FOUND).body("Funcionário já existente com esse cpf!");
		}else {
			LocalDate plusDays = funcionario.getDataNasc().toInstant().atZone(ZoneId.systemDefault()).toLocalDate().plusDays(1);
			Date data = Date.from(plusDays.atStartOfDay(ZoneId.systemDefault()).toInstant());
			funcionario.setDataNasc(data);
			funcionarioService.salvarProduto(funcionario);
			boolean criacional = funcionarioService.salvarProduto(funcionario);
			if(criacional) {
				return ResponseEntity.ok("Funcionario Cadastrado com sucesso\n"+ funcionario);
			}
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Funcionário não pode ser cadastrado devido a sua idade!");
		}
		
	}

	@GetMapping(value = "/all")
	public List<Funcionario> listarProdutos() {
		return funcionarioService.listarProdutos();
	}

	@GetMapping(value = "/busca/{nome}")
	public List<Funcionario> getProduto(@PathVariable(value = "nome") String nome) {
		return funcionarioService.getByNome(nome);
	}

	@DeleteMapping(value = "/delete")
	public void deletarFuncionario(@RequestParam(value = "cpf") String cpf) {
		Funcionario f = funcionarioService.getByCpf(cpf);
		funcionarioService.deleteById(f.getId());
	}

	@PutMapping(value = "/atualizar")
	public void atualizarNome(@RequestParam(value = "cpf") String cpf, @RequestParam(value = "nome") String nome) {
		Funcionario po = funcionarioService.getByCpf(cpf);
		funcionarioService.atualizarNome(po, nome);
	}

	@PatchMapping(value = "/atualizar/datas")
	public void atualizarData(@RequestParam(value = "dataNasc") String DataNasc,
			@RequestParam(value = "cpf") String cpf) {
		Funcionario funcionario = funcionarioService.getByCpf(cpf);
		Date data = Date.from(LocalDate.parse(DataNasc).atStartOfDay(ZoneId.systemDefault()).toInstant());
		funcionarioService.atualizarDataNasc(funcionario, data);
	}
}
