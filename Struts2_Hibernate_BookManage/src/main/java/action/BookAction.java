package action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;

import service.BookDao;
import serviceImpl.BookDaoImpl;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import entity.Book;





public class BookAction extends ActionSupport implements ServletRequestAware{
	private Book book;
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HttpServletRequest request;
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request=request;
	}
	public String  AllBooks()
	{	HttpSession session= request.getSession();
		BookDao bdao = new BookDaoImpl();
		List<Book> bookList = bdao.findAllBooks();
		session.setAttribute("booklist", bookList);
		return "success";
	}
	public String BookAddUi()
	{
		return "success";
	}
	public String AddBook()
	{	BookDao bdao = new BookDaoImpl();
		bdao.addBooks(book);
		return "AllBook";
	}
	public String DeleteBook()
	{
		BookDao bdao=new BookDaoImpl();
		bdao.deleteBooks(book.getBookid());
		return "DeleteBook";
	}
	public String BookDetail()
	{
		BookDao bdao = new BookDaoImpl();
		HttpSession session = request.getSession();
		Book book1 = bdao.findBooksById(book.getBookid());
		System.out.println(book1);
		session.setAttribute("book", book1);
//		System.out.println(book);
		return "BookDetail";
	}
	public String UpdateBook()
	{
		BookDao bdao = new BookDaoImpl();
		bdao.updateBooks(book);
		return "BookUpdate";
	}
	

	
}
