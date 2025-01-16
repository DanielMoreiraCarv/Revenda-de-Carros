package Treinamento.RevendaAutomobilistica.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Treinamento.RevendaAutomobilistica.Class.Marca;
import Treinamento.RevendaAutomobilistica.Repository.MarcaRepository;

@Service
public class MarcaService {
	@Autowired
	private MarcaRepository marcaRepository;

	public void salvarMarca(Marca marca) {
		marcaRepository.save(marca);
	}

	public void deleteMarca(Marca marca) {
		marcaRepository.delete(marca);
	}

	public List<Marca> getMarcaAll() {
		return marcaRepository.findAll();
	}

	public Marca getMarca(String nome) {
		return marcaRepository.findMarcaByNome(nome);
	}

	public List<Marca> getMarcaLike(String nome) {
		return marcaRepository.findMarcaLikeNome(nome);
	}
	
	public void atualizarNome(Long id, String nome) {
		marcaRepository.atualizarNome(id, nome);
	}
}
