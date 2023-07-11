package com.my.dao;
import java.sql.*;
import java.util.ArrayList;

import com.my.entities.User;

import entity.Book;
import util.DBconnection;

public class UserDao {
	private Connection con;

	public UserDao(Connection con) {
		this.con = con;
	}
	
	public boolean saveUser(User user)
	{
		boolean b=false;
		try
		{
			String query="INSERT INTO `book_exchange`.`users` (`id`, `name`, `email`, `password`, `address`, `phone number`, `admin`) VALUES (?,?,?,?,?,?,?)";
			PreparedStatement pstmt=this.con.prepareStatement(query);
			pstmt.setString(1, user.getId());
			pstmt.setString(2, user.getName());
			pstmt.setString(3, user.getEmail());
			pstmt.setString(4, user.getPassword());
			pstmt.setString(5, user.getAddress());
			pstmt.setString(6, user.getPhonenumber());
			pstmt.setInt(7, (int)user.getAdmin());
			
			pstmt.executeUpdate();
			b=true;
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return b;
	}
	
	 public User getUserByUseridAndPassword(String userid, String password) {
	        User user = null;
	        try {

	            String query = "SELECT * FROM `book_exchange`.`users` WHERE id=? AND password=?";
	            PreparedStatement pstmt = this.con.prepareStatement(query);
	            pstmt.setString(1, userid);
	            pstmt.setString(2, password);

	            ResultSet set = pstmt.executeQuery();
	            if (set.next()) {
	                user = new User();
	                
	                user.setId(set.getString("id"));
	    			user.setName(set.getString("name"));
	    			user.setEmail(set.getString("email"));
	    			user.setPassword(set.getString("password"));
	    			user.setAddress(set.getString("address"));
	    			user.setDateTime(set.getTimestamp("rdate"));
	    			user.setAdmin((int)set.getInt("admin"));
	    			user.setPhonenumber(set.getString("phone number"));

	            }

	        } catch (Exception e) {
	        	System.out.println("UserDao has the Error");
	            e.printStackTrace();
	        }

	        return user;
	    }
	 
	 public boolean changepassword(String userid, String password)
	 {
		 boolean b=false;
			try
			{
				String query = "UPDATE `book_exchange`.`users` SET `password` = ? WHERE (`id` = ?);";
	            PreparedStatement p = con.prepareStatement(query);
	            p.setString(1, password);
	            p.setString(2, userid);

	            p.executeUpdate();
	            b = true;
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return b;
	 }
	 
	 public boolean DeleteUser(String userid)
	 {
		 boolean b=false;
			try
			{
				
				String query = "DELETE FROM `book_exchange`.`users` WHERE (`id` = ?);";
	            PreparedStatement p = con.prepareStatement(query);
	            p.setString(1, userid);

	            p.executeUpdate();
	            b = true;
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return b;
	 }

	public ArrayList<User> getOtherUsers(String userid) {
		ArrayList<User> list = null;
		User user=null;
		try {
			list = new ArrayList<User>();
			String sql= "select * from book_exchange.users";  
			PreparedStatement pstmt = con.prepareStatement(sql);	 
			ResultSet resultset = pstmt.executeQuery();
			System.out.println(resultset);
			while(resultset.next()) {
			   user = new  User();
			   user.setId(resultset.getString("id"));
	   			user.setName(resultset.getString("name"));
	   			user.setEmail(resultset.getString("email"));
	   			user.setPassword(resultset.getString("password"));
				list.add(user);
				
			}
		/*	for(DisplayPost post:list) {
		*		sql = "select id from images where owner_id='"+post.getMail()+"' and title ='"+post.getTitle()+"'";
		**		resultSet= statement.executeQuery(sql);
		*		resultSet.next();
		*		post.setId(resultSet.getInt("id"));
		*	}*/
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	
	
}
