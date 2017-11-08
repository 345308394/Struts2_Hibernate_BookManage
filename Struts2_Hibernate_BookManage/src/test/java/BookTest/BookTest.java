package BookTest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import entity.Book;

public class BookTest {
	@Test
	public void testBook()
	{
		Book book=new Book();
		book.setBookname("软件工程");
		book.setBookauthor("王兆信");
		book.setBookprice(11.0);
		
		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		session.save(book);
		session.getTransaction().commit();
		session.close();
		sf.close();
	}
}
