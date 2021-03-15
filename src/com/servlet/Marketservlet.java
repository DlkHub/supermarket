package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pojo.Product;
import com.service.Productservice;
import com.service.ProductserviceImp;
import com.service.Userservice;
import com.service.UserserviceImp;

import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class Marketservlet
 */
@WebServlet("/Marketservlet")
public class Marketservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Marketservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("进入servlet");
		String method = request.getParameter("method");
		System.out.println(method);
		if(method != null && method.equals("insert")){
			this.Adddo(request, response);
		}else if(method != null && method.equals("delete")){
			this.Deletedo(request,response);
		}else if (method != null && method.equals("product")) {
			this.productdo(request, response);
		}else if (method != null && method.equals("pageproduct")) {
			this.pageproductdo(request, response);
		}else if (method != null && method.equals("sousuo")) {
			this.sousuodo(request, response);
		}
}
		private void Adddo(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
			System.out.println("开始添加数据");
			String Username = request.getParameter("username");
			String Mingchen = request.getParameter("mingchen");
				 String danjia = request.getParameter("danjia");
				 int Danjia = Integer.parseInt(danjia);
				 String shuliang = request.getParameter("shuliang");
				 int Shuliang = Integer.parseInt(shuliang);
				 String zonge = request.getParameter("zonge");
				 int Zonge = Integer.parseInt(zonge);
				 System.out.println(Mingchen);
				 System.out.println(Danjia);
				 System.out.println(Shuliang);
				 System.out.println(Zonge);
				 Product product=new Product();
				 product.setUsername(Username);
				 product.setMingchen(Mingchen);
	            product.setDanjia(Danjia);
	            product.setShuliang(Shuliang);
	            product.setZonge(Zonge);
	            Productservice productservice=new ProductserviceImp();
                productservice.Addproduct(product);
	    }
		private void Deletedo(HttpServletRequest request, HttpServletResponse response) {
			// TODO Auto-generated method stub
			System.out.println("开始删除数据");
			String Mingchen = request.getParameter("mingchen");
			Productservice productservice=new ProductserviceImp();
			productservice.Deleteproduct(Mingchen);
		}
		private void productdo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
			// TODO Auto-generated method stub
			request.setCharacterEncoding("utf-8");  //这里不设置编码会有乱码
            response.setContentType("text/html;charset=utf-8");
            response.setHeader("Cache-Control", "no-cache");
			ArrayList<Product> arrayList;
			JSONArray jsonArray;
			String Username=request.getParameter("username");
			String pagecount =request.getParameter("pagecount");
			int Pagecount = Integer.parseInt(pagecount);
			Productservice productservice=new ProductserviceImp();
			arrayList=productservice.Getproduct(Username,Pagecount);
			jsonArray = JSONArray.fromObject(arrayList);
			 System.out.println(jsonArray.toString());
			 PrintWriter out;
				try {
					out = response.getWriter();
					out.print(jsonArray);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}
		private void pageproductdo(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
			// TODO Auto-generated method stub
			request.setCharacterEncoding("utf-8");  //这里不设置编码会有乱码
            response.setContentType("text/html;charset=utf-8");
            response.setHeader("Cache-Control", "no-cache");
			ArrayList<Product> arrayList;
			JSONArray jsonArray;
			String Username=request.getParameter("username");
			String pagecount =request.getParameter("pagecount");
			int Pagecount = Integer.parseInt(pagecount);
			String pagevalue =request.getParameter("pagevalue");
			int Pagevalue = Integer.parseInt(pagevalue);
			Productservice productservice=new ProductserviceImp();
			arrayList=productservice.pageGetproduct(Username,Pagecount,Pagevalue);
			 jsonArray = JSONArray.fromObject(arrayList);
			 System.out.println(jsonArray.toString());
			 PrintWriter out;
				try {
					out = response.getWriter();
					out.print(jsonArray);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}
		private void sousuodo(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
			// TODO Auto-generated method stub
			request.setCharacterEncoding("utf-8");  //这里不设置编码会有乱码
            response.setContentType("text/html;charset=utf-8");
            response.setHeader("Cache-Control", "no-cache");
			ArrayList<Product> arrayList;
			JSONArray jsonArray;
			String Username=request.getParameter("username");
			String Ssmingcheng=request.getParameter("ssmingcheng");
			Productservice productservice=new ProductserviceImp();
			arrayList=productservice.Sousuoproduct(Username, Ssmingcheng);
			jsonArray = JSONArray.fromObject(arrayList);
			 System.out.println(jsonArray.toString());
			 PrintWriter out;
				try {
					out = response.getWriter();
					out.print(jsonArray);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
}