/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DVDLibrary.controller;

import DVDLibrary.dao.DVDLibraryDao;
import DVDLibrary.dao.DVDLibraryDaoException;
import DVDLibrary.dto.DVD;
import DVDLibrary.ui.DVDLibraryView;
import DVDLibrary.ui.UserIO;
import java.util.List;

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
        try {
        while(keepGoing) {
            menuSelection = getMenuSelection();
            
            switch (menuSelection) {
                case 1:
                    createDVD();
                    break;
                case 2:
                    removeDVD();
                    break;
                case 3:
                    modifyDVD();
                    break;
                case 4:
                    listDVDs();
                    break;
                case 5:
                    viewDVD();
                    break;
                case 6:
                    keepGoing = false;
                    break;
                default:
                    unknownCommand();
            }
        }
        exitMessage();
        } catch (DVDLibraryDaoException e) {
            view.displayErrorMessage(e.getMessage());
        }
    }
    
    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }
    
    private void createDVD() throws DVDLibraryDaoException {
        view.displayCreateDVDBanner();
        DVD dvd = view.getNewDVDInfo();
        dao.addDVD(dvd.getTitle(), dvd);
        view.displayCreateSuccessBanner();
    }
    
    private void listDVDs() throws DVDLibraryDaoException{
        view.displayDisplayAllDVDsBanner();
        List<DVD> dvdList = dao.getAllDVDs();
        view.displayDVDList(dvdList);
    }
    
    private void modifyDVD() throws DVDLibraryDaoException{
        view.displayModifyDVDBanner();
        String title = view.getDVDTitleChoice();
        DVD dvd = dao.getDVD(title);
        DVD newDVD = view.getNewDVDInfo();
        dao.modifyDVD(dvd.getTitle(), newDVD);
        view.displayModifiedSuccessBanner();
    }
    
    private void viewDVD() throws DVDLibraryDaoException{
        view.displayDisplayDVDBanner();
        String title = view.getDVDTitleChoice();
        DVD dvd = dao.getDVD(title);
        view.displayDVD(dvd);
    }
    
    private void removeDVD() throws DVDLibraryDaoException{
        view.displayRemoveDVDBanner();
        String title = view.getDVDTitleChoice();
        DVD removedDVD = dao.removeDVD(title);
        view.displayRemoveResult(removedDVD);
    }
    
    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }
    
    private void exitMessage() {
        view.displayExitBanner();
    }
}
