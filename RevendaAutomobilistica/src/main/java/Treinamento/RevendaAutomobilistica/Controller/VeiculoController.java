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

import Treinamento.RevendaAutomobilistica.Class.Fornecedor;
import Treinamento.RevendaAutomobilistica.Class.Marca;
import Treinamento.RevendaAutomobilistica.Class.Modelo;
import Treinamento.RevendaAutomobilistica.Class.Veiculo;
import Treinamento.RevendaAutomobilistica.Class.VeiculoAux;
import Treinamento.RevendaAutomobilistica.Service.FornecedorService;
import Treinamento.RevendaAutomobilistica.Service.MarcaService;
import Treinamento.RevendaAutomobilistica.Service.ModeloService;
import Treinamento.RevendaAutomobilistica.Service.VeiculoService;

@RestController
@RequestMapping("/veiculo")
public class VeiculoController {
	@Autowired
	private VeiculoService veiculoService;
	@Autowired
	private FornecedorService fornecedorService;
	@Autowired
	private ModeloService modeloService;
	@Autowired
	private MarcaService marcaService;

	@GetMapping()
	public List<Veiculo> getVeiculoAll() {
		return veiculoService.getVeiculoAll();
	}

	@GetMapping(value = "/buscar/{cpf}")
	public List<Veiculo> getVeiculoByFornecedor(@PathVariable(value = "cpf") String cpf) {
		Fornecedor fornecedor = fornecedorService.getByIdentificador(cpf);
		if (fornecedor == null) {
			return null;
		} else {
			return veiculoService.getVeiculoByFornecedor(fornecedor);
		}
	}

	@GetMapping(value = "/buscar")
	public Veiculo getVeiculoByPlaca(@RequestParam(value = "placa") String placa) {
		return veiculoService.getVeiculoByPlaca(placa);
	}

	@PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> addVeiculo(@RequestBody VeiculoAux veiculoAux) {
		Marca marca = marcaService.getMarca(veiculoAux.getNomeMarca());
		if (marca == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Marca não existente");
		} else {
			Modelo modelo = modeloService.getModelo(veiculoAux.getNomeModelo(),
					veiculoAux.getTipoVeiculo(), marca);
			if (modelo == null) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Modelo não existente");
			} else {
				Fornecedor fornecedor = fornecedorService.getByIdentificador(veiculoAux.getIdentificadorFornecedor());
				if (fornecedor == null) {
					return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Fornecedor não existente");
				} else {
					boolean verificadorPlaca = veiculoService.verificadorPlaca(veiculoAux.getPlaca());
					if(verificadorPlaca) {
						Veiculo veiculo = new Veiculo(fornecedor, modelo, veiculoAux.getValorFornecedor(),
								veiculoAux.getValorTabelaFip(), veiculoAux.getPlaca(), veiculoAux.getCor(),
								veiculoAux.getAno(), veiculoAux.getQuilometragem());
						Veiculo verificador = veiculoService.getVeiculoByPlaca(veiculo.getPlaca());
						if(verificador==null) {
							return ResponseEntity.ok("Veiculo Cadastrado\n"+veiculoService.saveVeiculo(veiculo));
						}else {
							return ResponseEntity.status(HttpStatus.FOUND).body("Veiculo já existente com essa placa");
						}
					}else {
						return ResponseEntity.status(HttpStatus.FOUND).body("Placa não condiz com o padrão");
					}
				}
			}
		}
	}
	
	@DeleteMapping(value = "/delete/{placa}")
	public ResponseEntity<String> deleteVeiculo(@PathVariable(value = "placa")String placa){
		Veiculo veiculo = veiculoService.getVeiculoByPlaca(placa);
		if(veiculo==null) {
			return ResponseEntity.status(HttpStatus.FOUND).body("Veiculo não localizado");
		}else {
			veiculoService.deleteVeiculo(veiculo);
			return ResponseEntity.ok("Veiculo Deletado");
		}
		
	}

}
