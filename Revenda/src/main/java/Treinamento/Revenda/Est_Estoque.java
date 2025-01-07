package Treinamento.Revenda;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Est_Estoque {
	private String est_dsc_endereco;
	private int est_num_numeroendereco;
	private int est_cod_filial;

	public Est_Estoque(String est_dsc_endereco, int est_num_numeroendereco, int est_cod_filial) {
		super();
		this.est_dsc_endereco = est_dsc_endereco;
		this.est_num_numeroendereco = est_num_numeroendereco;
		this.est_cod_filial = est_cod_filial;
	}

	public Est_Estoque(String est_dsc_endereco, int est_num_numeroendereco) {
		super();
		this.est_dsc_endereco = est_dsc_endereco;
		this.est_num_numeroendereco = est_num_numeroendereco;
	}

	public String getEst_dsc_endereco() {
		return est_dsc_endereco;
	}

	public void setEst_dsc_endereco(String newEst_dsc_endereco) {
		try (Connection conexao = ConexaoBd.getConexao()) {
			PreparedStatement stmt = null;
			String sql = "UPDATE EST_ESTOQUE SET est_dsc_endereco = ? WHERE est_dsc_endereco = ? AND est_num_numeroendereco = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setString(2, est_dsc_endereco);
			stmt.setInt(3, est_num_numeroendereco);
			stmt.setString(1, newEst_dsc_endereco);
			int linhasAfetadas = stmt.executeUpdate();
			if (linhasAfetadas > 0) {
				System.out.println("Registro atualizado com sucesso!");
			} else {
				System.out.println("Nenhum registro encontrado com a matrícula fornecida.");
			}
		} catch (SQLException e) {
			System.err.println("Erro na atividade desejada: " + e.getMessage());
		}
		est_dsc_endereco = newEst_dsc_endereco;
	}

	public int getEst_num_numeroendereco() {
		return est_num_numeroendereco;
	}

	public void setEst_num_numeroendereco(int newEst_num_numeroendereco) {
		try (Connection conexao = ConexaoBd.getConexao()) {
			PreparedStatement stmt = null;
			String sql = "UPDATE EST_ESTOQUE SET est_num_numeroendereco = ? WHERE est_dsc_endereco = ? AND est_num_numeroendereco = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setString(2, est_dsc_endereco);
			stmt.setInt(3, est_num_numeroendereco);
			stmt.setInt(1, newEst_num_numeroendereco);
			int linhasAfetadas = stmt.executeUpdate();
			if (linhasAfetadas > 0) {
				System.out.println("Registro atualizado com sucesso!");
			} else {
				System.out.println("Nenhum registro encontrado com a matrícula fornecida.");
			}
		} catch (SQLException e) {
			System.err.println("Erro na atividade desejada: " + e.getMessage());
		}
		est_num_numeroendereco = newEst_num_numeroendereco;
	}

	public int getEst_cod_filial() {
		return est_cod_filial;
	}

	public void setEst_cod_filial(int est_cod_filial) {
		this.est_cod_filial = est_cod_filial;
		try (Connection conexao = ConexaoBd.getConexao()) {
			PreparedStatement stmt = null;
			String sql = "UPDATE EST_ESTOQUE SET est_cod_filial = ? WHERE est_dsc_endereco = ? AND est_num_numeroendereco = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setString(2, est_dsc_endereco);
			stmt.setInt(3, est_num_numeroendereco);
			stmt.setInt(1, est_cod_filial);
			int linhasAfetadas = stmt.executeUpdate();
			if (linhasAfetadas > 0) {
				System.out.println("Registro atualizado com sucesso!");
			} else {
				System.out.println("Nenhum registro encontrado com a matrícula fornecida.");
			}
		} catch (SQLException e) {
			System.err.println("Erro na atividade desejada: " + e.getMessage());
		}
	}

}
