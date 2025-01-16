package Treinamento.RevendaAutomobilistica.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Treinamento.RevendaAutomobilistica.Class.Funcionario;
import Treinamento.RevendaAutomobilistica.Class.Veiculo;
import Treinamento.RevendaAutomobilistica.Class.Venda;

@Repository
public interface VendaRepository extends JpaRepository<Venda, Long> {
	List<Venda> findVendaByFuncionario(Funcionario funcionario);
	
	Venda findVendaByVeiculo(Veiculo veiculo);
}
