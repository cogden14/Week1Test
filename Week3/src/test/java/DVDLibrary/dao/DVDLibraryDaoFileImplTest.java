/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DVDLibrary.dao;

import DVDLibrary.dto.DVD;
import java.io.FileWriter;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author coleogden
 */
public class DVDLibraryDaoFileImplTest {
    
    DVDLibraryDao testDao;
    
    public DVDLibraryDaoFileImplTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() throws Exception {
        String testFile = "testlibrary.txt";
        // Use the FileWriter to quickly blank the file
        new FileWriter(testFile);
        testDao = new DVDLibraryDaoFileImpl(testFile);
    }
    
    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testAddGetDVD() throws Exception {
        String title = "Victory of Fortnoy";
        DVD dvd = new DVD(title);
        dvd.setReleaseDate("Mar 3, 1992");
        dvd.setMpaaRating(5.0);
        dvd.setDirector("Martin Scorsese");
        dvd.setStudio("Sony");
        dvd.setNote("watch with popcorn");
        
        testDao.addDVD(title, dvd);
        
        DVD retreivedDVD = testDao.getDVD(title);

        assertEquals(dvd.getTitle(),
                retreivedDVD.getTitle(),
                "Checking title.");
        assertEquals(dvd.getReleaseDate(),
                retreivedDVD.getReleaseDate(),
                "Checking release date.");
        assertEquals(dvd.getMpaaRating(),
                retreivedDVD.getMpaaRating(),
                "Checking MPAA Rating.");
        assertEquals(dvd.getStudio(),
                retreivedDVD.getStudio(),
                "Checking studio.");
        assertEquals(dvd.getNote(),
                retreivedDVD.getNote(),
                "Checking note.");
    }

    @Test
    public void testAddGetAllDVDs() throws Exception {
        
        DVD firstDVD = new DVD("Battles of Agamemnon");
        firstDVD.setReleaseDate("Sept. 8, 1991");
        firstDVD.setMpaaRating(5.1);
        firstDVD.setDirector("Christopher Nolan");
        firstDVD.setStudio("Universal Studios");
        firstDVD.setNote("thriller");

        DVD secondDVD = new DVD("Conquests of Historia");
        secondDVD.setReleaseDate("Sept. 1, 2004");
        secondDVD.setMpaaRating(5.4);
        secondDVD.setDirector("Jonathon Nolan");
        secondDVD.setStudio("21st Century Fox");
        secondDVD.setNote("great one, kids for sure");
        
        testDao.addDVD(firstDVD.getTitle(), firstDVD);
        testDao.addDVD(secondDVD.getTitle(), secondDVD);

        List<DVD> allDVDs = testDao.getAllDVDs();

        // First check the general contents of the list
        assertNotNull(allDVDs, "The library of DVDs must not null");
        assertEquals(2, allDVDs.size(), "Library of DVDs should have 2 DVDs.");

        // Then the specifics
        assertTrue(testDao.getAllDVDs().contains(firstDVD),
                "The library of DVDs should include \'Battles of Agamemnon.\'");
        assertTrue(testDao.getAllDVDs().contains(secondDVD),
                "The library of DVDs should include \'Conquests of Historia.\'");

    }

    @Test
    public void testRemoveDVD() throws Exception {
        DVD firstDVD = new DVD("Battles of Agamemnon");
        firstDVD.setReleaseDate("Sept. 8, 1991");
        firstDVD.setMpaaRating(5.1);
        firstDVD.setDirector("Christopher Nolan");
        firstDVD.setStudio("Universal Studios");
        firstDVD.setNote("thriller");

        DVD secondDVD = new DVD("Conquests of Historia");
        secondDVD.setReleaseDate("Sept. 1, 2004");
        secondDVD.setMpaaRating(5.4);
        secondDVD.setDirector("Jonathon Nolan");
        secondDVD.setStudio("21st Century Fox");
        secondDVD.setNote("great one, kids for sure");
        
        testDao.addDVD(firstDVD.getTitle(), firstDVD);
        testDao.addDVD(secondDVD.getTitle(), secondDVD);

        // remove the first DVD - Battles of Agamemnon
        DVD removedDVD = testDao.removeDVD(firstDVD.getTitle());

        // Check that the correct object was removed.
        assertEquals(removedDVD, firstDVD, "The removed DVD should be \'Battles of Agamemnon\'.");

        // Get all the DVDs
        List<DVD> allDVDs = testDao.getAllDVDs();

        // First check the general contents of the list
        assertNotNull(allDVDs, "All DVDs list should be not null.");
        assertEquals(1, allDVDs.size(), "All DVDs should only have 1 DVD.");

        // Then the specifics
        assertFalse(allDVDs.contains(firstDVD), "All DVDs should NOT include \'Battles of Agamemnon\'.");
        assertTrue(allDVDs.contains(secondDVD), "All DVDs should include \'Conquests of Historia\'.");

        // Remove the second DVD
        removedDVD = testDao.removeDVD(secondDVD.getTitle());
        // Check that the correct object was removed.
        assertEquals(removedDVD, secondDVD, "The removed DVD should be \'Conquests of Historia\'.");

        // retrieve all of the DVDs again, and check the list.
        allDVDs = testDao.getAllDVDs();

        // Check the contents of the list - it should be empty
        assertTrue(allDVDs.isEmpty(), "The retrieved list of DVDs should be empty.");

        // Try to 'get' both DVDs by their old title - they should be null!
        DVD retrievedDVD = testDao.getDVD(firstDVD.getTitle());
        assertNull(retrievedDVD, "\'Battles of Agamemnon\' was removed, should be null.");

        retrievedDVD = testDao.getDVD(secondDVD.getTitle());
        assertNull(retrievedDVD, "\'Conquests of Historia\' was removed, should be null.");

    }
    
}
