package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.pojo.Product;
import com.pojo.User;

import BaseDao.Basedao;

public class ProductdaoImp implements Productdao{

	@Override
	public void Add(Product product) {
		// TODO Auto-generated method stub
		Connection connection=Basedao.getConnection();
		PreparedStatement stmt = null;
		if(null != connection){
			try {
		            stmt = connection.prepareStatement(
			                  "insert into userproduct(username,商品名称,单价,数量,总额) values(?,?,?,?,?)");
		            stmt.setString(1, product.getUsername()); 
		            stmt.setString(2, product.getMingchen());
			            stmt.setInt(3, product.getDanjia());
			           stmt.setInt(4, product.getShuliang());
			           stmt.setInt(5, product.getZonge());
			            stmt.executeUpdate();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}finally {
			}
			
	            
	        } 
		}

	@Override
	public void Delete(String Mingchen) {
		// TODO Auto-generated method stub
		Connection connection=Basedao.getConnection();
		PreparedStatement stmt = null;
		if(null != connection){
			try {
				System.out.println(Mingchen);
				stmt = connection.prepareStatement(
		                  "delete from userproduct where 商品名称=?");	
				stmt.setString(1,Mingchen);
		            stmt.executeUpdate();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}finally {
				
			}
			
	            
	        } 
	}

	@Override
	public ArrayList<Product> Get(String Username,int Pagecount) {
		// TODO Auto-generated method stub
		ArrayList<Product> arrayList=new ArrayList<Product>();
		Connection connection=Basedao.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		if(null != connection){
			try {
				stmt = connection.prepareStatement(
				        " SELECT count(*) as rscount from  userproduct where username=?");
				stmt.setString(1,Username);
						rs = stmt.executeQuery(); 
						while(rs.next()){
							Product product =new Product();
							System.out.println(rs.getInt("rscount"));
							product.setShuliang(rs.getInt("rscount"));
							arrayList.add(product);
						}
					
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}finally {
			}
			
	            
	        } 
		
		if(null != connection){
			try {
				stmt = connection.prepareStatement(
				        " SELECT * from  userproduct where username=? limit ?,?");
				stmt.setString(1,Username);
				stmt.setInt(2,0);
				stmt.setInt(3,Pagecount);
						rs = stmt.executeQuery(); 
				while(rs.next()){
					Product product =new Product();
					product.setUsername(rs.getString("username"));
					product.setMingchen(rs.getString("商品名称"));
					product.setDanjia(rs.getInt("单价"));
					product.setShuliang(rs.getInt("数量"));
					product.setZonge(rs.getInt("总额"));
					arrayList.add(product);
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}finally {
			}
			
	            
	        } 
		
		return arrayList;
	}

	@Override
	public ArrayList<Product> pageGet(String Username, int Pagecount,int Pagevalue) {
		// TODO Auto-generated method stub
		int start=(Pagevalue-1)*Pagecount;
		ArrayList<Product> arrayList=new ArrayList<Product>();
		Connection connection=Basedao.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		if(null != connection){
			try {
				stmt = connection.prepareStatement(
				        " SELECT * from  userproduct where username=? limit ?,?");
				
				stmt.setString(1,Username);
				stmt.setInt(2,start);
				stmt.setInt(3,Pagecount);
						rs = stmt.executeQuery(); 
				while(rs.next()){
					Product product =new Product();
					product.setUsername(rs.getString("username"));
					product.setMingchen(rs.getString("商品名称"));
					product.setDanjia(rs.getInt("单价"));
					product.setShuliang(rs.getInt("数量"));
					product.setZonge(rs.getInt("总额"));
					arrayList.add(product);
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}finally {
			}
			
	            
	        } 
		
		return arrayList;
	}

	@Override
	public ArrayList<Product> sousuo(String Username, String Ssmingcheng) {
		// TODO Auto-generated method stub
		ArrayList<Product> arrayList=new ArrayList<Product>();
		Connection connection=Basedao.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		if(null != connection){
			try {
				stmt = connection.prepareStatement(
				        " SELECT * from  userproduct where username=?and 商品名称 like ? ");
				
				stmt.setString(1,Username);
				stmt.setString(2,"%" + Ssmingcheng + "%");
						rs = stmt.executeQuery(); 
				while(rs.next()){
					Product product =new Product();
					product.setUsername(rs.getString("username"));
					product.setMingchen(rs.getString("商品名称"));
					product.setDanjia(rs.getInt("单价"));
					product.setShuliang(rs.getInt("数量"));
					product.setZonge(rs.getInt("总额"));
					arrayList.add(product);
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}finally {
			}
			
	            
	        } 
		return arrayList;
	}

	}
	

