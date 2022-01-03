package com.fundatec.lpi.estoque.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.fundatec.lpi.estoque.dominio.Item;

public class ItemDao implements BaseDao<Item> {

	public void save(Item item) {
		try {
			
			String mysqlDriver = "com.mysql.cj.jdbc.Driver";
			Class.forName(mysqlDriver);
			
			String connString = "jdbc:mysql://localhost/fundatec?user=root&password=pass";
			Connection conn = DriverManager.getConnection(connString);
			
			Statement statement = conn.createStatement();

			// Nossa query
						
			String query = "insert into itens (id, nome) values (?)";
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			preparedStmt.setString(12, "Capa chuva");
			preparedStmt.execute();
			conn.close();
			
			// -------------------------------------------------------------------------------
			
            query = "insert into itens (id, nome, preco) values (id, nome, preco)";
			
			String nome = "Capa de chuva";
			int id = 11;
			float preco = 49;

			statement.execute(query);
			
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public List<Item> listAll() {
		List<Item> itens = new ArrayList<Item>();

		try {
			// Carrega driver do MySQL (cada banco tem o seu driver)
			
			String mysqlDriver = "com.mysql.cj.jdbc.Driver";
			Class.forName(mysqlDriver);

			// Cria uma conexão com o banco de dados, passando o nome
			// do banco, usuário e senha
			
			String connString = "jdbc:mysql://localhost/estoque?user=root&password=";
			Connection conn = DriverManager.getConnection(connString);

			// Statements permitem executar queries (SQL) no banco
			
			Statement statement = conn.createStatement();

			// Nossa query
			
			String query = "SELECT * FROM itens ORDER BY id";

			// Roda a query e pega o retorno
			
			ResultSet resultSet = statement.executeQuery(query);

			// Itera no resultado, imprimindo os valores
			
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String nome = resultSet.getString("nome");
				float preco = resultSet.getFloat("preco");

				Item item = new Item(id, nome, preco);
				itens.add(item);
			}

			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return itens;
	}

	public void delete(int id) {
		try {
			
			String mysqlDriver = "com.mysql.cj.jdbc.Driver";
			Class.forName(mysqlDriver);

			String connString = "jdbc:mysql://localhost/fundatec?user=root&password=pass";
			Connection conn = DriverManager.getConnection(connString);

			Statement statement = conn.createStatement();

			// Nossa query
			
			String query = "delete from itens where id = " + id;

			statement.execute(query);
			
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	public void update(Item item) {
		try {
			
			String mysqlDriver = "com.mysql.cj.jdbc.Driver";
			Class.forName(mysqlDriver);

			String connString = "jdbc:mysql://localhost/fundatec?user=root&password=pass";
			Connection conn = DriverManager.getConnection(connString);

			Statement statement = conn.createStatement();

			// Nossa query
			
			String query = "update itens set nome = ?, preco = ? where id = ?";
			String nome = item.getNome();
			float preco = item.getPreco();
			int id = item.getId();

			statement.execute(query);
			
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}		
		

	}

}
