package pl.spring.demo.to;

import pl.spring.demo.entity.LibraryEntity;

public class BookTo {
    private Long id;
    private String title;
    private String authors;
    private LibraryEntity library;

    public BookTo() {
    }

    public BookTo(Long id, String title, String authors, LibraryEntity library) {
        this.id = id;
        this.title = title;
        this.authors = authors;
        this.setLibrary(library);
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

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

	public LibraryEntity getLibrary() {
		return library;
	}

	public void setLibrary(LibraryEntity library) {
		this.library = library;
	}
}
