/*
 * Dado lista de clientes https://oururltest
Quando crio uma tabela no banco de dados
Então populo a tabela de acordo com o retorno da API
 */

package main.java;

import java.net.http.*;
import java.net.URI;
import java.sql.*;
import org.json.JSONArray;
import org.json.JSONObject;

public class ImportaClientes {
	public static void main(String[] args) {

		try {
			HttpClient client = HttpClient.newHttpClient();
			HttpRequest request = HttpRequest.newBuilder()
					.uri(URI.create("https://ourtesturl")).build();

			HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:0000/banco_teste_automacao", "000000",
					"0000");
			JSONArray clientes = new JSONArray(response.body());
			String inserirSQL = "INSERT IGNORE INTO usuarios (id, nome, email, username, password) VALUES (?, ?, ?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(inserirSQL);
			for (int i = 0; i < clientes.length(); i++) {
				JSONObject cli = clientes.getJSONObject(i);
				ps.setString(1, cli.getString("id"));
				ps.setString(2, cli.getString("name"));
				ps.setString(3, cli.getString("email"));
				ps.setString(4, cli.optString("userName"));
				ps.setString(5, cli.optString("Password"));
				ps.executeUpdate();
			}
			System.out.println("Clientes importados com sucesso!");
			ps.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
