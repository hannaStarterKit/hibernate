package pl.spring.demo.dao;

import pl.spring.demo.entity.BookEntity;
import pl.spring.demo.entity.BookSearchCriteria;

import java.util.List;

public interface BookDao extends Dao<BookEntity, Long> {

    List<BookEntity> findBookByTitle(String title);
    List<BookSearchCriteria> findByTitleAuthorLibraryOrfindAll(String title, String author, String libraryName);
}
