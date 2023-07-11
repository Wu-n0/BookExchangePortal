package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import entity.Book;
import entity.RequestBook;
import entity.Transaction;
import util.DBconnection;

public class Bookdaoimpl implements Bookdao{
	Connection conn = null;
	Statement stmt = null;
	 ResultSet resultSet = null;
    PreparedStatement preparedstatement =null;
	public ArrayList<Book>  get(String userid){
		ArrayList<Book> list =null;
		Book book=null;
		try {
			list = new ArrayList<Book>() ;
			String sql = "select * from book_exchange.booklist where (ownerid='"+userid+"')";
			conn =DBconnection.openConnection();
			stmt = conn.createStatement();
			resultSet =stmt.executeQuery(sql);
			while(resultSet.next()) {
				book = new Book();
				book.setTitle(resultSet.getString("title"));
				book.setAuthor(resultSet.getString("author"));
				 
				book.setPublisher(resultSet.getString("publisher"));
				 
				 
				book.setEdition(resultSet.getString("Edition"));
				book.setYear(resultSet.getString("year"));
				list.add(book);
			}
			
				
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public boolean save(Book b) {
	      boolean flag  =false;
	      try {
	    	  String sql = "INSERT INTO book_exchange.booklist(title,author,publisher,edition,year,ownerid,imagepath) VALUES ('"+b.getTitle()+"','"+b.getAuthor()+"','"+b.getPublisher()+"','"+b.getEdition()+"','"+b.getYear()+"','"+b.getOwnerid()+"','"+b.getImagepath()+"')";
	  conn=    DBconnection.openConnection();
	  preparedstatement = conn.prepareStatement(sql);
	  preparedstatement.executeUpdate();
	  flag =true;
	  
	      }catch(SQLException e) {
	    	  e.printStackTrace();
	      }
		return flag;
	}

	@Override
	public boolean delete(String title) {
		boolean flag = false;
		 try {
			 String sql ="DELETE FROM book_exchange.booklist WHERE title = '"+title+"' ";
			 conn=    DBconnection.openConnection();
			  preparedstatement = conn.prepareStatement(sql);
		 
			  
			  preparedstatement.executeUpdate();
			  flag =true;
		 }catch(SQLException e) {
			 e.printStackTrace();
		 }
		return flag;
	}

	@Override
	public ArrayList<Book> getallbooks(String query) {
		 
		ArrayList<Book> list = null;
		Book b=null;
		try {
			list = new ArrayList<>();
			conn = DBconnection.openConnection();
			stmt = conn.createStatement();
			String sql= "select * from book_exchange.booklist where   (title like '%"+query+"%' or author like '%"+query+"%' )";  
				 
			resultSet = stmt.executeQuery(sql);
			while(resultSet.next()) {
			   b = new  Book();
			   b.setTitle(resultSet.getString("title"));
				b.setAuthor(resultSet.getString("author"));
				 b.setOwnerid(resultSet.getString("ownerid"));
				b.setPublisher(resultSet.getString("publisher"));
				 
				 
				b.setEdition(resultSet.getString("Edition"));
				b.setYear(resultSet.getString("year"));
				b.setBookstatus(resultSet.getString("bookstatus"));
				b.setImagepath(resultSet.getString("imagepath"));
				list.add(b);
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

	@Override
	public ArrayList<RequestBook> borrowedbook(String userid) {
		ArrayList<RequestBook> list = null;
		RequestBook r=null;
		try {
			list = new ArrayList<>();
			conn = DBconnection.openConnection();
			stmt = conn.createStatement();
			String sql= "select * from book_exchange.requests where requesteduser='"+userid+"' and markasdone='2'";  
				 
			resultSet = stmt.executeQuery(sql);
			while(resultSet.next()) {
			   r = new  RequestBook();
			   r.setTitle(resultSet.getString("title"));
			   r.setId(resultSet.getInt("id"));
			   r.setOwnerid(resultSet.getString("ownerid"));
			   r.setDate(resultSet.getString("date"));
			   r.setPlace(resultSet.getString("place"));
			   r.setDuration(resultSet.getString("duration"));
			   list.add(r);
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

	@Override
	public ArrayList<Transaction> showalltransactions(String query) {
		ArrayList<Transaction> list = null;
		Transaction t=null;
		try {
			list = new ArrayList<Transaction>();
			conn = DBconnection.openConnection();
			stmt = conn.createStatement();
			String sql= "select * from book_exchange.transactions where title='"+query+"'";  
			//String sql= "select * from book_exchange.transactions";	 
			resultSet = stmt.executeQuery(sql);
			while(resultSet.next()) {
			   t = new  Transaction();
			   t.setGivenby(resultSet.getString("givenby"));
			   t.setReturnduration(resultSet.getString("returnduration"));
			   t.setDatetaken(resultSet.getString("datetaken"));
			   t.setTakenby(resultSet.getString("takenby"));
			   t.setTitle(resultSet.getString("title"));
			   list.add(t);
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
