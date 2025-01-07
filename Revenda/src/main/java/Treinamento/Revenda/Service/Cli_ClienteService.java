package Treinamento.Revenda.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import Treinamento.Revenda.Cli_Cliente;
import Treinamento.Revenda.ConexaoBd;

@Service
public class Cli_ClienteService {
	public Cli_Cliente getClientePorCpf(String cpf) {
		try (Connection conexao = ConexaoBd.getConexao()) {
			PreparedStatement stmt = null;
			String sql = "SELECT*FROM CLI_CLIENTE WHERE cli_cod_cpf = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, cpf);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				String nome = rs.getString("cli_nom_nome");
				String tel = rs.getString("cli_num_numerotelefone");
				String email = rs.getString("cli_nom_email");
				Cli_Cliente cliente = new Cli_Cliente(nome, cpf, tel, email);
				return cliente;
			} else {
				System.out.println("Cliente não encontrado");
				return null;
			}
		} catch (SQLException e) {
			System.err.println("Erro na atividade desejada: " + e.getMessage());
			return null;
		}
	}

	public boolean removeClietne(Cli_Cliente c1) {
		try (Connection conexao = ConexaoBd.getConexao()) {
			PreparedStatement stmt = null;
			String sql = "DELETE FROM CLI_CLIENTE WHERE cli_cod_cpf = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, c1.getCli_cod_cpf());
			stmt.execute();
			System.out.println("Cliente deletado com sucesso");
			return true;

		} catch (SQLException e) {
			System.err.println("Erro na atividade desejada: " + e.getMessage());
			return false;
		}
	}

	public int addCliente(Cli_Cliente cliente) {
		Cli_Cliente c1 = null;
		c1 = getClientePorCpf(cliente.getCli_cod_cpf());
		try (Connection conexao = ConexaoBd.getConexao()) {
			if (c1 == null) {
				PreparedStatement stmt = null;
				String sql = "INSERT INTO CLI_CLIENTE(cli_nom_nome,cli_cod_cpf,cli_num_numeroTelefone,cli_nom_email) VALUES (?,?,?,?)";
				stmt = conexao.prepareStatement(sql);
				stmt.setString(1, cliente.getCli_nom_nome());
				stmt.setString(2, cliente.getCli_cod_cpf());
				stmt.setString(3, cliente.getCli_num_numeroTelefone());
				stmt.setString(4, cliente.getCli_nom_email());
				int rowsAffected = stmt.executeUpdate();
				if (rowsAffected > 0) {
					System.out.println("Cliente cadastrado com sucesso!");
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

	public List<Cli_Cliente> getClienteAll() {
		try (Connection conexao = ConexaoBd.getConexao()) {
			List<Cli_Cliente> clientes = new ArrayList<>();
			PreparedStatement stmt = null;
			String sql = "SELECT*FROM CLI_CLIENTE";
			stmt = conexao.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				String nome = rs.getString("cli_nom_nome");
				String cpf = rs.getString("cli_cod_cpf");
				String tel = rs.getString("cli_num_numerotelefone");
				String email = rs.getString("cli_nom_email");
				Cli_Cliente cliente = new Cli_Cliente(nome, cpf, tel, email);
				clientes.add(cliente);
			}
			return clientes;

		} catch (SQLException e) {
			System.err.println("Erro na atividade desejada: " + e.getMessage());
			return null;
		}
	}

	public boolean atualzarCliente(String info, String dadoNovo, String cpf) {
		try (Connection conexao = ConexaoBd.getConexao()) {
			Cli_Cliente cliente = getClientePorCpf(cpf);
			if (cliente == null) {
				return false;
			} else {
				boolean value;
				switch (info) {
				case "nome":
					cliente.setCli_nom_nome(dadoNovo);
					value = true;
					break;
				case "numTelefone":
					cliente.setCli_num_numeroTelefone(dadoNovo);
					value = true;
					break;
				case "email":
					cliente.setCli_nom_email(dadoNovo);
					value = true;
					break;
				case "cpf":
					cliente.setCli_cod_cpf(dadoNovo);
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
