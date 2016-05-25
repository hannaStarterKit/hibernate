package pl.spring.demo.dao.impl;

import pl.spring.demo.dao.BookDao;
import pl.spring.demo.entity.BookEntity;
import pl.spring.demo.entity.BookSearchCriteria;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookDaoImpl extends AbstractDao<BookEntity, Long> implements BookDao {

    @Override
    public List<BookEntity> findBookByTitle(String title) {
        TypedQuery<BookEntity> query = entityManager.createQuery(
                "select book from BookEntity book where upper(book.title) like concat(upper(:title), '%')", BookEntity.class);
        query.setParameter("title", title);
        return query.getResultList();
    }
    
    @Override
	public List<BookSearchCriteria> findByTitleAuthorLibraryOrfindAll(String title, String author, String libraryName){
        TypedQuery<BookSearchCriteria> query = entityManager.createNamedQuery(
                "BookSearchCriteria.findByTitleAuthorLibraryOrfindAll", BookSearchCriteria.class);
        query.setParameter("libraryName", libraryName).setParameter("author", author).setParameter("title", title);
        return query.getResultList();
	}
    

}
