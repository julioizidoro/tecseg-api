package br.com.tecsegapi.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.stereotype.Service;

@Service
public class ConectionFactory {
	
	public static Connection getConexao() {
		Connection conexao = null;
		try {
			conexao = DriverManager.getConnection("jdbc:mysql://database-1.c1bpjmrvhc7i.us-east-1.rds.amazonaws.com:3306/tecseg", "root", "20SimpleS78");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conexao;
	}

}
