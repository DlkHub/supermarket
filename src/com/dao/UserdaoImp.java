package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.pojo.User;

import BaseDao.Basedao;

public class UserdaoImp implements Userdao{

	@Override
	public void Add(User user) {
		// TODO Auto-generated method stub
		Connection connection=Basedao.getConnection();
		PreparedStatement stmt = null;
		if(null != connection){
			try {
				stmt = connection.prepareStatement(
		                  "insert into user(username,password) values(?,?)");
		         stmt.setString(1, user.getUsername());
		            stmt.setString(2, user.getPassword());
		            stmt.executeUpdate();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}finally {
			}
			
	            
	        } 
		}

	@Override
	public ArrayList<User> Getuserlist() {
		// TODO Auto-generated method stub
		ArrayList<User> arrayList=new ArrayList<User>();
		Connection connection=Basedao.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		if(null != connection){
			try {
				stmt = connection.prepareStatement(
				        " SELECT * from  user");
						rs = stmt.executeQuery(" SELECT * from  user"); 
				while(rs.next()){
					User user = new User();
					user.setUsername(rs.getString("username"));
					user.setPassword(rs.getString("password"));
					arrayList.add(user);
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

