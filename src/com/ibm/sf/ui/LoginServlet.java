package com.ibm.sf.ui;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import com.ibm.sf.service.CustomerService;
import com.ibm.sf.service.CustomerServiceImpl;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CustomerService service=new CustomerServiceImpl();
	private Logger daoLogger=Logger.getLogger(LoginServlet.class);
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		try {					
			String uid=request.getParameter("uid");
			String password=request.getParameter("password");
			System.out.println(uid +" , "+password);
		
			if(service.login(uid,password)) {
				/*out.println("<html><body><h1><font color='red'>");
				out.println("Welcome! "+username);
				out.println("</font></h1></body></html>");*/
				HttpSession session=request.getSession();
				session.setAttribute("uid", uid);
				/*
				 * out.println("<html><body><h1><font color='red'>");
				 * out.println("Welcome! "+uid); out.println("</font></h1></body></html>");
				 */
				//if(service.checkType(uid)==0) {
					
					  request.getRequestDispatcher("index.jsp") .forward(request,response);
					 
			}
				else{
			
				/*response.sendRedirect("http://localhost:9090/WebLoginApplication/login.html");*/
				out.println("<html><body><h1><font color='red'>");
				out.println("Invalid Credentials! Re-enter");
				out.println("</font></h1></body></html>");
				//request.getRequestDispatcher("login.js").include(request, response);
			}
			
		}catch(Exception e) {
			System.out.println(e);
			response.sendError(HttpServletResponse.SC_NOT_ACCEPTABLE,e.getMessage());
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
