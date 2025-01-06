package Treinamento.Revenda;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Est_EstoqueService {
	public List<Est_Estoque> getEstoqueAll() {
		try (Connection conexao = ConexaoBd.getConexao()) {
			List<Est_Estoque> estoques = new ArrayList<>();
			PreparedStatement stmt = null;
			String sql = "SELECT*FROM EST_ESTOQUE";
			stmt = conexao.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				String end = rs.getString("est_dsc_endereco");
				int numEnd = rs.getInt("est_num_numeroendereco");
				int filial = rs.getInt("est_cod_filial");
				Est_Estoque estoque = new Est_Estoque(end, numEnd, filial);
				estoques.add(estoque);
			}
			return estoques;

		} catch (SQLException e) {
			System.err.println("Erro na atividade desejada: " + e.getMessage());
			return null;
		}
	}

	public List<Est_Estoque> getEstoqueAllRua(String endereco) {
		try (Connection conexao = ConexaoBd.getConexao()) {
			List<Est_Estoque> estoques = new ArrayList<>();
			PreparedStatement stmt = null;
			String sql = "SELECT*FROM EST_ESTOQUE WHERE est_dsc_endereco = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, endereco);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				String end = rs.getString("est_dsc_endereco");
				int numEnd = rs.getInt("est_num_numeroendereco");
				int filial = rs.getInt("est_cod_filial");
				Est_Estoque estoque = new Est_Estoque(end, numEnd, filial);
				estoques.add(estoque);
			}
			return estoques;

		} catch (SQLException e) {
			System.err.println("Erro na atividade desejada: " + e.getMessage());
			return null;
		}
	}

	public Est_Estoque getEstoquePorEnderecoCompleto(String endereco, int num) {
		try (Connection conexao = ConexaoBd.getConexao()) {
			PreparedStatement stmt = null;
			String sql = "SELECT*FROM EST_ESTOQUE WHERE est_dsc_endereco = ? AND est_num_numeroendereco = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, endereco);
			stmt.setInt(2, num);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				String end = rs.getString("est_dsc_endereco");
				int numEnd = rs.getInt("est_num_numeroendereco");
				int filial = rs.getInt("est_cod_filial");
				Est_Estoque estoque = new Est_Estoque(end, numEnd, filial);
				return estoque;
			} else {
				System.out.println("Estoque não encontrado");
				return null;
			}

		} catch (SQLException e) {
			System.err.println("Erro na atividade desejada: " + e.getMessage());
			return null;
		}
	}

	public boolean removeEstoque(Est_Estoque e1) {
		try (Connection conexao = ConexaoBd.getConexao()) {
			PreparedStatement stmt = null;
			String sql = "DELETE FROM EST_ESTPQUE WHERE est_dsc_endereco = ? AND est_num_numeroendereco = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, e1.getEst_dsc_endereco());
			stmt.setInt(1, e1.getEst_num_numeroendereco());
			stmt.execute();
			System.out.println("Estoque deletado com sucesso");
			return true;

		} catch (SQLException e) {
			System.err.println("Erro na atividade desejada: " + e.getMessage());
			return false;
		}
	}

	public int addEstoque(Est_Estoque estoque) {
		Est_Estoque e1 = null;
		e1 = getEstoquePorEnderecoCompleto(estoque.getEst_dsc_endereco(), estoque.getEst_num_numeroendereco());
		try (Connection conexao = ConexaoBd.getConexao()) {
			if (e1 == null) {
				PreparedStatement stmt = null;
				String sql = "INSERT INTO CLI_CLIENTE(est_dsc_endereco,est_num_numeroendereco,est_cod_filial) VALUES (?,?,?)";
				stmt = conexao.prepareStatement(sql);
				stmt.setString(1, estoque.getEst_dsc_endereco());
				stmt.setInt(2, estoque.getEst_num_numeroendereco());
				stmt.setInt(3, estoque.getEst_cod_filial());
				int rowsAffected = stmt.executeUpdate();
				if (rowsAffected > 0) {
					System.out.println("Estoque cadastrado com sucesso!");
					return 0;
				}
				return 1;
			} else {
				System.out.println("Estoque com esse cpf já cadastrado");
				return 2;
			}

		} catch (SQLException e) {
			System.err.println("Erro na atividade desejada: " + e.getMessage());
			return 3;
		}

	}

	public boolean atualzarEstoqueDsc(String dadoNovo, Est_Estoque estoque) {
		try (Connection conexao = ConexaoBd.getConexao()) {
			if (estoque == null) {
				return false;
			} else {
				estoque.setEst_dsc_endereco(dadoNovo);
				return true;
			}
		} catch (SQLException e) {
			System.err.println("Erro na atividade desejada: " + e.getMessage());
			return false;
		}

	}

	public boolean atualzarEstoqueNumOuFilial(String info, int dadoNovo, Est_Estoque estoque) {
		try (Connection conexao = ConexaoBd.getConexao()) {
			if (estoque == null) {
				return false;
			} else {
				boolean value = false;
				switch (info) {
				case "Num":
					estoque.setEst_num_numeroendereco(dadoNovo);
					value = true;
					break;
				case "Filial":
					estoque.setEst_cod_filial(dadoNovo);
					value = true;
					break;
				default:
					break;
				}
				return value;
			}
		} catch (SQLException e) {
			System.err.println("Erro na atividade desejada: " + e.getMessage());
			return false;
		}

	}
}
