package Treinamento.RevendaAutomobilistica.Class;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "fun_funcionario")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Funcionario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pk_fun_idfuncionario", nullable = false)
	private Long id;

	@Column(name = "fun_nom_nome", nullable = false, length = 100)
	private String nome;

	@Column(name = "fun_cod_cpf", nullable = false)
	private String cpf;

	@Column(name = "fun_nom_email", nullable = false)
	private String email;

	@Column(name = "fun_dat_datanascimento", nullable = false)
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dataNasc;

	@Column(name = "fun_cod_contabancaria", nullable = false)
	private String cod;

	@Column(name = "fun_nom_agenciabancaria", nullable = false)
	private String agencia;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Date getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
	}

	public String getCod() {
		return cod;
	}

	public void setCod(String cod) {
		this.cod = cod;
	}

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Funcionario(String nome, String cpf, Date dataNasc, String cod, String agencia, String email) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.dataNasc = dataNasc;
		this.cod = cod;
		this.agencia = agencia;
		this.email = email;
	}

	public Funcionario(String nome, String cpf, String dataNascString, String cod, String agencia, String email) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		String[] dataSeparada = dataNascString.split("/");
		String dataAux = dataSeparada[2] + "-" + dataSeparada[1] + "-" + dataSeparada[0];
		LocalDateTime teste = LocalDate.parse(dataAux).atStartOfDay();
		Date data = Date.from(teste.atZone(ZoneId.systemDefault()).toInstant());
		this.dataNasc = data;
		this.cod = cod;
		this.agencia = agencia;
		this.email = email;
	}

	public Funcionario() {
	}

	@Override
	public String toString() {
		SimpleDateFormat out = new SimpleDateFormat("dd/MM/yyyy");
		return "Funcionario: \n-Nome:" + nome + "\n-CPF:" + cpf + "\n-email: " + email + "\n-Data de Nascimento:"
				+ out.format(dataNasc) + "\n-Cod. Conta:" + 
				cod + "\n-Agencia:" + agencia;
	}

		
}
