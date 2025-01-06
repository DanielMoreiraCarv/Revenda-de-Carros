package Treinamento.Revenda;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class For_FornecedorService {
	public For_Fornecedor getFornecedorPorCpf(String cpf) {
		try (Connection conexao = ConexaoBd.getConexao()) {
			PreparedStatement stmt = null;
			String sql = "SELECT*FROM FOR_FORNECEDOR WHERE for_cod_cpf = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, cpf);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				String nome = rs.getString("for_nom_nome");
				String tel = rs.getString("for_num_numerotelefone");
				String email = rs.getString("for_nom_email");
				String cont = rs.getString("for_cod_contabancaria");
				String ag = rs.getString("for_nom_agenciabancaria");
				For_Fornecedor fornecedor = new For_Fornecedor(nome, cpf, tel, email, cont, ag);
				return fornecedor;
			} else {
				System.out.println("Fornecedor não encontrado");
				return null;
			}
		} catch (SQLException e) {
			System.err.println("Erro na atividade desejada: " + e.getMessage());
			return null;
		}
	}

	public boolean removeFornecedor(For_Fornecedor f1) {
		try (Connection conexao = ConexaoBd.getConexao()) {
			PreparedStatement stmt = null;
			String sql = "DELETE FROM FUN_FUNCIONARIO WHERE fun_cod_cpf = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, f1.getFor_cod_cpf());
			stmt.execute();
			System.out.println("Fornecedor deletado com sucesso");
			return true;

		} catch (SQLException e) {
			System.err.println("Erro na atividade desejada: " + e.getMessage());
			return false;
		}
	}

	public int addFornecedor(For_Fornecedor fornecedor) {
		For_Fornecedor f1 = null;
		f1 = getFornecedorPorCpf(fornecedor.getFor_cod_cpf());
		try (Connection conexao = ConexaoBd.getConexao()) {
			if (f1 == null) {
				PreparedStatement stmt = null;
				String sql = "INSERT INTO FUN_FUNCIONARIO(fun_nom_nome,fun_cod_cpf,fun_num_numeroTelefone,fun_nom_email,fun_dat_datanascimento,fun_cod_contaBancaria,fun_nom_agenciaBancaria) VALUES (?,?,?,?,?,?)";
				stmt = conexao.prepareStatement(sql);
				stmt.setString(1, fornecedor.getFor_nom_nome());
				stmt.setString(2, fornecedor.getFor_cod_cpf());
				stmt.setString(3, fornecedor.getFor_num_numeroTelefone());
				stmt.setString(4, fornecedor.getFor_nom_email());
				stmt.setString(5, fornecedor.getFor_cod_contaBancaria());
				stmt.setString(6, fornecedor.getFor_nom_agenciaBancaria());
				int rowsAffected = stmt.executeUpdate();
				if (rowsAffected > 0) {
					System.out.println("Fornecedor cadastrado com sucesso!");
					return 0;
				}
				return 1;
			} else {
				System.out.println("Fornecedor com esse cpf já cadastrado");
				return 2;
			}

		} catch (SQLException e) {
			System.err.println("Erro na atividade desejada: " + e.getMessage());
			return 3;
		}

	}

	public List<For_Fornecedor> getFornecedorAll() {
		try (Connection conexao = ConexaoBd.getConexao()) {
			List<For_Fornecedor> fornecedores = new ArrayList<>();
			PreparedStatement stmt = null;
			String sql = "SELECT*FROM FUN_FUNCIONARIO";
			stmt = conexao.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				String nome = rs.getString("for_nom_nome");
				String cpf = rs.getString("for_cod_cpf");
				String tel = rs.getString("for_num_numerotelefone");
				String email = rs.getString("for_nom_email");
				String cont = rs.getString("for_cod_contabancaria");
				String ag = rs.getString("for_nom_agenciabancaria");
				For_Fornecedor fornecedor = new For_Fornecedor(nome, cpf, tel, email, cont, ag);
				fornecedores.add(fornecedor);
			}
			return fornecedores;

		} catch (SQLException e) {
			System.err.println("Erro na atividade desejada: " + e.getMessage());
			return null;
		}
	}

	public boolean atualzarFornecedor(String info, String dadoNovo, String cpf) {
		try (Connection conexao = ConexaoBd.getConexao()) {
			For_Fornecedor fornecedor = getFornecedorPorCpf(cpf);
			if (fornecedor == null) {
				return false;
			} else {
				boolean value;
				switch (info) {
				case "nome":
					fornecedor.setFor_nom_nome(dadoNovo);
					value = true;
					break;
				case "numTelefone":
					fornecedor.setFor_num_numeroTelefone(dadoNovo);
					value = true;
					break;
				case "email":
					fornecedor.setFor_nom_email(dadoNovo);
					value = true;
					break;
				case "codConta":
					fornecedor.setFor_cod_contaBancaria(dadoNovo);
					value = true;
					break;
				case "agencia":
					fornecedor.setFor_nom_agenciaBancaria(dadoNovo);
					value = true;
					break;
				case "cpf":
					fornecedor.setFor_cod_cpf(dadoNovo);
					value = true;
					break;
				default:
					value = false;
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
