package Treinamento.Revenda;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class For_Fornecedor {
	private String for_nom_nome;
	private String for_cod_cpf;
	private String for_num_numeroTelefone;
	private String for_nom_email;
	private String for_cod_contaBancaria;
	private String for_nom_agenciaBancaria;

	public For_Fornecedor(String for_nom_nome, String for_cod_cpf, String for_num_numeroTelefone, String for_nom_email,
			String for_cod_contaBancaria, String for_nom_agenciaBancaria) {
		this.for_nom_nome = for_nom_nome;
		this.for_cod_cpf = for_cod_cpf;
		this.for_num_numeroTelefone = for_num_numeroTelefone;
		this.for_nom_email = for_nom_email;
		this.for_cod_contaBancaria = for_cod_contaBancaria;
		this.for_nom_agenciaBancaria = for_nom_agenciaBancaria;
	}

	public String getFor_nom_nome() {
		return for_nom_nome;
	}

	public void setFor_nom_nome(String for_nom_nome) {
		this.for_nom_nome = for_nom_nome;
		try (Connection conexao = ConexaoBd.getConexao()) {
			PreparedStatement stmt = null;
			String sql = "UPDATE FOR_FORNECEDOR SET for_nom_nome = ? WHERE for_cod_identificador = ? ";
			stmt = conexao.prepareStatement(sql);
			stmt.setString(2, getFor_cod_cpf());
			stmt.setString(1, for_nom_nome);
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

	public String getFor_cod_cpf() {
		return for_cod_cpf;
	}

	public void setFor_cod_cpf(String for_cod_cpf) {
		this.for_cod_cpf = for_cod_cpf;
		try (Connection conexao = ConexaoBd.getConexao()) {
			PreparedStatement stmt = null;
			String sql = "UPDATE FOR_FORNECEDOR SET for_cod_cpf = ? WHERE for_nom_nome = ? AND for_num_numerotelefone = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, for_cod_cpf);
			stmt.setString(2, for_nom_nome);
			stmt.setString(3, for_num_numeroTelefone);
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

	public String getFor_num_numeroTelefone() {
		return for_num_numeroTelefone;
	}

	public void setFor_num_numeroTelefone(String for_num_numeroTelefone) {
		this.for_num_numeroTelefone = for_num_numeroTelefone;
		try (Connection conexao = ConexaoBd.getConexao()) {
			PreparedStatement stmt = null;
			String sql = "UPDATE FOR_FORNECEDOR SET for_num_numerotelefone = ? WHERE for_cod_identificador= ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setString(2, for_cod_cpf);
			stmt.setString(1, for_num_numeroTelefone);
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

	public String getFor_nom_email() {
		return for_nom_email;
	}

	public void setFor_nom_email(String for_nom_email) {
		this.for_nom_email = for_nom_email;
		try (Connection conexao = ConexaoBd.getConexao()) {
			PreparedStatement stmt = null;
			String sql = "UPDATE FOR_FORNECEDOR SET for_nom_email = ? WHERE for_cod_identificador=?";
			stmt = conexao.prepareStatement(sql);
			stmt.setString(2, for_cod_cpf);
			stmt.setString(1, for_nom_email);
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

	public String getFor_cod_contaBancaria() {
		return for_cod_contaBancaria;
	}

	public void setFor_cod_contaBancaria(String for_cod_contaBancaria) {
		this.for_cod_contaBancaria = for_cod_contaBancaria;
		try (Connection conexao = ConexaoBd.getConexao()) {
			PreparedStatement stmt = null;
			String sql = "UPDATE FOR_FORNECEDOR SET for_cod_contaBancaria = ? WHERE for_cod_identificador=?";
			stmt = conexao.prepareStatement(sql);
			stmt.setString(2, for_cod_cpf);
			stmt.setString(1, for_cod_contaBancaria);
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

	public String getFor_nom_agenciaBancaria() {
		return for_nom_agenciaBancaria;
	}

	public void setFor_nom_agenciaBancaria(String for_nom_agenciaBancaria) {
		this.for_nom_agenciaBancaria = for_nom_agenciaBancaria;
		try (Connection conexao = ConexaoBd.getConexao()) {
			PreparedStatement stmt = null;
			String sql = "UPDATE FOR_FORNECEDOR SET for_nom_agenciaBancaria = ? WHERE for_cod_identificador=?";
			stmt = conexao.prepareStatement(sql);
			stmt.setString(2, for_cod_cpf);
			stmt.setString(1, for_nom_agenciaBancaria);
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

	@Override
	public String toString() {
		return "Forcionario: \n-Nome: " + for_nom_nome + "\n-CPF: " + for_cod_cpf + "\n-Número de Telefone: "
				+ for_num_numeroTelefone + "\n-Email: " + for_nom_email + "\n-Código da Conta Bancária: "
				+ for_cod_contaBancaria + "\n-Nome da Agência: " + for_nom_agenciaBancaria;
	}

	public static Date converterData(String data) {
		DateTimeFormatter formatoEntrada = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		try {
			LocalDate dataConvertida = LocalDate.parse(data, formatoEntrada);

			java.sql.Date dataSql = java.sql.Date.valueOf(dataConvertida);
			return dataSql;
		} catch (DateTimeParseException e) {
			System.out.println("Erro ao converter a data. Verifique o formato (dd/MM/yyyy): " + data);
			return null;
		}
	}

}
