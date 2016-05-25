/**
 * 
 */
package pl.spring.demo.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * @author HSIENKIE
 *
 */
// TODO b) Dodać encję LibraryEntity która będzie posiadała nazwę (pole
// wymagane, max długość w bazie 50 znaków)
// i relację do książek (biblioteka może mieć wiele książek, jedna książka
// należy do dokładnie jednej biblioteki,
// książka musi być przypisana do biblioteki)

@Entity
@Table(name = "LIBRARY")
public class LibraryEntity implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "name", length = 50, nullable = false)
	private String name;
	@OneToMany(mappedBy = "library", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)

	private Set<BookEntity> books = new HashSet<>();

	protected LibraryEntity() {
	}
	
	public LibraryEntity(Long id, String name) {
		this.id = id;
		this.name = name;
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

}
