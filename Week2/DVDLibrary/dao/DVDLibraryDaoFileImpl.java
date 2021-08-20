/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Week2.DVDLibrary.dao;

import Week2.DVDLibrary.dto.DVD;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author coleogden
 */
public class DVDLibraryDaoFileImpl implements DVDLibraryDao{
    private Map<String, DVD> DVDLibrary = new HashMap<>();
    
    @Override
    public DVD addDVD(String title, DVD dvd) {
        DVD prevDVD = DVDLibrary.put(title, dvd);
        return prevDVD;
    }

    @Override
    public void removeDVD(String title) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void editDVD(String title) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DVD> getAllDVDs() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DVD getDVD(String title) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
