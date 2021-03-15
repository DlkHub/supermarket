package com.service;

import java.util.ArrayList;
import java.util.Iterator;

import com.dao.Userdao;
import com.dao.UserdaoImp;
import com.pojo.User;

public class UserserviceImp implements Userservice{

	@Override
	public void Useradd(User user) {
		// TODO Auto-generated method stub
		Userdao userdao =new UserdaoImp();
		userdao.Add(user);
	}

	@Override
	public int Userverify(User user) {
		// TODO Auto-generated method stub
		ArrayList<User> userlist;
		Userdao userdao =new UserdaoImp();
		userlist=userdao.Getuserlist();
		for (Iterator<User> iterator = userlist.iterator(); iterator.hasNext();) {
			User user2 = iterator.next();
			if(user.getUsername().equals(user2.getUsername())) {
				if (user.getPassword().equals(user2.getPassword())) {
					 return 1;
				}
				else {
					return 0;
				}
			}
			
		}
		return -1;
	}
  
}
