/*
 * Dado tabela populada de acordo Cenário 1
Quando faço um delete em um usuário
Então valido que o usuário não existe na tabela
 */

package main.java;

import org.junit.jupiter.api.Test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static org.junit.jupiter.api.Assertions.*;

public class TestRemoveUser {

	String idDoUsuario = "23423532";

	public Connection conectarBanco() throws Exception {
		String url = "jdbc:mysql://localhost:3306/banco_teste_automacao";
		String usuario = "root01";
		String senha = "root";
		return DriverManager.getConnection(url, usuario, senha);
	}

	@Test
	public void deletarUsuario() throws Exception {
		Connection conn = conectarBanco();
		String sql = "DELETE FROM usuarios WHERE id = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, "23423537");
		int linhasAfetadas = stmt.executeUpdate();
		assertTrue(linhasAfetadas > 0, "Usuário apagado da tabela!");
		stmt.close();
		conn.close();
	}

	@Test
	public void verificarUsuarioDeletado() throws Exception {
		Connection conn = conectarBanco();
		String sql = "SELECT * FROM usuarios WHERE id = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, idDoUsuario);
		ResultSet resultado = stmt.executeQuery();
		assertFalse(resultado.next(), "Usuário não existe mais na tabela!");
		resultado.close();
		stmt.close();
		conn.close();
	}
}
