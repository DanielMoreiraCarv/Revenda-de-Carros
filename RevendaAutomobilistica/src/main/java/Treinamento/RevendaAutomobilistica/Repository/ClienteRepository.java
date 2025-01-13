package Treinamento.RevendaAutomobilistica.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import Treinamento.RevendaAutomobilistica.Class.Cliente;
import jakarta.transaction.Transactional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Long> {

	@Modifying
	@Transactional
	@Query("UPDATE Cliente c SET c.nome = :nome WHERE c.id = :id")
	void atualizarNome(@Param("id") Long id, @Param("nome") String nome);

	@Modifying
	@Transactional
	@Query("SELECT c FROM  Cliente c WHERE c.nome LIKE %:nome%")
	List<Cliente> findClienteByNome(@Param("nome") String nome);

	Cliente findClienteByCpf(String cpf);
	
	void deleteClienteByCpf(String cpf);
}
