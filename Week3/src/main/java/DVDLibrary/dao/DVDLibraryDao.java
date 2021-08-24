/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Week2.DVDLibrary.dao;

import Week2.DVDLibrary.dto.DVD;
import java.util.List;

/**
 *
 * @author coleogden
 */
public interface DVDLibraryDao {

    /**
     * Adds a DVD to the library. If there is an existing title,
     * return null
     * 
     * @param title
     * @param dvd
     * @return
     * @throws DVDLibraryDaoException
     */
    public DVD addDVD(String title, DVD dvd) throws DVDLibraryDaoException;

    /**
     * Removes a title from library. If no matching title,
     * return null
     * @param title
     * @return
     * @throws DVDLibraryDaoException
     */
    public DVD removeDVD(String title) throws DVDLibraryDaoException;

    /**
     * Retrieves all DVDs in library. Returns empty list if none found.
     * 
     * @return
     * @throws DVDLibraryDaoException
     */
    public List<DVD> getAllDVDs() throws DVDLibraryDaoException;

    /**
     * Retrieve a DVD given a title. Returns null if none found.
     * @param title
     * @return
     * @throws DVDLibraryDaoException
     */
    public DVD getDVD(String title) throws DVDLibraryDaoException;

    /**
     * Edits an existing DVD in library to updated DVD information.
     * Will not add a new entry if no matching title found.
     * @param title
     * @param dvd
     * @return
     * @throws DVDLibraryDaoException
     */
    public DVD modifyDVD(String title, DVD dvd) throws DVDLibraryDaoException;
}
