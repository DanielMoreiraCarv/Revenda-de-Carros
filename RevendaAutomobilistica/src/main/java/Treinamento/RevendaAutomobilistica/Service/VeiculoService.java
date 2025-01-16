package Treinamento.RevendaAutomobilistica.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Treinamento.RevendaAutomobilistica.Class.Fornecedor;
import Treinamento.RevendaAutomobilistica.Class.Veiculo;
import Treinamento.RevendaAutomobilistica.Repository.VeiculoRepository;

@Service
public class VeiculoService {
	@Autowired
	private VeiculoRepository veiculoRepository;
	
	public List<Veiculo> getVeiculoAll() {
		return veiculoRepository.findAll();
	}
	
	public List<Veiculo> getVeiculoByFornecedor(Fornecedor fornecedor){
		return veiculoRepository.findVeiculoByFornecedor(fornecedor.getId());
	}
	
	public Veiculo getVeiculoByPlaca(String placa) {
		return veiculoRepository.findVeiculoByPlaca(placa);
	}
	
	public Veiculo saveVeiculo(Veiculo veiculo) {
		return veiculoRepository.save(veiculo);
	}
	
	public void deleteVeiculo(Veiculo veiculo) {
		veiculoRepository.delete(veiculo);
	}
	
	public boolean verificadorPlaca(String placa) {
		int separador = placa.indexOf("-");
		if(separador==3 && placa.length()==8) {
			return true;
		}
		return false;
	}
}
