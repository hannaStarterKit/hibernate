/**
 * 
 */
package pl.spring.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.spring.demo.dao.BookDao;
import pl.spring.demo.entity.BookSearchCriteria;

import pl.spring.demo.service.BookSearchCriteriaService;

/**
 * @author HSIENKIE
 *
 */
@Service
@Transactional(readOnly = true)
public class BookSearchCriteriaServiceImpl implements BookSearchCriteriaService {

	@Autowired
	private BookDao bookDao;

	@Override
	public List<BookSearchCriteria> findBooks(String title, String author, String libraryName) {
		if (title == null) {
			title = "";
		}
		if (author == null) {
			author = "";
		}
		if (libraryName == null) {
			libraryName = "";
		}
		return bookDao.findByTitleAuthorLibraryOrfindAll(title, author, libraryName);
	}

}
