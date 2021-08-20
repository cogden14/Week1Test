/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Week2.DVDLibrary.controller;

import Week2.DVDLibrary.dao.DVDLibraryDao;
import Week2.DVDLibrary.dto.DVD;
import Week2.DVDLibrary.ui.DVDLibraryView;
import Week2.DVDLibrary.ui.UserIO;

/**
 *
 * @author coleogden
 */
public class DVDLibraryController {
    private UserIO io;
    private DVDLibraryView view;
    private DVDLibraryDao dao;
    
    public DVDLibraryController(UserIO io, DVDLibraryView view, DVDLibraryDao dao) {
        this.io = io;
        this.view = view;
        this.dao = dao;
    }
    
    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;
        while(keepGoing) {
            menuSelection = getMenuSelection();
            
            switch (menuSelection) {
                case 1:
                    createDVD();
                    break;
                case 2:
                    keepGoing = false;
                    break;
                default:
                    io.print("Unknown command");
            }
        }
        io.print("Good bye");
    }
    
    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }
    
    private void createDVD() {
        view.displayCreateDVDBanner();
        DVD dvd = view.getNewDVDInfo();
        dao.addDVD(dvd.getTitle(), dvd);
        view.displayCreateSuccessBanner();
    }
}
