package Treinamento.RevendaAutomobilistica.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import Treinamento.RevendaAutomobilistica.Class.Marca;
import Treinamento.RevendaAutomobilistica.Class.Modelo;

public interface ModeloRepository extends JpaRepository<Modelo, Long> {
	List<Modelo> findModeloByMarca(Marca marca);
}
