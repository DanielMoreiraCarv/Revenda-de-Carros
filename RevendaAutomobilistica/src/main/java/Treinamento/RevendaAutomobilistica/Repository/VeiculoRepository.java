package Treinamento.RevendaAutomobilistica.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import Treinamento.RevendaAutomobilistica.Class.Veiculo;
import jakarta.transaction.Transactional;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Long>{
	@Modifying
	@Transactional
	@Query("SELECT v FROM Veiculo v WHERE v.fornecedor = :fornecedor")
	List<Veiculo> findVeiculoByFornecedor(Long fornecedor);
	
	Veiculo findVeiculoByPlaca(String placa);

}
