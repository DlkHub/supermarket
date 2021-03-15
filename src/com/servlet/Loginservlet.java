package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pojo.User;
import com.service.Userservice;
import com.service.UserserviceImp;

/**
 * Servlet implementation class Loginservlet
 */
@WebServlet("/Loginservlet")
public class Loginservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Loginservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int m=0;
		String Username=request.getParameter("username");
		 String Password=request.getParameter("password");
		 System.out.println(Username);
		 System.out.println(Password);
		 User user=new User();
		 user.setUsername(Username);
		 user.setPassword(Password);
		 Userservice userservice =new UserserviceImp();
		 m=userservice.Userverify(user);
		request.setAttribute("m", m);
		request.setAttribute("username", Username);
		 try {
				if (m==1) {
					System.out.print("进入管理界面");
				request.getRequestDispatcher("/WEB-INF/manager.jsp").forward(request, response);
				}else {
				request.getRequestDispatcher("login.jsp").forward(request, response);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
