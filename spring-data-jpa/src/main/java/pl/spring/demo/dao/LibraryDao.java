/**
 * 
 */
package pl.spring.demo.dao;

import java.util.List;

import pl.spring.demo.entity.LibraryEntity;


/**
 * @author HSIENKIE
 *
 */
public interface LibraryDao extends Dao<LibraryEntity, Long> {

    List<LibraryEntity> findLibraryByName(String name);
}
