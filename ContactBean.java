package beans;

import java.io.Serializable;

public class ContactBean implements Serializable {

	private String id; //ID
	private String name; //名前
	private String phone; //電話番号
	private String email; //アドレス
	private String date; //登録日

	//引数無しコンストラクタ(引数有りを作った場合は作る)
	public ContactBean() {
	}

	//引数有りコンストラクタ(ID、名前、価格)
	public ContactBean(String id, String name, String phone, String email, String date) {
		this.id =id;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.date = date;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
