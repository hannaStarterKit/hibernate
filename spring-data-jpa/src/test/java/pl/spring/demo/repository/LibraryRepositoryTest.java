package pl.spring.demo.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pl.spring.demo.entity.BookEntity;
import pl.spring.demo.entity.LibraryEntity;

import static org.junit.Assert.*;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "CommonRepositoryTest-context.xml")
public class LibraryRepositoryTest {

	@Autowired
	private LibraryRepository libraryRepository;
	
	@Autowired
	private BookRepository bookRepository;

	@Test
	public void testShouldFindLibraryById() {
		// given
		final long libraryId = 4;
		// when
		LibraryEntity libraryEntity = libraryRepository.findOne(libraryId);
		// then
		assertNotNull(libraryEntity);
		assertEquals("Pierwsza biblioteka", libraryEntity.getName());
	}

	@Test
	public void testShouldFindLibrariesByName() {
		// given
		final String libraryName = "p";
		// when
		List<LibraryEntity> librariesEntity = libraryRepository.findLibraryByName(libraryName);
		// then
		assertNotNull(librariesEntity);
		assertFalse(librariesEntity.isEmpty());
		assertEquals("Pierwsza biblioteka", librariesEntity.get(0).getName());
	}

	@Test
	public void testShouldFindLibrariesByBookTitle() {
		// given
		final String title = "p";
		// when
		List<LibraryEntity> librariesEntity = libraryRepository.findLibraryByBookTitle(title);
		// then
		assertNotNull(librariesEntity);
		assertFalse(librariesEntity.isEmpty());
		assertEquals("Pierwsza biblioteka", librariesEntity.get(0).getName());
	}

	@Test
	public void testShouldRemoveLibraryByIdAndAllBooksInThatLibrary() {
		// given
		final long libraryId = 5;
		final long bookId = 2;
		BookEntity bookEntityExisted = bookRepository.findOne(bookId);
		// when
		libraryRepository.delete(libraryId);
		LibraryEntity libraryEntityRemoved = libraryRepository.findOne(libraryId);
		BookEntity bookEntityRemoved = bookRepository.findOne(bookId);
		// then
		assertNull(libraryEntityRemoved);
		assertNotNull(bookEntityExisted);
		assertNull(bookEntityRemoved);
	}
}
