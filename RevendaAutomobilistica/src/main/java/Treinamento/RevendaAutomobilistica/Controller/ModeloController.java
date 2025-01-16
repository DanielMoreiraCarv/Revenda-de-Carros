package Treinamento.RevendaAutomobilistica.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Treinamento.RevendaAutomobilistica.Class.Marca;
import Treinamento.RevendaAutomobilistica.Class.Modelo;
import Treinamento.RevendaAutomobilistica.Class.ModeloAux;
import Treinamento.RevendaAutomobilistica.Service.MarcaService;
import Treinamento.RevendaAutomobilistica.Service.ModeloService;

@RestController
@RequestMapping("/modelo")
public class ModeloController {
	@Autowired
	private ModeloService modeloService;
	
	@Autowired 
	private MarcaService marcaService;
	
	@GetMapping()
	public List<Modelo> getModeloAll(){
		return modeloService.getModeloAll();
	}
	
	@PostMapping(value = "/add",consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> saveModelo(@RequestBody ModeloAux modeloAux) {
		Marca marca = marcaService.getMarca(modeloAux.getNomeMarca());
		if(marca==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Marca não localizada");
		}else {
			Modelo modelo = new Modelo(marca,modeloAux.getTipoVeiculo(),modeloAux.getNomeModelo());
			return ResponseEntity.ok("Criação de modelo confirmada!\n"+modeloService.saveModelo(modelo));
		}
	}
	
	@DeleteMapping(value = "/delete",consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> deleteModelo(@RequestBody ModeloAux modeloAux){
		Marca marca = marcaService.getMarca(modeloAux.getNomeMarca());
		if(marca==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Marca não localizada");
		}else {
			Modelo modelo = modeloService.getModelo(modeloAux.getNomeModelo(),modeloAux.getTipoVeiculo(),marca);
			if(modelo==null) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Modelo não localizado");
			}
			modeloService.deleteModelo(modelo);
			return ResponseEntity.ok("Modelo Deletado");
		}
	}
	
}
