package Treinamento.RevendaAutomobilistica.Class;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cli_cliente")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pk_cli_idcliente", nullable = false)
	private Long id;

	@Column(name = "cli_nom_nome", nullable = false)
	private String nome;

	@Column(name = "cli_cod_cpf", nullable = false)
	private String cpf;

	@Column(name = "cli_num_numerotelefone", nullable = false)
	private String numeroTelefone;

	@Column(name = "cli_nom_email", nullable = false)
	private String email;

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNumeroTelefone() {
		return numeroTelefone;
	}

	public void setNumeroTelefone(String numeroTelefone) {
		this.numeroTelefone = numeroTelefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Cliente: " + id + "\n-Nome: " + nome + "\n-CPF: " + cpf + "\n-Telefone: " + numeroTelefone
				+ "\n-Email: " + email;
	}

}
