/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DVDLibrary;

import DVDLibrary.controller.DVDLibraryController;
import DVDLibrary.dao.DVDLibraryDao;
import DVDLibrary.dao.DVDLibraryDaoFileImpl;
import DVDLibrary.ui.DVDLibraryView;
import DVDLibrary.ui.UserIO;
import DVDLibrary.ui.UserIOConsoleImpl;

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
