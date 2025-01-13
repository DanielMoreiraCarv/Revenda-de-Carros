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
public class Estoque {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pk_est_idestoque", nullable = false)
	private Long id;

	@Column(name = "est_dsc_endereco", nullable = false)
	private String endereco;

	@Column(name = "est_num_numeroEndereco", nullable = false)
	private int numEndereco;

	@Column(name = "est_cod_filial")
	private int filial;

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public int getNumEndereco() {
		return numEndereco;
	}

	public void setNumEndereco(int numEndereco) {
		this.numEndereco = numEndereco;
	}

	public int getFilial() {
		return filial;
	}

	public void setFilial(int filial) {
		this.filial = filial;
	}

	public Long getId() {
		return id;
	}

	public Estoque(String endereco, int numEndereco, int filial) {
		super();
		this.endereco = endereco;
		this.numEndereco = numEndereco;
		this.filial = filial;
	}

	public Estoque(String endereco, int numEndereco) {
		super();
		this.endereco = endereco;
		this.numEndereco = numEndereco;
	}

	@Override
	public String toString() {
		return "Estoque: " + id + "\n-Endereço: " + endereco + "\n-Número: " + numEndereco + "\n-Filial: " + filial;
	}

}
