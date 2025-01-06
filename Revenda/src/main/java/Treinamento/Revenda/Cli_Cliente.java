package Treinamento.Revenda;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Cli_Cliente {
	private String cli_nom_nome;
	private String cli_cod_cpf;
	private String cli_num_numeroTelefone;
	private String cli_nom_email;
	
	public Cli_Cliente(String cli_nom_nome, String cli_cod_cpf, String cli_num_numeroTelefone, String cli_nom_email) {
		super();
		this.cli_nom_nome = cli_nom_nome;
		this.cli_cod_cpf = cli_cod_cpf;
		this.cli_num_numeroTelefone = cli_num_numeroTelefone;
		this.cli_nom_email = cli_nom_email;
	}

	public String getCli_nom_nome() {
		return cli_nom_nome;
	}

	public void setCli_nom_nome(String cli_nom_nome) {
		this.cli_nom_nome = cli_nom_nome;
		try (Connection conexao = ConexaoBd.getConexao()) {
			PreparedStatement stmt = null;
			String sql = "UPDATE CLI_CLIENTE SET cli_nom_nome = ? WHERE cli_cod_cpf = ? ";
			stmt = conexao.prepareStatement(sql);
			stmt.setString(2, cli_cod_cpf);
			stmt.setString(1, cli_nom_nome);
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

	public String getCli_cod_cpf() {
		return cli_cod_cpf;
	}

	public void setCli_cod_cpf(String cli_cod_cpf) {
		this.cli_cod_cpf = cli_cod_cpf;
		try (Connection conexao = ConexaoBd.getConexao()) {
			PreparedStatement stmt = null;
			String sql = "UPDATE CLI_CLIENTE SET cli_nom_nome = ? WHERE WHERE for_nom_nome = ? AND for_num_numerotelefone = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, cli_cod_cpf);
			stmt.setString(2, cli_nom_nome);
			stmt.setString(3, cli_num_numeroTelefone);
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

	public String getCli_num_numeroTelefone() {
		return cli_num_numeroTelefone;
	}

	public void setCli_num_numeroTelefone(String cli_num_numeroTelefone) {
		this.cli_num_numeroTelefone = cli_num_numeroTelefone;
		try (Connection conexao = ConexaoBd.getConexao()) {
			PreparedStatement stmt = null;
			String sql = "UPDATE CLI_CLIENTE SET cli_num_numerotelefone = ? WHERE WHERE cli_cod_cpf = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setString(2, cli_cod_cpf);
			stmt.setString(1, cli_num_numeroTelefone);
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

	public String getCli_nom_email() {
		return cli_nom_email;
	}

	public void setCli_nom_email(String cli_nom_email) {
		this.cli_nom_email = cli_nom_email;
		try (Connection conexao = ConexaoBd.getConexao()) {
			PreparedStatement stmt = null;
			String sql = "UPDATE CLI_CLIENTE SET cli_nom_email = ? WHERE WHERE cli_cod_cpf = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setString(2, cli_cod_cpf);
			stmt.setString(1, cli_nom_email);
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
		return "Cliente : \n-Nome: " + cli_nom_nome + "\n-CPF: " + cli_cod_cpf
				+ "/n-Telefone: " + cli_num_numeroTelefone + "/n-Email" + cli_nom_email ;
	}
	
	
	
}
