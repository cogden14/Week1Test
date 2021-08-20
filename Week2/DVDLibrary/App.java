/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Week2.DVDLibrary;

import Week2.DVDLibrary.controller.DVDLibraryController;
import Week2.DVDLibrary.dao.DVDLibraryDao;
import Week2.DVDLibrary.dao.DVDLibraryDaoFileImpl;
import Week2.DVDLibrary.ui.DVDLibraryView;
import Week2.DVDLibrary.ui.UserIO;
import Week2.DVDLibrary.ui.UserIOConsoleImpl;

/**
 *
 * @author coleogden
 */
public class App {
    public static void main(String [] args) {
        UserIO io = new UserIOConsoleImpl();
        DVDLibraryDao dao = new DVDLibraryDaoFileImpl();
        DVDLibraryView view = new DVDLibraryView();
        DVDLibraryController app = new DVDLibraryController(io, view, dao);
        
        app.run();
        
    }
}
