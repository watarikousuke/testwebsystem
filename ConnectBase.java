package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectBase {
	//DBへの接続を開く
	public Connection getConnection() throws SQLException, ClassNotFoundException {
		final String url = "jdbc:mysql://localhost:3306/db1?characterEncoding=UTF-8";
		final String user_name = "user1";
		final String password = "pass1";
		Connection conn = null;
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection(url, user_name, password);
		return conn;
	}

	//DBへの接続を閉じる
	public void close(Connection conn)
			throws SQLException {
		if (conn != null) {
			conn.close();
		}
	}

}
