/**
 * 
 */
package pl.spring.demo.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * @author HSIENKIE
 *
 */

@Entity
@Table(name = "TITLE_AUTHOR_LIBRARY")
@NamedQueries({
		@NamedQuery(name = "BookSearchCriteria.findByTitleAuthorLibraryOrfindAll", query = "select book from BookSearchCriteria book where upper(book.libraryName)"
				+ "like concat('%', upper(:libraryName), '%') or upper(book.author) like concat('%', upper(:author), '%') or upper(book.title) like concat('%', upper(:title), '%')")})

public class BookSearchCriteria {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(nullable = false, length = 50)
	private String title;
	@Column(nullable = false, length = 100)
	private String author;

	@Column(name = "library_name", length = 50, nullable = false)
	private String libraryName;

	protected BookSearchCriteria() {
	}

	public BookSearchCriteria(String title, String author, String libraryName) {
		this.title = title;
		this.author = author;
		this.libraryName = libraryName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getLibraryName() {
		return libraryName;
	}

	public void setLibraryName(String libraryName) {
		this.libraryName = libraryName;
	}

}
