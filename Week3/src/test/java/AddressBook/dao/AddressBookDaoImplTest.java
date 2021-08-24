/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AddressBook.dao;

import AddressBook.dto.Address;
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
    public void testAddGetAddress() throws Exception {
        String lastName = "Ogden";
        Address address = new Address(lastName);
        address.setFirstName("Cole");
        address.setAddress("1600 Pennsylvania Ave");
        address.setCity("Washington D.C.");
        address.setState("Washington D.C.");
        address.setZipcode(12345);
        
        testDao.addAddress(address);
        
        Address retreivedAddress = testDao.findAddress(lastName);

        assertEquals(address.getLastName(),
                retreivedAddress.getLastName(),
                "Checking last name.");
        assertEquals(address.getFirstName(),
                retreivedAddress.getFirstName(),
                "Checking first name.");
        assertEquals(address.getAddress(),
                retreivedAddress.getAddress(),
                "Checking address.");
        assertEquals(address.getCity(),
                retreivedAddress.getCity(),
                "Checking city.");
        assertEquals(address.getState(),
                retreivedAddress.getState(),
                "Checking state.");
        assertEquals(address.getZipcode(),
                retreivedAddress.getZipcode(),
                "Checking zip code.");
    }

    @Test
    public void testAddGetAllAddresses() throws Exception {
        
        Address firstAddress = new Address("Smith");
        firstAddress.setFirstName("James");
        firstAddress.setAddress("1600 Pennsylvania Ave");
        firstAddress.setCity("Washington D.C.");
        firstAddress.setState("Washington D.C.");
        firstAddress.setZipcode(12345);

        Address secondAddress = new Address("Hancock");
        secondAddress.setFirstName("John");
        secondAddress.setAddress("1400 W South St.");
        secondAddress.setCity("New York");
        secondAddress.setState("New York");
        secondAddress.setZipcode(2345);
        
        testDao.addAddress(firstAddress);
        testDao.addAddress(secondAddress);

        List<Address> allAddresses = testDao.listAddress();

        // First check the general contents of the list
        assertNotNull(allAddresses, "The list of addresses must not null");
        assertEquals(2, allAddresses.size(), "List of addresses should have 2 addresses.");

        // Then the specifics
        assertTrue(testDao.listAddress().contains(firstAddress),
                "The list of addresses should include James Smith's address.");
        assertTrue(testDao.listAddress().contains(secondAddress),
                "The list of addresses should include John Hancock's address.");

    }

    @Test
    public void testRemoveAddresses() throws Exception {
        Address firstAddress = new Address("Smith");
        firstAddress.setFirstName("James");
        firstAddress.setAddress("1600 Pennsylvania Ave");
        firstAddress.setCity("Washington D.C.");
        firstAddress.setState("Washington D.C.");
        firstAddress.setZipcode(12345);

        Address secondAddress = new Address("Hancock");
        secondAddress.setFirstName("John");
        secondAddress.setAddress("1400 W South St.");
        secondAddress.setCity("New York");
        secondAddress.setState("New York");
        secondAddress.setZipcode(2345);
        
        testDao.addAddress(firstAddress);
        testDao.addAddress(secondAddress);

        // remove the first address - John Smith's address
        Address removedAddress = testDao.deleteAddress(firstAddress.getLastName());

        // Check that the correct object was removed.
        assertEquals(removedAddress, firstAddress, "The removed address should be James Smith's address.");

        // Get all the addresses
        List<Address> allAddresses = testDao.listAddress();

        // First check the general contents of the list
        assertNotNull(allAddresses, "All addresses list should be not null.");
        assertEquals(1, allAddresses.size(), "All addresses should only have 1 address.");

        // Then the specifics
        assertFalse(allAddresses.contains(firstAddress), "All DVDs should NOT include James Smith's address.");
        assertTrue(allAddresses.contains(secondAddress), "All DVDs should include John Hancock's address.");

        // Remove the second address
        removedAddress = testDao.deleteAddress(secondAddress.getLastName());
        // Check that the correct object was removed.
        assertEquals(removedAddress, secondAddress, "The removed adddress should be John Hancock's address.");

        // retrieve all of the addresses again, and check the list.
        allAddresses = testDao.listAddress();

        // Check the contents of the list - it should be empty
        assertTrue(allAddresses.isEmpty(), "The retrieved list of addresses should be empty.");

        // Try to 'get' both addresses by their old title - they should be null!
        Address retrievedDVD = testDao.findAddress(firstAddress.getLastName());
        assertNull(retrievedDVD, "James Smith's address was removed, should be null.");

        retrievedDVD = testDao.findAddress(secondAddress.getLastName());
        assertNull(retrievedDVD, "John Hancock's address was removed, should be null.");

    }
    
}
