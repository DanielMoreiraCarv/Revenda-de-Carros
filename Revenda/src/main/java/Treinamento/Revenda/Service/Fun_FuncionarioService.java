package Treinamento.Revenda.Service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import Treinamento.Revenda.ConexaoBd;
import Treinamento.Revenda.Fun_Funcionario;

@Service
public class Fun_FuncionarioService {
	public static Fun_Funcionario getFuncionarioPorCpf(String cpf) {
		try (Connection conexao = ConexaoBd.getConexao()) {
			PreparedStatement stmt = null;
			String sql = "SELECT*FROM FUN_FUNCIONARIO WHERE fun_cod_cpf = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, cpf);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				String nome = rs.getString("fun_nom_nome");
				String tel = rs.getString("fun_num_numerotelefone");
				String email = rs.getString("fun_nom_email");
				Date data = rs.getDate("fun_dat_datanascimento");
				String cont = rs.getString("fun_cod_contabancaria");
				String ag = rs.getString("fun_nom_agenciabancaria");
				Fun_Funcionario funcionario = new Fun_Funcionario(nome, cpf, tel, email, data, cont, ag);
				return funcionario;
			} else {
				System.out.println("Funcionário não encontrado");
				return null;
			}
		} catch (SQLException e) {
			System.err.println("Erro na atividade desejada: " + e.getMessage());
			return null;
		}
	}

	public List<Fun_Funcionario> getFuncionarioAll() {
		try (Connection conexao = ConexaoBd.getConexao()) {
			List<Fun_Funcionario> funcionarios = new ArrayList<>();
			PreparedStatement stmt = null;
			String sql = "SELECT*FROM FUN_FUNCIONARIO";
			stmt = conexao.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				String nome = rs.getString("fun_nom_nome");
				String cpf = rs.getString("fun_cod_cpf");
				String tel = rs.getString("fun_num_numerotelefone");
				String email = rs.getString("fun_nom_email");
				Date data = rs.getDate("fun_dat_datanascimento");
				String cont = rs.getString("fun_cod_contabancaria");
				String ag = rs.getString("fun_nom_agenciabancaria");
				Fun_Funcionario funcionario = new Fun_Funcionario(nome, cpf, tel, email, data, cont, ag);
				funcionarios.add(funcionario);
			}
			return funcionarios;

		} catch (SQLException e) {
			System.err.println("Erro na atividade desejada: " + e.getMessage());
			return null;
		}
	}

	public boolean removeFuncionario(String fun_cod_cpf) {
		try (Connection conexao = ConexaoBd.getConexao()) {
			PreparedStatement stmt = null;
			String sql = "DELETE FROM FUN_FUNCIONARIO WHERE fun_cod_cpf = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, fun_cod_cpf);
			stmt.execute();
			System.out.println("Funcionário deletado com sucesso");
			return true;

		} catch (SQLException e) {
			System.err.println("Erro na atividade desejada: " + e.getMessage());
			return false;
		}
	}

	public int addFuncionario(Fun_Funcionario funcionario) {
		Fun_Funcionario f1 = null;
		f1 = Fun_FuncionarioService.getFuncionarioPorCpf(funcionario.getFun_cod_cpf());
		try (Connection conexao = ConexaoBd.getConexao()) {
			if (f1 == null) {
				PreparedStatement stmt = null;
				String sql = "INSERT INTO FUN_FUNCIONARIO(fun_nom_nome,fun_cod_cpf,fun_num_numeroTelefone,fun_nom_email,fun_dat_datanascimento,fun_cod_contaBancaria,fun_nom_agenciaBancaria) VALUES (?,?,?,?,?,?,?)";
				stmt = conexao.prepareStatement(sql);
				stmt.setString(1, funcionario.getFun_nom_nome());
				stmt.setString(2, funcionario.getFun_cod_cpf());
				stmt.setString(3, funcionario.getFun_num_numeroTelefone());
				stmt.setString(4, funcionario.getFun_nom_email());
				stmt.setDate(5, funcionario.getFun_dat_datanascimento());
				stmt.setString(6, funcionario.getFun_cod_contaBancaria());
				stmt.setString(7, funcionario.getFun_nom_agenciaBancaria());
				int rowsAffected = stmt.executeUpdate();
				if (rowsAffected > 0) {
					System.out.println("Funcionario cadastrado com sucesso!");
					return 0;
				}
				return 1;
			} else {
				System.out.println("Funcionário já cadastrado com esse cpf!");
				return 2;
			}

		} catch (SQLException e) {
			System.err.println("Erro na atividade desejada: " + e.getMessage());
			return 3;
		}

	}

	public boolean atualzarFuncionario(String info, String dadoNovo, String cpf) {
		try (Connection conexao = ConexaoBd.getConexao()) {
			Fun_Funcionario funcionario = getFuncionarioPorCpf(cpf);
			if (funcionario == null) {
				return false;
			} else {
				boolean value;
				switch (info) {
				case "nome":
					funcionario.setFun_nom_nome(dadoNovo);
					value = true;
					break;
				case "numTelefone":
					funcionario.setFun_num_numeroTelefone(dadoNovo);
					value = true;
					break;
				case "email":
					funcionario.setFun_nom_email(dadoNovo);
					value = true;
					break;
				case "data":
					Date data = Fun_Funcionario.converterData(dadoNovo);
					funcionario.setFun_dat_datanascimento(data);
					value = true;
					break;
				case "codConta":
					funcionario.setFun_cod_contaBancaria(dadoNovo);
					value = true;
					break;
				case "agencia":
					funcionario.setFun_nom_agenciaBancaria(dadoNovo);
					value = true;
					break;
				case "cpf":
					funcionario.setFun_cod_cpf(dadoNovo);
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
