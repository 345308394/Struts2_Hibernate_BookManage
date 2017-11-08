package serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import db.MyHibernateSessionFactory;
import entity.Book;
import service.BookDao;

public class BookDaoImpl implements BookDao {
	Transaction tx = null;
	String hql = "";
	List<Book> bookList= new ArrayList<Book>();
	Book book = new Book();
	public void addBooks(Book book) {
		try
		{		
		Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
		tx=session.beginTransaction();
		session.save(book);
		session.getTransaction().commit();	
	}
		catch(Exception ex)
		{
			ex.printStackTrace();
			
		}
		finally
		{	
			if(tx!=null)
			{	
				tx=null;				
			}	
		}
	}

	public void deleteBooks(int bookid) {
		try
		{		
		Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
		tx=session.beginTransaction();
		hql="Delete FROM Book where bookid = ?";
		Query query = session.createQuery(hql);
		query.setInteger(0,bookid);
		query.executeUpdate();
		session.getTransaction().commit();	
	}
		catch(Exception ex)
		{
			ex.printStackTrace();
			
		}
		finally
		{	
			if(tx!=null)
			{	
				tx=null;				
			}	
		}
	}

	public void updateBooks(Book book) {
		// TODO Auto-generated method stub
		try
		{		
		Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
		tx=session.beginTransaction();
		hql="Update  Book book set book.bookname = ?, book.bookauthor = ?,book.bookprice = ? where book.bookid =?";
		Query query = session.createQuery(hql);
		query.setString(0,book.getBookname());
		query.setString(1,book.getBookauthor());
		query.setDouble(2,book.getBookprice());
		query.setInteger(3,book.getBookid());
		query.executeUpdate();
		session.getTransaction().commit();
		System.out.println(book.getBookid());
		System.out.println(book.getBookname());
		System.out.println(book.getBookauthor());
		System.out.println(book.getBookprice());
	}
		catch(Exception ex)
		{
			ex.printStackTrace();
			
		}
		finally
		{	
			if(tx!=null)
			{	
				tx=null;				
			}	
		}
	}

	public Book findBooksById(int bookid) {
		// TODO Auto-generated method stub
		Book oneBook = new Book();
		try
		{		
		Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
		tx=session.beginTransaction();
		hql="from Book where bookid = ?";
		Query query = session.createQuery(hql);
		query.setInteger(0,bookid);
		oneBook=  (Book) query.uniqueResult();
		session.getTransaction().commit();
		System.out.println(oneBook);
	}
		catch(Exception ex)
		{
			ex.printStackTrace();
			
		}
		finally
		{	
			if(tx!=null)
			{	
				tx=null;				
			}	
		}
		return oneBook;
	}

	public List<Book> findAllBooks() {
		// TODO Auto-generated method stub			
		try
		{
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx =session.beginTransaction();
			hql=" from Book";
			Query query = session.createQuery(hql);
			List<Book> list= query.list();
			tx.commit();
			if(list.size()>0)
			{
				for(Book books: list){
				Book book = new Book();
				book.setBookid(books.getBookid());
				book.setBookname(books.getBookname());
				book.setBookauthor(books.getBookauthor());
				book.setBookprice(books.getBookprice());
				bookList.add(book);	
			    }
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			
		}
		finally
		{	
			if(tx!=null)
			{	
				tx=null;				
			}		
		}
		return bookList;
	}

}
