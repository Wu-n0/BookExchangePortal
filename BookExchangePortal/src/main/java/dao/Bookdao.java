package dao;

import java.util.ArrayList;

import entity.Book;
import entity.RequestBook;
//import entity.Displaybook;
import entity.Transaction;

public interface Bookdao {
    ArrayList<Book> get(String userid);
    boolean save(Book b);
    boolean delete(String title);
    ArrayList<Book> getallbooks(String query);
	ArrayList<RequestBook> borrowedbook(String userid);
	ArrayList<Transaction> showalltransactions(String query);
}
