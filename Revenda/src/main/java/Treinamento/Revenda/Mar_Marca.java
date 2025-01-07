package Treinamento.Revenda;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Mar_Marca {
	private String mar_nom_nome;

	public Mar_Marca(String mar_nom_nome) {
		this.mar_nom_nome = mar_nom_nome;
	}

	@Override
	public String toString() {
		return "Marca: " + mar_nom_nome ;
	}

	public String getMar_nom_nome() {
		return mar_nom_nome;
	}

	public void setMar_nom_nome(String mar_nom_nome) {
		try (Connection conexao = ConexaoBd.getConexao()) {
			PreparedStatement stmt = null;
			String sql = "UPDATE MAR_MARCA SET mar_nom_nome = ? WHERE mar_nom_nome = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, mar_nom_nome);
			stmt.setString(2, this.mar_nom_nome);
			int linhasAfetadas = stmt.executeUpdate();
			if (linhasAfetadas > 0) {
				System.out.println("Registro atualizado com sucesso!");
			} else {
				System.out.println("Nenhum registro encontrado com a matrícula fornecida.");
			}
		} catch (SQLException e) {
			System.err.println("Erro na atividade desejada: " + e.getMessage());
		}
		this.mar_nom_nome = mar_nom_nome;
	}
	
	
}
