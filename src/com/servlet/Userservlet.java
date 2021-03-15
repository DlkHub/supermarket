package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pojo.User;
import com.service.Userservice;
import com.service.UserserviceImp;

/**
 * Servlet implementation class Userservlet
 */
@WebServlet("/Userservlet")
public class Userservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Userservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub 
		String method = request.getParameter("method");
		System.out.println(method);
		if(method != null && method.equals("insert")){
			this.Adddo(request, response);
		}else if (method != null && method.equals("verify")) {
			this.verifydo(request, response);
		}
	}

	private void Adddo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		// TODO Auto-generated method stub
		 String Username=request.getParameter("username");
		 String Password=request.getParameter("password");
		 System.out.println(Username);
		 System.out.println(Password);
		 User user=new User();
		 user.setUsername(Username);
		 user.setPassword(Password);
		 Userservice userservice =new UserserviceImp();
		 userservice.Useradd(user);
	}
	private void verifydo(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
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
		 PrintWriter out;
		try {
			out = response.getWriter();
			out.print(m);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
