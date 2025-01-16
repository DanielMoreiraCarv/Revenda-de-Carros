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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Treinamento.RevendaAutomobilistica.Class.Cliente;
import Treinamento.RevendaAutomobilistica.Class.Funcionario;
import Treinamento.RevendaAutomobilistica.Class.Veiculo;
import Treinamento.RevendaAutomobilistica.Class.Venda;
import Treinamento.RevendaAutomobilistica.Class.VendaAux;
import Treinamento.RevendaAutomobilistica.Service.ClienteService;
import Treinamento.RevendaAutomobilistica.Service.FuncionarioService;
import Treinamento.RevendaAutomobilistica.Service.VeiculoService;
import Treinamento.RevendaAutomobilistica.Service.VendaService;

@RestController
@RequestMapping("/venda")
public class VendaController {
	@Autowired
	private VendaService vendaService;
	@Autowired
	private FuncionarioService funcionarioService;
	@Autowired
	private VeiculoService veiculoService;
	@Autowired
	private ClienteService clienteService;

	@GetMapping()
	public List<Venda> getVendaAll() {
		return vendaService.getVendaAll();
	}

	@GetMapping("/buscar/{identificador}")
	public List<Venda> getVendaByFuncionario(@PathVariable(value = "identificador") String identificador) {
		Funcionario funcionario = funcionarioService.getByCpf(identificador);
		return vendaService.getVendaByFuncionario(funcionario);
	}

	@GetMapping("/buscar")
	public Venda getVendaByVeiculo(@RequestParam(value = "placa") String placa) {
		Veiculo veiculo = veiculoService.getVeiculoByPlaca(placa);
		return vendaService.getVendaByVeiculo(veiculo);
	}

	@PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> addVenda(@RequestBody VendaAux vendaAux) {
		Funcionario funcionario = funcionarioService.getByCpf(vendaAux.getCpfFuncionario());
		if (funcionario == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Funcionário inexistente");
		} else {
			Cliente cliente = clienteService.getClienteByCpf(vendaAux.getCpfCliente());
			if (cliente == null) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente inexistente");
			} else {
				Veiculo veiculo = veiculoService.getVeiculoByPlaca(vendaAux.getPlaca());
				if (veiculo == null) {
					return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Veiculo inexistente");
				} else {
					Venda verificador = vendaService.getVendaByVeiculo(veiculo);
					if (verificador == null) {
						Venda venda = new Venda(funcionario, veiculo, cliente, vendaAux.getVlrVenda(),
								vendaAux.getPcoComissao(), vendaAux.getStatusVeiculo(), vendaAux.getDataVenda(),
								vendaAux.getTipoCompra(), vendaAux.getDataEntrega());
						Venda vendaFinal = vendaService.saveVenda(venda);
						return ResponseEntity.ok("Venda Cadastrada\n" + vendaFinal);
					} else {
						return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Venda com esse veículo já existente");
					}
				}
			}
		}
	}

	@DeleteMapping("/deletar/{placa}")
	public ResponseEntity<String> deleteVenda(@PathVariable(value = "placa") String placa) {
		Veiculo veiculo = veiculoService.getVeiculoByPlaca(placa);
		Venda venda = vendaService.getVendaByVeiculo(veiculo);
		if(venda==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Venda inexistente");
		}else {
			vendaService.deleteVenda(venda);
			return ResponseEntity.ok("Venda deletada");
		}
	}

}
