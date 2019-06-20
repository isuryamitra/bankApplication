package com.ibm.sf.ui;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ibm.sf.service.CustomerService;
import com.ibm.sf.service.CustomerServiceImpl;
import com.ibm.sf.service.exception.BankException;

/**
 * Servlet implementation class GetBalance
 */
@WebServlet("/GetBalance")
public class GetBalance extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CustomerService service=new CustomerServiceImpl();
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	try {
		HttpSession session=request.getSession();
		String uid=(String)session.getAttribute("uid");
		request.setAttribute("balance",service.getCurrentAmount(uid));
		request.getRequestDispatcher("views/viewbalance.jsp");
	} catch (BankException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
