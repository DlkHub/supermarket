package com.service;

import com.pojo.Product;

import java.util.ArrayList;

public interface Productservice {

    public void Addproduct(Product product);

    public void Deleteproduct(String Mingchen);

    public ArrayList<Product> Getproduct(String Username, int Pagecount);

    public ArrayList<Product> pageGetproduct(String Username, int Pagecount, int Pagevalue);

    public ArrayList<Product> Sousuoproduct(String Username, String Ssmingcheng);
}

