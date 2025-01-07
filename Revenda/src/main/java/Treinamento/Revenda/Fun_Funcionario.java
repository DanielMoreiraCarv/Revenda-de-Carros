package Treinamento.Revenda;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Fun_Funcionario {
	private String fun_nom_nome;
	private String fun_cod_cpf;
	private String fun_num_numeroTelefone;
	private String fun_nom_email;
	private Date fun_dat_datanascimento;
	private String fun_cod_contaBancaria;
	private String fun_nom_agenciaBancaria;

	public Fun_Funcionario(String fun_nom_nome, String fun_cod_cpf, String fun_num_numeroTelefone, String fun_nom_email,
			String fun_dat_datanascimento, String fun_cod_contaBancaria, String fun_nom_agenciaBancaria) {
		this.fun_nom_nome = fun_nom_nome;
		this.fun_cod_cpf = fun_cod_cpf;
		this.fun_num_numeroTelefone = fun_num_numeroTelefone;
		this.fun_nom_email = fun_nom_email;
		this.fun_dat_datanascimento = converterData(fun_dat_datanascimento);
		this.fun_cod_contaBancaria = fun_cod_contaBancaria;
		this.fun_nom_agenciaBancaria = fun_nom_agenciaBancaria;
	}
	public Fun_Funcionario(String fun_nom_nome, String fun_cod_cpf, String fun_num_numeroTelefone, String fun_nom_email,
			Date fun_dat_datanascimento, String fun_cod_contaBancaria, String fun_nom_agenciaBancaria) {
		this.fun_nom_nome = fun_nom_nome;
		this.fun_cod_cpf = fun_cod_cpf;
		this.fun_num_numeroTelefone = fun_num_numeroTelefone;
		this.fun_nom_email = fun_nom_email;
		this.fun_dat_datanascimento = (fun_dat_datanascimento);
		this.fun_cod_contaBancaria = fun_cod_contaBancaria;
		this.fun_nom_agenciaBancaria = fun_nom_agenciaBancaria;
	}

	public String getFun_nom_nome() {
		return fun_nom_nome;
	}

	public void setFun_nom_nome(String fun_nom_nome) {
		this.fun_nom_nome = fun_nom_nome;
		try(Connection conexao = ConexaoBd.getConexao()){
			PreparedStatement stmt = null;
			String sql = "UPDATE FUN_FUNCIONARIO SET fun_nom_nome = ? WHERE fun_cod_cpf = ? ";
			stmt = conexao.prepareStatement(sql);
			stmt.setString(2, fun_cod_cpf);
			stmt.setString(1, fun_nom_nome);
			int linhasAfetadas = stmt.executeUpdate();
            if (linhasAfetadas > 0) {
                System.out.println("Registro atualizado com sucesso!");
            } else {
                System.out.println("Nenhum registro encontrado com a matrícula fornecida.");
            }
		}catch(SQLException e) {
			System.err.println("Erro na atividade desejada: " + e.getMessage());
		}
	}

	public String getFun_cod_cpf() {
		return fun_cod_cpf;
	}

	public void setFun_cod_cpf(String fun_cod_cpf) {
		this.fun_cod_cpf = fun_cod_cpf;
		try(Connection conexao = ConexaoBd.getConexao()){
			PreparedStatement stmt = null;
			String sql = "UPDATE FUN_FUNCIONARIO SET fun_cod_cpf = ? WHERE fun_nom_nome = ? AND fun_num_numerotelefone = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, fun_cod_cpf);
			stmt.setString(2, fun_nom_nome);
			stmt.setString(3, fun_num_numeroTelefone);
			int linhasAfetadas = stmt.executeUpdate();
            if (linhasAfetadas > 0) {
                System.out.println("Registro atualizado com sucesso!");
            } else {
                System.out.println("Nenhum registro encontrado com a matrícula fornecida.");
            }
		}catch(SQLException e) {
			System.err.println("Erro na atividade desejada: " + e.getMessage());
		}
	}

	public String getFun_num_numeroTelefone() {
		return fun_num_numeroTelefone;
	}

	public void setFun_num_numeroTelefone(String fun_num_numeroTelefone) {
		this.fun_num_numeroTelefone = fun_num_numeroTelefone;
		try(Connection conexao = ConexaoBd.getConexao()){
			PreparedStatement stmt = null;
			String sql = "UPDATE FUN_FUNCIONARIO SET fun_num_numerotelefone = ? WHERE fun_cod_cpf= ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setString(2, fun_cod_cpf);
			stmt.setString(1, fun_num_numeroTelefone);
			int linhasAfetadas = stmt.executeUpdate();
            if (linhasAfetadas > 0) {
                System.out.println("Registro atualizado com sucesso!");
            } else {
                System.out.println("Nenhum registro encontrado com a matrícula fornecida.");
            }
		}catch(SQLException e) {
			System.err.println("Erro na atividade desejada: " + e.getMessage());
		}
	}

	public String getFun_nom_email() {
		return fun_nom_email;
	}

	public void setFun_nom_email(String fun_nom_email) {
		this.fun_nom_email = fun_nom_email;
		try(Connection conexao = ConexaoBd.getConexao()){
			PreparedStatement stmt = null;
			String sql = "UPDATE FUN_FUNCIONARIO SET fun_nom_email = ? WHERE fun_cod_cpf= ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setString(2, fun_cod_cpf);
			stmt.setString(1, fun_nom_email);
			int linhasAfetadas = stmt.executeUpdate();
            if (linhasAfetadas > 0) {
                System.out.println("Registro atualizado com sucesso!");
            } else {
                System.out.println("Nenhum registro encontrado com a matrícula fornecida.");
            }
		}catch(SQLException e) {
			System.err.println("Erro na atividade desejada: " + e.getMessage());
		}
	}

	public Date getFun_dat_datanascimento() {
		return fun_dat_datanascimento;
	}

	public void setFun_dat_datanascimento(Date fun_dat_datanascimento) {
		this.fun_dat_datanascimento = fun_dat_datanascimento;
		try(Connection conexao = ConexaoBd.getConexao()){
			PreparedStatement stmt = null;
			String sql = "UPDATE FUN_FUNCIONARIO SET fun_dat_datanascimento = ? WHERE fun_cod_cpf= ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setString(2, fun_cod_cpf);
			stmt.setDate(1, fun_dat_datanascimento);
			int linhasAfetadas = stmt.executeUpdate();
            if (linhasAfetadas > 0) {
                System.out.println("Registro atualizado com sucesso!");
            } else {
                System.out.println("Nenhum registro encontrado com a matrícula fornecida.");
            }
		}catch(SQLException e) {
			System.err.println("Erro na atividade desejada: " + e.getMessage());
		}
	}

	public String getFun_cod_contaBancaria() {
		return fun_cod_contaBancaria;
	}

	public void setFun_cod_contaBancaria(String fun_cod_contaBancaria) {
		this.fun_cod_contaBancaria = fun_cod_contaBancaria;
		try(Connection conexao = ConexaoBd.getConexao()){
			PreparedStatement stmt = null;
			String sql = "UPDATE FUN_FUNCIONARIO SET fun_cod_contaBancaria = ? WHERE fun_cod_cpf= ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setString(2, fun_cod_cpf);
			stmt.setString(1, fun_cod_contaBancaria);
			int linhasAfetadas = stmt.executeUpdate();
            if (linhasAfetadas > 0) {
                System.out.println("Registro atualizado com sucesso!");
            } else {
                System.out.println("Nenhum registro encontrado com a matrícula fornecida.");
            }
		}catch(SQLException e) {
			System.err.println("Erro na atividade desejada: " + e.getMessage());
		}
	}

	public String getFun_nom_agenciaBancaria() {
		return fun_nom_agenciaBancaria;
	}

	public void setFun_nom_agenciaBancaria(String fun_nom_agenciaBancaria) {
		this.fun_nom_agenciaBancaria = fun_nom_agenciaBancaria;
		try(Connection conexao = ConexaoBd.getConexao()){
			PreparedStatement stmt = null;
			String sql = "UPDATE FUN_FUNCIONARIO SET fun_nom_agenciaBancaria = ? WHERE fun_cod_cpf= ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setString(2, fun_cod_cpf);
			stmt.setString(1, fun_nom_agenciaBancaria);
			int linhasAfetadas = stmt.executeUpdate();
            if (linhasAfetadas > 0) {
                System.out.println("Registro atualizado com sucesso!");
            } else {
                System.out.println("Nenhum registro encontrado com a matrícula fornecida.");
            }
		}catch(SQLException e) {
			System.err.println("Erro na atividade desejada: " + e.getMessage());
		}
	}

	@Override
	public String toString() {
		return "Funcionario: \n-Nome: " + fun_nom_nome + "\n-CPF: " + fun_cod_cpf + "\n-Número de Telefone: "
				+ fun_num_numeroTelefone + "\n-Email: " + fun_nom_email + "\n-Data de Nascimento: "
				+ fun_dat_datanascimento + "\n-Código da Conta Bancária: " + fun_cod_contaBancaria
				+ "\n-Nome da Agência: " + fun_nom_agenciaBancaria;
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
