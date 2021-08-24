/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AddressBook.dao;

import java.io.FileWriter;
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
public class AddressBookDaoImplTest {
    
    AddressBookDao testDao;
    public AddressBookDaoImplTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() throws Exception {
        String testFile = "testbook.txt";
        // Use the FileWriter to quickly blank the file
        new FileWriter(testFile);
        testDao = new AddressBookDaoImpl(testFile);
    }
    
    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testAddGetDVD() throws Exception {
        String title = "Victory of Fortnoy";
        String releaseDate = "Mar 3, 1992";
        double mpaaRating = 5.0;
        String studio = "Sony";
        String director = "Martin Scorsese";
        String note = "watch with popcorn";
        DVD dvd = new DVD(title,releaseDate,mpaaRating,director,studio,note);
        
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
    
}
