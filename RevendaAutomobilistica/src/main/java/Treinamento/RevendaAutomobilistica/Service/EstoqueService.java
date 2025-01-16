package Treinamento.RevendaAutomobilistica.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Treinamento.RevendaAutomobilistica.Class.Estoque;
import Treinamento.RevendaAutomobilistica.Repository.EstoqueRepository;

@Service
public class EstoqueService {
	@Autowired
	private EstoqueRepository estoqueRepository;
	
	public List<Estoque> getEstoqueAll() {
		return estoqueRepository.findAll();
	}
	
	public List<Estoque> getEstoqueByEndereco(String endereco) {
		return estoqueRepository.findEstoqueByEndereco(endereco);
	}
	
	public Estoque getEstoqueByEndereco(String endereco,int numEndereco) {
		return estoqueRepository.findEstoqueByEndereco(endereco, numEndereco);
	}
	public Estoque saveEstoque(Estoque estoque) {
		return estoqueRepository.save(estoque);
	}
	public void deleteEstoque(Estoque estoque) {
		estoqueRepository.delete(estoque);
	}

}
