package Treinamento.RevendaAutomobilistica.Class;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "mar_marca")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Marca {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pk_mar_idmarca")
	private Long id;
	
	@Column(name = "mar_nom_nome")
	private String nome;
	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}

	public Marca(String nome) {
		super();
		this.nome = nome;
	}
	

	public Marca(Long id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}

	public Marca() {
		super();
	}

	@Override
	public String toString() {
		return "Marca: " + id + "\n-Nome: " + nome;
	}
	
	
}
