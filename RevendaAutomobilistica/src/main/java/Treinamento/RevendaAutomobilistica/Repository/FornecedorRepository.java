package Treinamento.RevendaAutomobilistica.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import Treinamento.RevendaAutomobilistica.Class.Fornecedor;
import jakarta.transaction.Transactional;

@Repository
public interface FornecedorRepository extends JpaRepository<Fornecedor, Long> {

	@Modifying
	@Transactional
	@Query("UPDATE Fornecedor f SET f.nome = :nome WHERE f.id = :id")
	void atualizarNome(@Param("id") Long id, @Param("nome") String nome);

	@Modifying
	@Transactional
	@Query("SELECT f FROM  Fornecedor f WHERE f.nome LIKE %:nome%")
	List<Fornecedor> findFornecedorByNome(@Param("nome") String nome);

	Fornecedor findFornecedorByIdentificador(String identificador);
}
