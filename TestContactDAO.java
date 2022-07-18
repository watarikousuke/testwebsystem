package test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.ItemBean;
import dao.ContactDAO;

public class TestContactDAO {

	public static void main(String[] args) {
		//連絡先DAO初期化
		ContactDAO contactDao = new ContactDAO();

		try (Connection conn = contactDao.getConnection();) {//DB接続

			/**ShainDAO.getShainのテスト*/
			//連絡先ID
			String contact_id = "0001";
			//連絡先ItemBeanの取得
			ItemBean itemBean = contactDao.getContact(conn, contact_id);

			//連絡先ItemBeanのテスト結果（値を取得し、表示する）
			System.out.println("名前：" + itemBean.getName());
			System.out.println("電話番号：" + itemBean.getPhone());
			System.out.println("メールアドレス：" + itemBean.getEmail());
			System.out.println("登録日：" + itemBean.getDate());

			/**ContactDAO.getAllContactのテスト*/
			ArrayList<ItemBean> contactList = new ArrayList<ItemBean> ();

			//全連絡先Beanの取得
			contactList = contactDao.getAllContact(conn);

			//全連絡先Beanのテスト結果（値を取得し、表示する）
			for (ItemBean contact : contactList) {
				System.out.println("------------------------------------------");
				System.out.println("名前：" + contact.getName());
				System.out.println("電話番号：" + contact.getPhone());
				System.out.println("メールアドレス：" + contact.getEmail());
				System.out.println("登録日：" + contact.getDate());
			}

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

}
