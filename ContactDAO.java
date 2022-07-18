package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.ItemBean;

public class ContactDAO extends ConnectBase {

	/**
	* 連絡先IDから連絡先(Item)Beanを取得
	* @param conn, contact_id　
	* @return int ItemBean
	* @throws SQLException
	*/
	public ItemBean getContact(Connection conn, String contact_id) throws SQLException {
		//連絡先Beanの初期化
		ItemBean itemBean = new ItemBean();

		//連絡先IDで取得するSQL(編集しうまく取得できた)
		final String sql = "select contact.id, contact.name, contact.phone, contact.email ,contact.date "
				+ "from contact_master contact where contact.id = ?";

		//SQL実行の準備
		try (PreparedStatement stmt = conn.prepareStatement(sql);) {
			stmt.setString(1, contact_id);

			//SQL実行
			try (ResultSet rs = stmt.executeQuery();) {

				//SQLで検索でいると、if文の中に入る
				if (rs.next()) {

					//一行目の値を取得
					String contact_name = rs.getString("contact.name");
					String contact_phone = rs.getString("contact.phone");
					String contact_email = rs.getString("contact.email");
					String contact_date = rs.getString("contact.date");

					//取得した値をItemBeanにセット
					itemBean.setId(contact_id);
					itemBean.setName(contact_name);
					itemBean.setPhone(contact_phone);
					itemBean.setEmail(contact_email);
					itemBean.setDate(contact_date);

				}

			}
		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
			System.out.println("VendorError: " + e.getErrorCode());
			e.printStackTrace();
			throw e;
		}

		return itemBean;
	}

	/**
	* 全連絡先を取得
	* @param con
	* @return shainList
	* @throws SQLException
	*/
	public ArrayList<ItemBean> getAllContact(Connection con) throws SQLException {
		//ArrayListの初期化
		ArrayList<ItemBean> shainList = new ArrayList<ItemBean>();

		//連絡先IDで取得するSQL(編集したがうまく取得できていない模様)
		final String sql = "select contact.id, contact.name, contact.phone, contact.email, contact.date"
				+ "from contact_master contact where contact.id";

		//SQL実行の準備
		try (PreparedStatement stmt = con.prepareStatement(sql);) {

			//SQL実行
			try (ResultSet rs = stmt.executeQuery();) {

				//取得した行数を繰り返す
				while (rs.next()) {

					//ItemBeanの初期化
					ItemBean itemBean = new ItemBean();

					//値を取得
					String contact_name = rs.getString("contact.name");
					String contact_phone = rs.getString("contact.phone");
					String contact_email = rs.getString("contact.email");
					String contact_date = rs.getString("contct.date");

					//取得した値をItemBeanにセット
					itemBean.setName(contact_name);
					itemBean.setPhone(contact_phone);
					itemBean.setEmail(contact_email);
					itemBean.setDate(contact_date);

					//リストにItemBeanの追加
					shainList.add(itemBean);

				}

			}
		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
			System.out.println("VendorError: " + e.getErrorCode());
			e.printStackTrace();
			throw e;
		}

		return shainList;
	}

}
