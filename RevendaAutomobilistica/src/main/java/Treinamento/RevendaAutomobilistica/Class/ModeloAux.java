package Treinamento.RevendaAutomobilistica.Class;

public class ModeloAux {
	private String nomeMarca;
	private String tipoVeiculo;
	private String nomeModelo;
	public String getNomeMarca() {
		return nomeMarca;
	}
	public void setNomeMarca(String nomeMarca) {
		this.nomeMarca = nomeMarca;
	}
	public String getTipoVeiculo() {
		return tipoVeiculo;
	}
	public void setTipoVeiculo(String tipoVeiculo) {
		this.tipoVeiculo = tipoVeiculo;
	}
	public String getNomeModelo() {
		return nomeModelo;
	}
	public void setNomeModelo(String nomeModelo) {
		this.nomeModelo = nomeModelo;
	}
	public ModeloAux(String nomeMarca, String tipoVeiculo, String nomeModelo) {
		super();
		this.nomeMarca = nomeMarca;
		this.tipoVeiculo = tipoVeiculo;
		this.nomeModelo = nomeModelo;
	}
	public ModeloAux() {
		super();
	}
	
	
}
