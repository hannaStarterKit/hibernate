/**
 * 
 */
package pl.spring.demo.dao.impl;

import java.util.List;


import javax.persistence.TypedQuery;

import pl.spring.demo.dao.LibraryDao;
import pl.spring.demo.entity.LibraryEntity;

/**
 * @author HSIENKIE
 *
 */
public class LibraryDaoImpl extends AbstractDao<LibraryEntity, Long> implements LibraryDao {

	@Override
	public List<LibraryEntity> findLibraryByName(String name) {
		TypedQuery<LibraryEntity> query = entityManager.createQuery(
				"select library from LibraryEntity library where upper(library.name) like concat(upper(:name), '%')",
				LibraryEntity.class);
		query.setParameter("name", name);
		return query.getResultList();
	}

	// @Override
	// public void deleteLibrary(LibraryEntity library) {
	// Set<BookEntity> books = library.getBooks();
	// for (BookEntity bookEntity : books) {
	//
	// }
	// this.delete(library);
	// }

//	@Override
//	public int deleteLibraryById(Long id) {
//		Query queryBookAuthor = entityManager.createQuery("delete from book_author ");
//		queryBookAuthor.setParameter("id", id).executeUpdate();
//		Query queryBook = entityManager.createQuery("delete from BookEntity book where book.library library.id = :id");
//		queryBook.setParameter("id", id).executeUpdate();
//		Query queryLibrary = entityManager.createQuery("delete from LibraryEntity library where library.id = :id");
//		return queryLibrary.setParameter("id", id).executeUpdate();
//	}

}