package pl.spring.demo.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pl.spring.demo.entity.LibraryEntity;

import static org.junit.Assert.*;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "CommonDaoTest-context.xml")
public class LibraryDaoImplTest {

    @Autowired
    private LibraryDao libraryDao;  
    
    @Test
    public void testShouldFindLibrariesById() {
        // given
        final long libraryId = 4;
        // when
        LibraryEntity libraryEntity = libraryDao.findOne(libraryId);
        // then
        assertNotNull(libraryEntity);
        assertEquals("Pierwsza biblioteka", libraryEntity.getName());
    }


    
    @Test
    public void testShouldFindLibrariesByName() {
    	// given
    	final String libraryName = "p";
    	// when
    	List<LibraryEntity> librariesEntity = libraryDao.findLibraryByName(libraryName);
    	// then
    	assertNotNull(librariesEntity);
    	assertFalse(librariesEntity.isEmpty());
    	assertEquals("Pierwsza biblioteka", librariesEntity.get(0).getName());
    }
    
}
