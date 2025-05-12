/*
 * Dado tabela populada de acordo Cenário 1
Quando faço um insert com um usuário não cadastrado
Então valido que o usuário foi cadastrado
 */

package main.java;

import org.junit.*;
import java.sql.*;

public class TestAddUser {

	Connection conn;

	@Before
	public void conectarBanco() throws Exception {
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/banco_teste_automacao", "root01", "root");
	}

	@Test
	public void inserirNovoUsuarioEValidar() throws Exception {

		String id = "23423537";
		String nome = "Anakin Skywalker";
		String email = "skywalker@anakin.com";
		String username = "skywalker";
		String password = "anakin123";

		String sqlInsert = "INSERT IGNORE INTO usuarios (id, nome, email, username, password) VALUES (?, ?, ?, ?, ?)";
		PreparedStatement ps = conn.prepareStatement(sqlInsert);
		ps.setString(1, id);
		ps.setString(2, nome);
		ps.setString(3, email);
		ps.setString(4, username);
		ps.setString(5, password);
		ps.executeUpdate();
		ps.close();

		String sqlSelect = "SELECT * FROM usuarios WHERE id = ?";
		PreparedStatement psCheck = conn.prepareStatement(sqlSelect);
		psCheck.setString(1, id);
		ResultSet rs = psCheck.executeQuery();

		Assert.assertTrue("Usuário deve existir no banco de dados", rs.next());

		rs.close();
		psCheck.close();
	}

	@After
	public void fecharConexao() throws Exception {
		if (conn != null && !conn.isClosed()) {
			conn.close();
		}
	}
}
