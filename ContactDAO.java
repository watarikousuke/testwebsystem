package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.ContactBean;

public class ContactDAO extends ConnectBase {

	/**
	* 連絡先IDから連絡先ContactBeanを取得
	* @param conn, contact_id　
	* @return int ContactBean
	* @throws SQLException
	*/
	public ContactBean getContact(Connection conn, String contact_id) throws SQLException {
		//連絡先Beanの初期化
		ContactBean contactBean = new ContactBean();

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
					contactBean.setId(contact_id);
					contactBean.setName(contact_name);
					contactBean.setPhone(contact_phone);
					contactBean.setEmail(contact_email);
					contactBean.setDate(contact_date);

				}

			}
		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
			System.out.println("VendorError: " + e.getErrorCode());
			e.printStackTrace();
			throw e;
		}

		return contactBean;
	}

	/**
	* 全連絡先を取得
	* @param con
	* @return contactList
	* @throws SQLException
	*/
	public ArrayList<ContactBean> getAllContact(Connection con) throws SQLException {
		//ArrayListの初期化
		ArrayList<ContactBean> contactList = new ArrayList<ContactBean>();

		//連絡先IDで取得するSQL(最初取得にうまくいかなかったが編集し成功)
		final String sql = "select *"
				+ "from contact_master contact";

		//SQL実行の準備
		try (PreparedStatement stmt = con.prepareStatement(sql);) {

			//SQL実行
			try (ResultSet rs = stmt.executeQuery();) {

				//取得した行数を繰り返す
				while (rs.next()) {

					//社員Beanの初期化
					ContactBean contactBean = new ContactBean();

					//値を取得
					String contact_name = rs.getString("contact.name");
					String contact_phone = rs.getString("contact.phone");
					String contact_email = rs.getString("contact.email");
					String contact_date = rs.getString("contact.date");

					//取得した値をContactBeanにセット
					contactBean.setName(contact_name);
					contactBean.setPhone(contact_phone);
					contactBean.setEmail(contact_email);
					contactBean.setDate(contact_date);

					//リストにContactBeanの追加
					contactList.add(contactBean);

				}

			}
		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
			System.out.println("VendorError: " + e.getErrorCode());
			e.printStackTrace();
			throw e;
		}

		return contactList;
	}

}
