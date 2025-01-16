package Treinamento.RevendaAutomobilistica.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Treinamento.RevendaAutomobilistica.Class.Funcionario;
import Treinamento.RevendaAutomobilistica.Class.Veiculo;
import Treinamento.RevendaAutomobilistica.Class.Venda;
import Treinamento.RevendaAutomobilistica.Repository.VendaRepository;

@Service
public class VendaService {
	@Autowired
	private VendaRepository vendaRepository;
	
	public List<Venda> getVendaAll(){
		return vendaRepository.findAll();
	}
	
	
	public List<Venda> getVendaByFuncionario(Funcionario funcionario){
		return vendaRepository.findVendaByFuncionario(funcionario);
	}
	
	public Venda getVendaByVeiculo(Veiculo veiculo) {
		return vendaRepository.findVendaByVeiculo(veiculo);
	}
	
	public Venda saveVenda(Venda venda) {
		return vendaRepository.save(venda);
	}
	
	public void deleteVenda(Venda venda) {
		vendaRepository.delete(venda);
	}
}
