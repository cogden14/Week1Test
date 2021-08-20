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
    public DVD addDVD(String title, DVD dvd);
    public void removeDVD(String title);
    public void editDVD(String title);
    public List<DVD> getAllDVDs();
    public DVD getDVD(String title);
}
