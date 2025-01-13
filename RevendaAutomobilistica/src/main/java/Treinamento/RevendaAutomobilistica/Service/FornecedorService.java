package Treinamento.RevendaAutomobilistica.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Treinamento.RevendaAutomobilistica.Class.Fornecedor;
import Treinamento.RevendaAutomobilistica.Repository.FornecedorRepository;
import jakarta.transaction.Transactional;

@Service
public class FornecedorService {
	@Autowired
	private FornecedorRepository fornecedorRepository;
	
	public Fornecedor salvarFornecedor(Fornecedor fornecedor) {
		return fornecedorRepository.save(fornecedor);
	}
	
	public void deleteFornecedor(Fornecedor fornecedor) {
		fornecedorRepository.delete(fornecedor);
	}
	
	public Fornecedor getByIdentificador(String identificador) {
		return fornecedorRepository.findFornecedorByIdentificador(identificador);
	}
	
	public List<Fornecedor> getAll(){
		return fornecedorRepository.findAll();
	}
	
	@Transactional
	public List<Fornecedor> findNameLike(String nome){
		return fornecedorRepository.findFornecedorByNome(nome);
	}
	
	@Transactional
	public void atualizarNome(Fornecedor fornecedor, String nome) {
		fornecedorRepository.atualizarNome(fornecedor.getId(), nome);
	}
	

}
