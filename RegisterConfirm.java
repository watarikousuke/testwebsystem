package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.ContactBean;

/**
 * Servlet implementation class RegisterConfirm
 */
@WebServlet("/RegisterConfirm")
public class RegisterConfirm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterConfirm() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());

		//文字コード設定
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		//requestオブジェクトからパラメータを取得（名前、電話番号、アドレスに書き換え）
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String date = request.getParameter("date");

		//エラーチェック
		ArrayList<String> errorList = new ArrayList<String>();
		if (name.isBlank()) {
			errorList.add("名前が入力されていません");
		}
		if (phone.isBlank()) {
			errorList.add("電話番号が入力されていません");
		if (email.isBlank()) {
			errorList.add("メールアドレスが入力されていません");
		}

		//エラーがある場合はページ転送
				if(errorList.size() != 0) {
					request.setAttribute("errorList", errorList);
					request.getRequestDispatcher("/WEB-INF/Register.jsp")
					.forward(request, response);
					return;
				}

		//コンソール表示
		System.out.println("名前：電話番号：アドレス");
		System.out.println(name + "：" + phone + "：" + email);

		//商品オブジェクトの生成
		ContactBean contactBean = new ContactBean(id, name, phone, email, date);

		//requestにセット
		// request.setAttribute("contactBean", contactBean);

		//sessionの取得
		HttpSession session = request.getSession();
		//sessionに商品オブジェクトをセット
		session.setAttribute("contactBean", contactBean);

		//ページの転送
		request.getRequestDispatcher("/WEB-INF/RegisterConfirm.jsp")
				.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		doGet(request, response);
	}

}
