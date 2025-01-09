package Treinamento.RevendaAutomobilistica.Repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import Treinamento.RevendaAutomobilistica.Class.Funcionario;
import jakarta.transaction.Transactional;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
	List<Funcionario> findProdutoByNome(String nome);

	Funcionario findFuncionarioByCpf(String cpf);

	@Modifying
	@Transactional
	@Query("UPDATE Funcionario f SET f.nome = :nome WHERE f.id = :id")
	void atualizarNome(@Param("id") Long id, @Param("nome") String nome);

	@Modifying
	@Transactional
	@Query("UPDATE Funcionario f SET f.dataNasc = :dataNasc WHERE f.id = :id")
	void atualizarDataNascimento(@Param("id") Long id, @Param("dataNasc") Date dataNasc);

}
