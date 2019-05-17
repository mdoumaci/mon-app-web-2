package ac.ma.insea.monappweb.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;


@Entity
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String isbn;
	private String publisher;
	
	@ManyToMany
	@JoinTable(name="author_book", joinColumns = @JoinColumn(name="book_id"), 
	inverseJoinColumns = @JoinColumn(name="author_id"))
	private Set<Author> authors = new HashSet<>();
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Book(String name, String isbn, String publisher) {
		super();
		this.name = name;
		this.isbn = isbn;
		this.publisher = publisher;
	}
	public Set<Author> getAuthors() {
		return authors;
	}
	public void setAuthors(Set<Author> authors) {
		this.authors = authors;
	}
	public Book(String name, String isbn, String publisher, Set<Author> authors) {
		super();
		this.name = name;
		this.isbn = isbn;
		this.publisher = publisher;
		this.authors = authors;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((authors == null) ? 0 : authors.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (authors == null) {
			if (other.authors != null)
				return false;
		} else if (!authors.equals(other.authors))
			return false;
		return true;
	}
	
	
	
		

}
