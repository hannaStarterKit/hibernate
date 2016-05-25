package pl.spring.demo.service;

import java.util.List;



import pl.spring.demo.entity.BookSearchCriteria;




public interface BookSearchCriteriaService {
	
    List<BookSearchCriteria> findBooks(String title, String author, String libraryName);

}
