/*
 * Dado tabela populada de acordo Cenário 1Quando faço um insert com usuários existente na tabela
Então valido que a tabela não deixa eu fazer o insert
 */

package main.java;

import org.junit.jupiter.api.Test;
import java.sql.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddUserExistent {

	@Test
	public void UsuarioExistente() {
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/banco_teste_automacao", "root01",
					"root");
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT COUNT(*) FROM usuarios");
			rs.next();
			int totalAntes = rs.getInt(1);
			String sql = "INSERT IGNORE INTO usuarios (id, nome, email, username, password) VALUES (?, ?, ?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "23423537");
			ps.setString(2, "Anakin Skywalker");
			ps.setString(3, "skywalker@anakin.com");
			ps.setString(4, "skywalker");
			ps.setString(5, "anakin123");
			ps.executeUpdate();
			rs = stmt.executeQuery("SELECT COUNT(*) FROM usuarios");
			rs.next();

			int totalDepois = rs.getInt(1);
			assertEquals(totalAntes, totalDepois);

			ps.close();
			stmt.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
