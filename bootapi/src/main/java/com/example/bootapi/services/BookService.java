package com.example.bootapi.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.bootapi.entities.Book;

@Component
public class BookService {

	private static List<Book> booklist = new ArrayList<>();
	
	
	static {
		booklist.add(new Book(3,"Aman", "Java Porgramming"));
		booklist.add(new Book(4,"Bimal", "Database Administration"));
	}
	public List<Book> getAllBooks()
	{
		return booklist;
	}
	public Book appendBook(Book book) {
		booklist.add(book);
		return book;
	}
	
	public void deleteBookByID(int id)
	{
	   booklist.removeIf(e->e.getId()==id);
	}
	
	
	public void updateBookById(Book book, int id)
	{
		
		for(Book listElement: booklist)
		{
			if(listElement.getId()==id)
			{
				{
					listElement.setAuthor(book.getAuthor());
					listElement.setTitle(book.getTitle());	
			    }
			}
		}
		
//	    booklist.stream().map(b->{
//		    if(b.getId()==id)
//		    {
//		    	b.setAuthor("Vikash");
//		    	b.setTitle("Introduction to Algorithm");
//		    }
//	   })
	}
}
