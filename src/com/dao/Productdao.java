package com.dao;

import java.util.ArrayList;

import com.pojo.Product;

public interface Productdao {
	public   void Add(Product product);

	public void Delete(String Mingchen);
 
   public ArrayList<Product>Get(String Username, int Pagecount);
   
   public ArrayList<Product>pageGet(String Username, int Pagecount, int Pagevalue);
  
   public ArrayList<Product> sousuo(String Username, String Ssmingcheng);
}
