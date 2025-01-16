package Treinamento.RevendaAutomobilistica.Class;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
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
@Table(name = "ven_venda")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Venda {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pk_ven_idvenda", nullable = false)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_fun_idfuncionario_ven", referencedColumnName = "pk_fun_idfuncionario", nullable = false)
	private Funcionario funcionario;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_vei_idveiculo_ven", referencedColumnName = "pk_vei_idveiculo", nullable = false)
	private Veiculo veiculo;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_cli_idcliente_ven", referencedColumnName = "pk_cli_idcliente", nullable = false)
	private Cliente cliente;

	@Column(name = "ven_vlr_venda", nullable = false)
	private double valorVenda;

	@Column(name = "ven_pco_comissao")
	private double comissao;

	@Column(name = "ven_dsc_statusveiculo", nullable = false)
	private String statusVeiculo;

	@Column(name = "ven_dat_datavenda", nullable = false)
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dataVenda;

	@Column(name = "ven_dsc_tipocompra", nullable = false)
	private String tipoCompra;

	@Column(name = "ven_dat_dataentrega")
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dataEntrega;

	public Long getId() {
		return id;
	}

	public String getFuncionario() {
		return funcionario.getNome();
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public String getVeiculo() {
		return veiculo.getPlaca();
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public String getCliente() {
		return cliente.getNome();
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public double getValorVenda() {
		return valorVenda;
	}

	public void setValorVenda(double valorVenda) {
		this.valorVenda = valorVenda;
	}

	public double getComissao() {
		return comissao;
	}

	public void setComissao(double comissao) {
		this.comissao = comissao;
	}

	public String getStatusVeiculo() {
		return statusVeiculo;
	}

	public void setStatusVeiculo(String statusVeiculo) {
		this.statusVeiculo = statusVeiculo;
	}

	public Date getDataVenda() {
		return dataVenda;
	}
	

	public void setDataVenda(String dataVendaString) {
		SimpleDateFormat formatoString = new SimpleDateFormat("dd/MM/yyyy");
		try {
			this.dataVenda = formatoString.parse(dataVendaString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	public String getTipoCompra() {
		return tipoCompra;
	}

	public void setTipoCompra(String tipoCompra) {
		this.tipoCompra = tipoCompra;
	}

	public Date getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(String dataEntregaString) {
		SimpleDateFormat formatoString = new SimpleDateFormat("dd/MM/yyyy");
		try {
			this.dataEntrega = formatoString.parse(dataEntregaString);
		} catch (ParseException e) {
			e.printStackTrace();
		}

	}

	public Venda(Funcionario funcionario, Veiculo veiculo, Cliente cliente, double valorVenda, double comissao,
			String statusVeiculo, Date dataVenda, String tipoCompra) {
		super();
		this.funcionario = funcionario;
		this.veiculo = veiculo;
		this.cliente = cliente;
		this.valorVenda = valorVenda;
		this.comissao = comissao;
		this.statusVeiculo = statusVeiculo;
		this.dataVenda = dataVenda;
		this.tipoCompra = tipoCompra;
	}

	public Venda(Funcionario funcionario, Veiculo veiculo, Cliente cliente, double valorVenda, double comissao,
			String statusVeiculo, Date dataVenda, String tipoCompra, Date dataEntrega) {
		super();
		this.funcionario = funcionario;
		this.veiculo = veiculo;
		this.cliente = cliente;
		this.valorVenda = valorVenda;
		this.comissao = comissao;
		this.statusVeiculo = statusVeiculo;
		this.dataVenda = dataVenda;
		this.tipoCompra = tipoCompra;
		this.dataEntrega = dataEntrega;
	}

	public Venda() {
		super();
	}

	@Override
	public String toString() {
		return "Venda: " + id + "\n-Funcionario: " + funcionario.getNome() + "\n-Placa: " + veiculo.getPlaca() + "\n-Cliente: " + cliente.getNome()
				+ "\n-Valor da Venda: R$" + valorVenda + "\n-Comissão: " + comissao+"%"+ "\n-Status do Veículo: " + statusVeiculo
				+ "\n-Data da Venda" + dataVenda + "\n-Tipo de Compra" + tipoCompra + "\n-Data da Entrega" + dataEntrega;
	}

}
