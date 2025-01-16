package Treinamento.RevendaAutomobilistica.Class;

public class VeiculoAux {
	private String identificadorFornecedor;
	private String nomeMarca;
	private String tipoVeiculo;
	private String nomeModelo;
	private double valorFornecedor;
	private double valorTabelaFip;
	private String placa;
	private String cor;
	private int ano;
	private Double quilometragem;

	public String getIdentificadorFornecedor() {
		return identificadorFornecedor;
	}

	public void setIdentificadorFornecedor(String identificadorFornecedor) {
		this.identificadorFornecedor = identificadorFornecedor;
	}

	

	public double getValorFornecedor() {
		return valorFornecedor;
	}

	public void setValorFornecedor(double valorFornecedor) {
		this.valorFornecedor = valorFornecedor;
	}

	public double getValorTabelaFip() {
		return valorTabelaFip;
	}

	public void setValorTabelaFip(double valorTabelaFip) {
		this.valorTabelaFip = valorTabelaFip;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public Double getQuilometragem() {
		return quilometragem;
	}

	public void setQuilometragem(Double quilometragem) {
		this.quilometragem = quilometragem;
	}

	public VeiculoAux() {
		super();
	}

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

	public VeiculoAux(String identificadorFornecedor, String nomeMarca, String tipoVeiculo, String nomeModelo,
			double valorFornecedor, double valorTabelaFip, String placa, String cor, int ano, Double quilometragem) {
		super();
		this.identificadorFornecedor = identificadorFornecedor;
		this.nomeMarca = nomeMarca;
		this.tipoVeiculo = tipoVeiculo;
		this.nomeModelo = nomeModelo;
		this.valorFornecedor = valorFornecedor;
		this.valorTabelaFip = valorTabelaFip;
		this.placa = placa;
		this.cor = cor;
		this.ano = ano;
		this.quilometragem = quilometragem;
	}

	

}
