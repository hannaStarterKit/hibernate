package pl.spring.demo.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.spring.demo.entity.BookSearchCriteria;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "CommonServiceTest-context.xml")
public class BookSearchCriteriaServiceTest {

	@Autowired
	BookSearchCriteriaService bookSearchCriteriaService;

	@Test
	public void testShouldFindBookByTitleAuthorLibraryName() {
		// given
		final String title = "pierwsza";
		final String author = "jan";
		final String libraryName = "pierwsza";
		// when
		List<BookSearchCriteria> booksSearchCriteria = bookSearchCriteriaService.findBooks(title, author, libraryName);
		// then
		assertNotNull(booksSearchCriteria);
		assertFalse(booksSearchCriteria.isEmpty());
		assertEquals("Pierwsza książka", booksSearchCriteria.get(0).getTitle());
	}
	
	@Test
	public void testShouldFindBookByTitleAuthor() {
		// given
		final String title = "pierwsza";
		final String author = "jan";
		final String libraryName = "";
		// when
		List<BookSearchCriteria> booksSearchCriteria = bookSearchCriteriaService.findBooks(title, author, libraryName);
		// then
		assertNotNull(booksSearchCriteria);
		assertFalse(booksSearchCriteria.isEmpty());
		assertEquals("Pierwsza książka", booksSearchCriteria.get(0).getTitle());
	}
	
	@Test
	public void testShouldFindBookByTitle() {
		// given
		final String title = "pierwsza";
		final String author = "";
		final String libraryName = "";
		// when
		List<BookSearchCriteria> booksSearchCriteria = bookSearchCriteriaService.findBooks(title, author, libraryName);
		// then
		assertNotNull(booksSearchCriteria);
		assertFalse(booksSearchCriteria.isEmpty());
		assertEquals("Pierwsza książka", booksSearchCriteria.get(0).getTitle());
	}
	@Test
	public void testShouldFindBookByAuthorLibraryName() {
		// given
		final String title = "";
		final String author = "an";
		final String libraryName = "bib";
		// when
		List<BookSearchCriteria> booksSearchCriteria = bookSearchCriteriaService.findBooks(title, author, libraryName);
		// then
		assertNotNull(booksSearchCriteria);
		assertFalse(booksSearchCriteria.isEmpty());
		assertEquals("Pierwsza książka", booksSearchCriteria.get(0).getTitle());
	}
	
	@Test
	public void testShouldFindBookByTitleLibraryName() {
		// given
		final String title = "pierwsza";
		final String author = null;
		final String libraryName = "p";
		// when
		List<BookSearchCriteria> booksSearchCriteria = bookSearchCriteriaService.findBooks(title, author, libraryName);
		// then
		assertNotNull(booksSearchCriteria);
		assertFalse(booksSearchCriteria.isEmpty());
		assertEquals("Pierwsza książka", booksSearchCriteria.get(0).getTitle());
	}
	
	@Test
	public void testShouldFindAllBooks() {
		// given
		final String title = null;
		final String author = null;
		final String libraryName = null;
		// when
		List<BookSearchCriteria> booksSearchCriteria = bookSearchCriteriaService.findBooks(title, author, libraryName);
		//int numberOfExistingBooks = 
		// then
		assertNotNull(booksSearchCriteria);
		assertFalse(booksSearchCriteria.isEmpty());
		assertEquals(3, booksSearchCriteria.size());
	}

}
