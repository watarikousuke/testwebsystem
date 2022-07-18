package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestJDBC {
	/**
	* JDBCデータベース接続テスト
	* @param args
	 * @throws SQLException
	 * @throws ClassNotFoundException
	*/
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		 //データベースdb1接続へのURL
		final String url = "jdbc:mysql://localhost/db1?characterEncoding=UTF-8";
		final String username = "user1"; //DBのユーザー
		final String password = "pass1"; //DBのパスワード
		Connection conn = null; //接続オブジェクト

		System.out.println("Start");
		try {
			conn = DriverManager.getConnection(url, username, password); //接続の確立
			System.out.println("接続成功！");
		} finally {
			conn.close(); //接続を閉じておく
		}
	}
}
