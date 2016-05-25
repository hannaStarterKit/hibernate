/**
 * 
 */
package pl.spring.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pl.spring.demo.entity.LibraryEntity;

/**
 * @author HSIENKIE
 *
 */
public interface LibraryRepository extends JpaRepository<LibraryEntity, Long> {

	@Query("select library from LibraryEntity library where upper(library.name) like concat(upper(:name), '%')")
	public List<LibraryEntity> findLibraryByName(@Param("name") String name);

	@Query("select library from LibraryEntity library JOIN library.books book where upper(book.title) like concat('%', upper(:title), '%')")
	public List<LibraryEntity> findLibraryByBookTitle(@Param("title") String title);

}
