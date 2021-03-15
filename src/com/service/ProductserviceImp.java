package com.service;

import java.util.ArrayList;

import com.dao.Productdao;
import com.dao.ProductdaoImp;
import com.pojo.Product;

public class ProductserviceImp implements Productservice{
	@Override
	public void Addproduct(Product product) {
		// TODO Auto-generated method stub
		Productdao  productdao=new ProductdaoImp();
	      productdao.Add(product);
	}

	@Override
	public void Deleteproduct(String Mingchen) {
		// TODO Auto-generated method stub
		Productdao  productdao=new ProductdaoImp();
	      productdao.Delete(Mingchen);
	}

	@Override
	public ArrayList<Product> Getproduct(String Username,int Pagecount) {
		// TODO Auto-generated method stub
		Productdao  productdao=new ProductdaoImp();
		return productdao.Get(Username,Pagecount);
		
	}

	@Override
	public ArrayList<Product> pageGetproduct(String Username, int Pagecount,int Pagevalue) {
		// TODO Auto-generated method stub
		Productdao  productdao=new ProductdaoImp();
		return productdao.pageGet(Username,Pagecount, Pagevalue);
	}
	public ArrayList<Product> Sousuoproduct(String Username,String Ssmingcheng){
		Productdao  productdao=new ProductdaoImp();
		return productdao.sousuo(Username, Ssmingcheng);
	}
       
}
