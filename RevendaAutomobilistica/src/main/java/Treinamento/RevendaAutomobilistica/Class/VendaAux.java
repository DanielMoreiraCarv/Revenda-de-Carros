package Treinamento.RevendaAutomobilistica.Class;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class VendaAux {
	private String cpfFuncionario;

	private String placa;

	private String cpfCliente;

	private double vlrVenda;

	private double pcoComissao;

	private String statusVeiculo;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dataVenda;

	private String tipoCompra;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dataEntrega;

	public String getCpfFuncionario() {
		return cpfFuncionario;
	}

	public void setCpfFuncionario(String cpfFuncionario) {
		this.cpfFuncionario = cpfFuncionario;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getCpfCliente() {
		return cpfCliente;
	}

	public void setCpfCliente(String cpfCliente) {
		this.cpfCliente = cpfCliente;
	}

	public double getVlrVenda() {
		return vlrVenda;
	}

	public void setVlrVenda(double vlrVenda) {
		this.vlrVenda = vlrVenda;
	}

	public double getPcoComissao() {
		return pcoComissao;
	}

	public void setPcoComissao(double pcoComissao) {
		this.pcoComissao = pcoComissao;
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

	public void setDataVenda(Date dataVenda) {
		this.dataVenda = dataVenda;
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

	public void setDataEntrega(Date dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public VendaAux(String cpfFuncionario, String placa, String cpfCliente, double vlrVenda, double pcoComissao,
			String statusVeiculo, Date dataVenda, String tipoCompra, Date dataEntrega) {
		super();
		this.cpfFuncionario = cpfFuncionario;
		this.placa = placa;
		this.cpfCliente = cpfCliente;
		this.vlrVenda = vlrVenda;
		this.pcoComissao = pcoComissao;
		this.statusVeiculo = statusVeiculo;
		this.dataVenda = dataVenda;
		this.tipoCompra = tipoCompra;
		this.dataEntrega = dataEntrega;
	}

	public VendaAux() {
		super();
	}
	
	
	
	

}
