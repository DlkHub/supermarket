package com.dao;

import java.util.ArrayList;

import com.pojo.User;

public interface Userdao {
  public void Add(User user);
  public ArrayList<User> Getuserlist();
  
}
