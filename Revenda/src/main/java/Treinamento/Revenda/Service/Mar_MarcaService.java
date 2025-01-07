package Treinamento.Revenda.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Treinamento.Revenda.ConexaoBd;
import Treinamento.Revenda.Mar_Marca;

public class Mar_MarcaService {

		public List<Mar_Marca> getMarcaAll(){
			try(Connection conexao = ConexaoBd.getConexao()){
				List<Mar_Marca> marcas = new ArrayList<>();
				PreparedStatement stmt = null;
				String sql = "SELECT*FROM MAR_MARCA";
				stmt = conexao.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery();
				while (rs.next()) {
					String nome = rs.getString("mar_nom_nome");
					Mar_Marca marca = new Mar_Marca(nome);
					marcas.add(marca);
				}
				return marcas;
			}catch(SQLException e) {
				System.err.println("Erro na atividade desejada: " + e.getMessage());
				return null;
			}
		}
		
		public Mar_Marca getMarcaPorNome(String nome){
			try(Connection conexao = ConexaoBd.getConexao()){
				PreparedStatement stmt = null;
				String sql = "SELECT*FROM MAR_MARCA WHERE mar_nom_nome = ?";
				stmt = conexao.prepareStatement(sql);
				stmt.setString(1, nome);
				ResultSet rs = stmt.executeQuery();
				if(rs.next()) {
					String nome2 = rs.getString("mar_nom_nome");
					return new Mar_Marca(nome2);
				}else {
					return null;
				}
			}catch(SQLException e) {
				System.err.println("Erro na atividade desejada: " + e.getMessage());
				return null;
			}
		}
		
		public int addMarca(Mar_Marca marca) {
			Mar_Marca m1 = getMarcaPorNome(marca.getMar_nom_nome());
			try(Connection conexao = ConexaoBd.getConexao()){
				if(m1==null) {
					PreparedStatement stmt = null;
					String sql = "INSERT INTO MAR_MARCA (mar_nom_nome) VALUES (?)";
					stmt = conexao.prepareStatement(sql);
					stmt.setString(1, marca.getMar_nom_nome());
					int rowsAffected = stmt.executeUpdate();
					if (rowsAffected > 0) {
						System.out.println("Estoque cadastrado com sucesso!");
						return 0;
					}else {
						return 1;
					}
				}else {
					return 2;
				}
			}catch(SQLException e) {
				System.err.println("Erro na atividade desejada: " + e.getMessage());
				return 3;
			}
		}
		
		public int removeMarca(String marca) {
			Mar_Marca m1 = getMarcaPorNome(marca);
			try(Connection conexao = ConexaoBd.getConexao()){
				if(m1==null) {
					//não existe
					return 0;
				}else {
					//deletando
					PreparedStatement stmt = null;
					String sql = "DELETE FROM MAR_MARCA WHERE mar_nom_nome=?";
					stmt = conexao.prepareStatement(sql);
					stmt.setString(1, marca);
					stmt.execute();
					return 1;
				}
			}catch(SQLException e) {
				System.err.println("Erro na atividade desejada: " + e.getMessage());
				return 2;
			}
		}
		
		public boolean atualizarMarca(String nome, String marca) {
			Mar_Marca m1 = getMarcaPorNome(marca);
			try(Connection conexao = ConexaoBd.getConexao()){
				if(m1==null) {
					System.out.println("Marca não cadastradas ... efetuando cadastro para atualizar em seguida");
					m1 = new Mar_Marca(nome);
					return true;
				}else {
					m1.setMar_nom_nome(nome);
					return true;
				}
			}catch(SQLException e) {
				System.err.println("Erro na atividade desejada: " + e.getMessage());
				return false;
			}
		}
}
