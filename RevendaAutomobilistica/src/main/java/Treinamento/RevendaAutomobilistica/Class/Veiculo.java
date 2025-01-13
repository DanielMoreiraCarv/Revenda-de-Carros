package Treinamento.RevendaAutomobilistica.Class;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "vei_veiculo")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Veiculo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pk_vei_idveiculo", nullable = false)
	private Long id;

	@Column(name = "fk_for_idfornecedor_vei", nullable = false)
	private Long idFornecedor;

	@Column(name = "fk_mod_idmodelo_vei", nullable = false)
	private Long idModelo;

	@Column(name = "vei_vlr_valorfornecedor", nullable = false)
	private double valorFornecedor;

	@Column(name = "vei_vlr_valortabelafipe", nullable = false)
	private double valorTabelaFip;

	@Column(name = "vei_dsc_placa", nullable = false)
	private String placa;

	@Column(name = "vei_dsc_cor", nullable = false)
	private String cor;

	@Column(name = "vei_num_anofabricacao", nullable = false)
	private int anoFabricacao;

	@Column(name = "vei_vlr_quilometragem", nullable = false)
	private double quilometragem;

	public Long getIdFornecedor() {
		return idFornecedor;
	}

	public void setIdFornecedor(Long idFornecedor) {
		this.idFornecedor = idFornecedor;
	}

	public Long getIdModelo() {
		return idModelo;
	}

	public void setIdModelo(Long idModelo) {
		this.idModelo = idModelo;
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

	public int getAnoFabricacao() {
		return anoFabricacao;
	}

	public void setAnoFabricacao(int anoFabricacao) {
		this.anoFabricacao = anoFabricacao;
	}

	public double getQuilometragem() {
		return quilometragem;
	}

	public void setQuilometragem(double quilometragem) {
		this.quilometragem = quilometragem;
	}

	public Long getId() {
		return id;
	}

	public Veiculo(Long idFornecedor, Long idModelo, double valorFornecedor, double valorTabelaFip, String placa,
			String cor, int anoFabricacao, double quilometragem) {
		super();
		this.idFornecedor = idFornecedor;
		this.idModelo = idModelo;
		this.valorFornecedor = valorFornecedor;
		this.valorTabelaFip = valorTabelaFip;
		this.placa = placa;
		this.cor = cor;
		this.anoFabricacao = anoFabricacao;
		this.quilometragem = quilometragem;
	}

	public Veiculo(Long id, Long idFornecedor, Long idModelo, double valorFornecedor, double valorTabelaFip,
			String placa, String cor, int anoFabricacao, double quilometragem) {
		super();
		this.id = id;
		this.idFornecedor = idFornecedor;
		this.idModelo = idModelo;
		this.valorFornecedor = valorFornecedor;
		this.valorTabelaFip = valorTabelaFip;
		this.placa = placa;
		this.cor = cor;
		this.anoFabricacao = anoFabricacao;
		this.quilometragem = quilometragem;
	}

	@Override
	public String toString() {
		return "Veiculo: " + id + "\n-Fornecedor: " + idFornecedor + "\n-Modelo: " + idModelo
				+ "\n-Valor do Fornecedor: " + valorFornecedor + "\n-Valor Tabela FIP: " + valorTabelaFip + "\n-Placa: "
				+ placa + "\n-Cor: " + cor + "\n-Ano: " + anoFabricacao + "\n-Quilometragem: " + quilometragem;
	}

}
