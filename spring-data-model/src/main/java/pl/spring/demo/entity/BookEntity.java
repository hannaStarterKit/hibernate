package pl.spring.demo.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "BOOK")
//@Inheritance(strategy=InheritanceType.JOINED)
public class BookEntity implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(nullable = false, length = 50)
	private String title;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "BOOK_AUTHOR", joinColumns = {
			@JoinColumn(name = "BOOK_ID", nullable = false, updatable = false, referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "AUTHOR_ID", nullable = false, updatable = false, referencedColumnName = "id") })
	private Set<AuthorEntity> authors = new HashSet<>();
	@ManyToOne
	@JoinColumn(name = "library_id")
	private LibraryEntity library;

	// for hibernate
	protected BookEntity() {
	}

	public BookEntity(Long id, String title, LibraryEntity library) {
		this.id = id;
		this.title = title;
		this.library = library;
	}
	
	public LibraryEntity getLibrary() {
		return library;
	}
	
	public void setLibrary(LibraryEntity library) {
		this.library = library;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Set<AuthorEntity> getAuthors() {
		return authors;
	}

	public void setAuthors(Set<AuthorEntity> authors) {
		this.authors = authors;
	}
}
