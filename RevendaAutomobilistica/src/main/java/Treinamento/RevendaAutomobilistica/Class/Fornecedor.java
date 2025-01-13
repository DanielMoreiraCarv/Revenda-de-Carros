package Treinamento.RevendaAutomobilistica.Class;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "for_fornecedor")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Fornecedor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pk_for_idfornecedor", nullable = false)
	private Long id;

	@Column(name = "for_nom_nome", nullable = false)
	private String nome;

	@Column(name = "for_cod_identificador", nullable = false)
	private String identificador;

	@Column(name = "for_num_numerotelefone", nullable = false)
	private String numTelefone;

	@Column(name = "for_nom_email", nullable = false)
	private String email;

	@Column(name = "for_cod_contabancaria", nullable = false)
	private String codConta;

	@Column(name = "for_nom_agenciabancaria", nullable = false)
	private String agencia;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public String getNumTelefone() {
		return numTelefone;
	}

	public void setNumTelefone(String numTelefone) {
		this.numTelefone = numTelefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCodConta() {
		return codConta;
	}

	public void setCodConta(String codConta) {
		this.codConta = codConta;
	}

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	@Override
	public String toString() {
		return "Fornecedor: \n-Id: " + id + "\n-Nome: " + nome + "\n-Identificador: " + identificador + "\n-Telefone: "
				+ numTelefone + "\n-Email: " + email + "\n-Cod Conta: " + codConta + "\n-Agência: " + agencia;
	}

}
