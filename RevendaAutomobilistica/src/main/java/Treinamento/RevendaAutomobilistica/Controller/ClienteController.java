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

import Treinamento.RevendaAutomobilistica.Class.Cliente;
import Treinamento.RevendaAutomobilistica.Service.ClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
	@Autowired
	private ClienteService clienteService;

	@GetMapping()
	public List<Cliente> getClienteAll() {
		return clienteService.getAllClientes();
	}

	@GetMapping(value = "/buscar/{cpf}")
	public Cliente getCliente(@PathVariable(value = "cpf") String cpf) {
		return clienteService.getClienteByCpf(cpf);
	}

	@GetMapping(value = "/buscar")
	public List<Cliente> getClienteByNome(@RequestParam(value = "nome") String nome) {
		return clienteService.getClienteByNome(nome);
	}

	@PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> addCliente(@RequestBody Cliente cliente) {
		Cliente auxCliente = clienteService.getClienteByCpf(cliente.getCpf());
		if(auxCliente==null) {
			Cliente clienteFinal = clienteService.salvarCliente(cliente);
			return ResponseEntity.ok("Cliente Salvo\n"+clienteFinal);
		}else {
			return ResponseEntity.status(HttpStatus.FOUND).body("Cliente já cadastrado com esse CPF\n" + auxCliente);
		}
	}

	@DeleteMapping(value = "/delete")
	public ResponseEntity<String> deleteCliente(@RequestParam(value = "cpf") String cpf) {
		Cliente cliente = clienteService.getClienteByCpf(cpf);
		if (cliente == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não localizado!");
		} else {
			clienteService.deleteClienteByCpf(cpf);
			return ResponseEntity.ok("Cliente Deletado");
		}
	}

	@PutMapping(value = "/atualizar")
	public ResponseEntity<String> atualizarNomeCliente(@RequestParam(value = "cpf") String cpf,
			@RequestParam(value = "nome") String nome) {
		Cliente cliente = clienteService.getClienteByCpf(cpf);
		if(cliente==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não Localizado");
		}else {
			clienteService.atualizarNome(cliente.getId(), nome);
			return ResponseEntity.ok("Cliente Atualizado");
		}
	}
}
