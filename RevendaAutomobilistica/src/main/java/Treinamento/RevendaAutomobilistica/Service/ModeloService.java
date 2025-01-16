package Treinamento.RevendaAutomobilistica.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Treinamento.RevendaAutomobilistica.Class.Marca;
import Treinamento.RevendaAutomobilistica.Class.Modelo;
import Treinamento.RevendaAutomobilistica.Repository.ModeloRepository;

@Service
public class ModeloService {
	@Autowired
	private ModeloRepository modeloRepository;

	public List<Modelo> getModeloAll() {
		return modeloRepository.findAll();
	}

	public Modelo saveModelo(Modelo modelo) {
		return modeloRepository.save(modelo);
	}

	public boolean verificarModelo(Modelo verificador, String nomeModelo, String tipoVeiculo) {
		if (nomeModelo.equals(verificador.getNomeModelo()) && verificador.getTipoVeiculo().equals(verificador.getTipoVeiculo())) {
			return true;
		}
		return false;
	}

	public void deleteModelo(Modelo modelo) {
		modeloRepository.delete(modelo);
	}

	public Modelo getModelo(String nomeModelo, String tipoVeiculo, Marca marca) {
		List<Modelo> modelos = modeloRepository.findModeloByMarca(marca);
		for (int i = 0; i < modelos.size(); i++) {
			if (verificarModelo(modelos.get(i), nomeModelo, tipoVeiculo)) {
				return modelos.get(i);
			}
		}
		return null;

	}
}
