package Treinamento.RevendaAutomobilistica.Class;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ven_venda")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Venda {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pk_ven_idvenda", nullable = false)
	private Long id;

	@Column(name = "fk_fun_idfuncionario_ven", nullable = false)
	private Long idFuncionario;

	@Column(name = "fk_vei_idveiculo_ven", nullable = false)
	private Long idVeiculo;

	@Column(name = "fk_cli_idcliente_ven", nullable = false)
	private Long idCliente;

	@Column(name = "ven_vlr_venda", nullable = false)
	private double vlrVenda;

	@Column(name = "ven_pco_comissao", nullable = false)
	private double percentualComissao;

	@Column(name = "ven_dsc_statusveiculo", nullable = false)
	private String statusVeiculo;

	@Column(name = "ven_dat_datavenda", nullable = false)
	private Date dataVenda;

	@Column(name = "ven_dsc_tipocompra", nullable = false)
	private String tipoCompra;

	@Column(name = "ven_dat_dataentrega")
	private Date dataEntrega;

	public Long getIdFuncionario() {
		return idFuncionario;
	}

	public void setIdFuncionario(Long idFuncionario) {
		this.idFuncionario = idFuncionario;
	}

	public Long getIdVeiculo() {
		return idVeiculo;
	}

	public void setIdVeiculo(Long idVeiculo) {
		this.idVeiculo = idVeiculo;
	}

	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

	public double getVlrVenda() {
		return vlrVenda;
	}

	public void setVlrVenda(double vlrVenda) {
		this.vlrVenda = vlrVenda;
	}

	public double getPercentualComissao() {
		return percentualComissao;
	}

	public void setPercentualComissao(double percentualComissao) {
		this.percentualComissao = percentualComissao;
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

	public Long getId() {
		return id;
	}

	public Venda(Long id, Long idFuncionario, Long idVeiculo, Long idCliente, double vlrVenda,
			double percentualComissao, String statusVeiculo, Date dataVenda, String tipoCompra, Date dataEntrega) {
		super();
		this.id = id;
		this.idFuncionario = idFuncionario;
		this.idVeiculo = idVeiculo;
		this.idCliente = idCliente;
		this.vlrVenda = vlrVenda;
		this.percentualComissao = percentualComissao;
		this.statusVeiculo = statusVeiculo;
		this.dataVenda = dataVenda;
		this.tipoCompra = tipoCompra;
		this.dataEntrega = dataEntrega;
	}

	public Venda(Long idFuncionario, Long idVeiculo, Long idCliente, double vlrVenda, double percentualComissao,
			String statusVeiculo, Date dataVenda, String tipoCompra, Date dataEntrega) {
		super();
		this.idFuncionario = idFuncionario;
		this.idVeiculo = idVeiculo;
		this.idCliente = idCliente;
		this.vlrVenda = vlrVenda;
		this.percentualComissao = percentualComissao;
		this.statusVeiculo = statusVeiculo;
		this.dataVenda = dataVenda;
		this.tipoCompra = tipoCompra;
		this.dataEntrega = dataEntrega;
	}

	@Override
	public String toString() {
		return "Venda: " + id + "\n-Funcionario: " + idFuncionario + "\n-Veiculo: " + idVeiculo + "\n-Cliente: "
				+ idCliente + "\n-Valor da Venda: " + vlrVenda + "\n-Percentual da Comissão: " + percentualComissao
				+ "\n-Status do Veículo: " + statusVeiculo + "\n-Data da Venda: " + dataVenda + "\n-Tipo de Compra: "
				+ tipoCompra + "\n-Data da Entrega :" + dataEntrega;
	}

}
