package Treinamento.RevendaAutomobilistica.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import Treinamento.RevendaAutomobilistica.Class.Marca;
import jakarta.transaction.Transactional;

@Repository
public interface MarcaRepository extends JpaRepository<Marca, Long> {

	@Modifying
	@Transactional
	@Query("UPDATE Marca m SET m.nome = :nome WHERE m.id = :id")
	void atualizarNome(@Param("id") Long id, @Param("nome") String nome);

	@Modifying
	@Transactional
	@Query("SELECT m FROM  Marca m WHERE m.nome LIKE %:nome%")
	List<Marca> findMarcaLikeNome(@Param("nome") String nome);
	
	Marca findMarcaByNome(String nome);
}
