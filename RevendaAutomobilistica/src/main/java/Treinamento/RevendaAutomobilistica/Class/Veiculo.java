package Treinamento.RevendaAutomobilistica.Class;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "vei_veiculo")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Veiculo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pk_vei_idveiculo")
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_for_idfornecedor_vei", referencedColumnName = "pk_for_idfornecedor", nullable = false)
	private Fornecedor fornecedor;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_mod_idmodelo_vei", referencedColumnName = "pk_mod_idmodelo", nullable = false)
	private Modelo modelo;

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

	@Column(name = "vei_vlr_quilometragem")
	private Double quilometragem;

	public Veiculo(Fornecedor fornecedor, Modelo modelo, double valorFornecedor, double valorTabelaFip, String placa,
			String cor, int anoFabricacao, Double quilometragem) {
		super();
		this.fornecedor = fornecedor;
		this.modelo = modelo;
		this.valorFornecedor = valorFornecedor;
		this.valorTabelaFip = valorTabelaFip;
		this.placa = placa;
		this.cor = cor;
		this.anoFabricacao = anoFabricacao;
		this.quilometragem = quilometragem;
	}

	public Veiculo() {
		super();
	}

	public String getFornecedor() {
		return fornecedor.getNome();
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public String getModelo() {
		return modelo.getNomeModelo();
	}

	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
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

	public Double getQuilometragem() {
		return quilometragem;
	}

	public void setQuilometragem(Double quilometragem) {
		this.quilometragem = quilometragem;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Veiculo: " + id + "\n-Fornecedor: " + fornecedor + "\n-Modelo: " + modelo + "\n-Valor do Fornecedor: "
				+ valorFornecedor + "\n-Valor Tabela FIP: " + valorTabelaFip + "\n-Placa" + placa + "\n-Cor: " + cor
				+ "\n-Ano: " + anoFabricacao + "\n-Km: " + quilometragem;
	}
	
	
	
	
}
