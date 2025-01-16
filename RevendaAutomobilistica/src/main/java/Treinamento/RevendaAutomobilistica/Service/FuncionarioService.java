package Treinamento.RevendaAutomobilistica.Service;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Treinamento.RevendaAutomobilistica.Class.Funcionario;
import Treinamento.RevendaAutomobilistica.Repository.FuncionarioRepository;
import jakarta.transaction.Transactional;

@Service
public class FuncionarioService {

	@Autowired
	private FuncionarioRepository FuncionarioRepository;

	public boolean salvarProduto(Funcionario produto) {
		LocalDate dataHoje = LocalDate.now();
		LocalDate dataFunc = produto.getDataNasc().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		Period periodo = dataFunc.until(dataHoje);
		if(periodo.getYears()<18) {
			return false;
		}
		FuncionarioRepository.save(produto);
		return true;
	}
	public Funcionario getById(Funcionario funcionario) {
		return FuncionarioRepository.findById(funcionario.getId()).orElse(null);
	}
	public void atualizarDataNasc(Funcionario funcionario, Date data) {
		FuncionarioRepository.atualizarDataNascimento(funcionario.getId(),data);
	}

	public List<Funcionario> listarProdutos() {
		return FuncionarioRepository.findAll();
	}

	public List<Funcionario> getByNome(String nome) {
		return FuncionarioRepository.findProdutoByNome(nome);
	}

	public Funcionario getByCpf(String cpf) {
		return FuncionarioRepository.findFuncionarioByCpf(cpf);
	}

	public void deleteById(Long Id) {
		FuncionarioRepository.deleteById(Id);
	}

	@Transactional
	public void atualizarNome(Funcionario produto, String nome) {
		FuncionarioRepository.atualizarNome(produto.getId(), nome);
	}

	
}
