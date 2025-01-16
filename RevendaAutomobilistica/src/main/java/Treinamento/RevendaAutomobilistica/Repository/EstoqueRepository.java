package Treinamento.RevendaAutomobilistica.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import Treinamento.RevendaAutomobilistica.Class.Estoque;
import jakarta.transaction.Transactional;

@Repository
public interface EstoqueRepository extends JpaRepository<Estoque, Long> {
	List<Estoque> findEstoqueByEndereco(String endereco);
	
	@Modifying
	@Transactional
	@Query("SELECT e FROM Estoque e WHERE e.endereco=:endereco AND e.numEndereco=:numEndereco")
	Estoque findEstoqueByEndereco(String endereco,int numEndereco);

}
