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
@Table(name = "mod_modelo")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Modelo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pk_mod_idmodelo", nullable = false)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_mar_idmarca_mod", referencedColumnName = "pk_mar_idmarca",nullable = false)
	private Marca marca;

	@Column(name = "mod_tip_tipoveiculo", nullable = false)
	private String tipoVeiculo;

	@Column(name = "mod_nom_nomemodelo", nullable = false)
	private String nomeModelo;

	public Long getIdMarca() {
		return marca.getId();
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
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

	public Long getId() {
		return id;
	}

	public Modelo(Long id, Marca marca, String tipoVeiculo, String nomeModelo) {
		super();
		this.id = id;
		this.marca = marca;
		this.tipoVeiculo = tipoVeiculo;
		this.nomeModelo = nomeModelo;
	}

	public Modelo(Marca marca, String tipoVeiculo, String nomeModelo) {
		super();
		this.marca = marca;
		this.tipoVeiculo = tipoVeiculo;
		this.nomeModelo = nomeModelo;
	}
	

	public Modelo(String tipoVeiculo, String nomeModelo) {
		super();
		this.tipoVeiculo = tipoVeiculo;
		this.nomeModelo = nomeModelo;
	}
	

	public Modelo() {
		super();
	}

	@Override
	public String toString() {
		return "Modelo: " + id + "\n-Marca Pertencente: " + marca + "\n-Tipo de Veículo: " + tipoVeiculo
				+ "\n-Modelo: " + nomeModelo;
	}

}
