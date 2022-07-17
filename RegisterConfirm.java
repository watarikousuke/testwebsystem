package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.ItemBean;

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
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");

		//コンソール表示
		System.out.println("名前：電話番号：アドレス");
		System.out.println(name + "：" + phone + "：" + email);

		//商品オブジェクトの生成
		ItemBean itemBean = new ItemBean(name, phone, email);

		//requestにセット
		// request.setAttribute("itemBean", itemBean);

		//sessionの取得
		HttpSession session = request.getSession();
		//sessionに商品オブジェクトをセット
		session.setAttribute("itemBean", itemBean);

		//ページの転送
		request.getRequestDispatcher("/WEB-INF/RegisterConfirm.jsp")
				.forward(request, response);
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