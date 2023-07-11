package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import entity.RequestBook;
import entity.Transaction;
import util.DBconnection;

public class Requestdaoimpl implements Requestdao {
	Connection conn = null;
	Statement stmt = null;
	 ResultSet resultSet = null;
    PreparedStatement preparedstatement =null;

	@Override
	public ArrayList<RequestBook> requestlist(String requesteduser) {
	     
		return null;
	}

	@Override
	public boolean addrequest(RequestBook r) {
		boolean flag  =false;
	      try {
	    	  String sql1 = "select ownerid from book_exchange.booklist where title='"+r.getTitle()+"'";
	    	  System.out.println(r.getDate());
		  String postowner="";
	    	  conn=    DBconnection.openConnection();
		  stmt = conn.createStatement();
		  resultSet = stmt.executeQuery(sql1);
		  while(resultSet.next()) {
			  postowner = resultSet.getString("ownerid");
		  }
		  
		  //String sql = "INSERT INTO `book_exchange`.`requests` ( `requesteduser`, `ownerid`, `date`, `place`, `title`, `markasdone`) VALUES ('"+r.getRequesteduser()+"',postowner,'"+r.getDate()+"','"+r.getPlace()+"','"+r.getTitle()+"','"+r.getMarkasdone()+"')";
		  String sql = "INSERT INTO `book_exchange`.`requests` ( `requesteduser`, `ownerid`, `date`, `place`, `title`, `markasdone`,`duration`) VALUES (?,?,?,?,?,?,?)";
		  preparedstatement = conn.prepareStatement(sql);
		  preparedstatement.setString(1, r.getRequesteduser());
          preparedstatement.setString(2, postowner);
          preparedstatement.setString(3, r.getDate());
          preparedstatement.setString(4, r.getPlace());
          preparedstatement.setString(5, r.getTitle());
          preparedstatement.setString(6, r.getMarkasdone());
          preparedstatement.setString(7, r.getDuration());
		  preparedstatement.executeUpdate();
		  flag =true;
	  
	      }catch(SQLException e) {
	    	  e.printStackTrace();
	      }
		return flag;
	}

	@Override
	public boolean deleterequest(int id) {
		boolean flag = false;
		 try {
			 String sql ="DELETE FROM book_exchange.requests WHERE id = '"+id+"' ";
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
	public ArrayList<RequestBook> myrequests(String userid) {
		ArrayList<RequestBook> list = null;
		RequestBook r=null;
		try {
			list = new ArrayList<>();
			conn = DBconnection.openConnection();
			stmt = conn.createStatement();
			String sql= "select * from book_exchange.requests where requesteduser='"+userid+"'and markasdone='1'";  
				 
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
	public ArrayList<RequestBook> acceptrequests(String userid) {
		ArrayList<RequestBook> list = null;
		RequestBook r=null;
		try {
			list = new ArrayList<>();
			conn = DBconnection.openConnection();
			stmt = conn.createStatement();
			String sql= "select * from book_exchange.requests where (ownerid='"+userid+"'and markasdone='1')";  
				 
			resultSet = stmt.executeQuery(sql);
			while(resultSet.next()) {
			   r = new  RequestBook();
			   r.setTitle(resultSet.getString("title"));
			   r.setId(resultSet.getInt("id"));
			   r.setOwnerid(resultSet.getString("ownerid"));
			   r.setRequesteduser(resultSet.getString("requesteduser"));
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
	public boolean acceptrequest(int id) {
		
		boolean b=false;
		try
		{
			conn = DBconnection.openConnection();
			
			String sql = "UPDATE `book_exchange`.`requests` SET `markasdone` = ? WHERE (`id` = ?);";
			preparedstatement = conn.prepareStatement(sql);
            preparedstatement.setString(1, "2");
            preparedstatement.setInt(2, id);

            preparedstatement.executeUpdate();
            String sql1 ="select * from book_exchange.requests where (id=?)";
            
            preparedstatement =conn.prepareStatement(sql1);
            preparedstatement.setInt(1, id);
            resultSet = preparedstatement.executeQuery();
            Transaction t=null;
			while(resultSet.next()) {
			   t = new  Transaction();
			   t.setGivenby(resultSet.getString("ownerid"));
			   t.setReturnduration(resultSet.getString("duration"));
			   t.setDatetaken(resultSet.getString("date"));
			   t.setTakenby(resultSet.getString("requesteduser"));
			   t.setTitle(resultSet.getString("title"));
			   
			}
			String sql2 ="INSERT INTO `book_exchange`.`transactions` (`datetaken`, `givenby`, `takenby`, `title`, `returnduration`) VALUES (?,?,?,?,?);";
			preparedstatement = conn.prepareStatement(sql2);
            preparedstatement.setString(1, t.getDatetaken());
            preparedstatement.setString(2, t.getGivenby());
            preparedstatement.setString(3, t.getTakenby());
            preparedstatement.setString(4, t.getTitle());
            preparedstatement.setString(5, t.getReturnduration());

            preparedstatement.executeUpdate();
			
            
            String sql3 = "update book_exchange.booklist set bookstatus='"+t.getTakenby()+"' where (title='"+t.getTitle()+"')";
            preparedstatement = conn.prepareStatement(sql3);
            preparedstatement.executeUpdate();
            
            
            b = true;
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return b;
	}

	@Override
	public boolean rejectrequest(int id) {
		boolean b=false;
		try
		{
			conn = DBconnection.openConnection();
			
			String sql = "UPDATE `book_exchange`.`requests` SET `markasdone` = ? WHERE (`id` = ?);";
			preparedstatement = conn.prepareStatement(sql);
            preparedstatement.setString(1, "0");
            preparedstatement.setInt(2, id);

            preparedstatement.executeUpdate();
            b = true;
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return b;
	}

	@Override
	public boolean returnbook(int id) {
		
		boolean b=false;
		try
		{
			conn = DBconnection.openConnection();
			
			String sql = "UPDATE `book_exchange`.`requests` SET `markasdone` = ? WHERE (`id` = ?);";
			preparedstatement = conn.prepareStatement(sql);
            preparedstatement.setString(1, "0");
            preparedstatement.setInt(2, id);

            preparedstatement.executeUpdate();
            String sql1 ="select * from book_exchange.requests where (id=?)";
            
            preparedstatement =conn.prepareStatement(sql1);
            preparedstatement.setInt(1, id);
            resultSet = preparedstatement.executeQuery();
            String title=null;
			while(resultSet.next()) {
			   title=resultSet.getString("title");
			}
			String sql3 = "update book_exchange.booklist set bookstatus='"+null+"' where (title='"+title+"')";
            preparedstatement = conn.prepareStatement(sql3);
            preparedstatement.executeUpdate();
            
            b = true;
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return b;
	}
	
	

}
