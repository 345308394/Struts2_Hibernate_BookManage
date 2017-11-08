package service;

import java.util.List;

import entity.Book;

public interface BookDao {
	public void addBooks(Book book);
	public void deleteBooks(int bookid);
	public void updateBooks(Book book);
	public Book findBooksById(int bookid);
	public List<Book> findAllBooks();
}
