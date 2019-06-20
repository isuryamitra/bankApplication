package com.ibm.sf.ui;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.ibm.sf.service.CustomerService;
import com.ibm.sf.service.CustomerServiceImpl;
import com.ibm.sf.service.exception.BankException;

/**
 * Servlet implementation class Transfer
 */
@WebServlet("/transfer")
public class Transfer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CustomerService service=new CustomerServiceImpl();
	private Logger daoLogger=Logger.getLogger(Transfer.class);
     
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Transfer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		
		System.out.println("transfer servlet");
		// TODO Auto-generated method stub
		/*
		 * response.getWriter().append("Served at: ").append(request.getContextPath());
		
			/* populatePreparedStatement(user,preparedStatement); */
			try {
				System.out.println("saf");
			String name=request.getParameter("name");
			String accno=request.getParameter("accno");
			String ifsc=request.getParameter("ifsc");
			System.out.println(name+accno+ifsc);
			System.out.println(request.getParameter("amount"));
			Integer amount=Integer.parseInt(request.getParameter("amount"));
			Integer type=Integer.parseInt(request.getParameter("mode"));
			System.out.println("amount + type"+amount+", "+type);
			Date d=java.sql.Date.valueOf("2019-01-02");
			System.out.println("date "+d);
			Integer uid=(Integer) request.getSession().getAttribute("uid");
			System.out.println(uid);
			System.out.println(name+accno+ifsc+amount);
			String remarks=name+","+accno;
			/*
			 * System.out.println(request.getParameter("amount") +
			 * "\n"+request.getParameter("mode") + "\n"+request.getParameter("name") +
			 * "\n"+request.getParameter("accno"));
			 */
			
			if(service.fundsTransfer(type, amount, uid, d, remarks) > 0) {
				request.getRequestDispatcher("index.jsp") .forward(request,response);
			}
			else {
				throw new BankException("Unable to transfer");
			}
		}catch(Exception e) {
			/*
			 * daoLogger.error(e.getMessage()); throw new BankException(e.getMessage());
			 */
			System.out.println(e);
		
		
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
