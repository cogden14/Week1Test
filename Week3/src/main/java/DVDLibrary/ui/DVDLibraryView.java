/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DVDLibrary.ui;

import DVDLibrary.dto.DVD;
import java.util.List;

/**
 *
 * @author coleogden
 */
public class DVDLibraryView {
    private UserIO io = new UserIOConsoleImpl();

    public int printMenuAndGetSelection() {
        io.print("Main Menu");
        io.print("1. Add a DVD");
        io.print("2. Remove a DVD");
        io.print("3. Edit DVD information");
        io.print("4. View all DVDs");
        io.print("5. Search by title");
        io.print("6. Exit");

        return io.readInt("Please select from the above choices.", 1, 6);
    }
    
    public DVD getNewDVDInfo() {
        String title = io.readString("Please enter title");
        String releaseDate = io.readString("Please enter release date");
        double mpaaRating = io.readDouble("Please enter MPAA Rating");
        String director = io.readString("Please enter director");
        String studio = io.readString("Please enter studio");
        String note = io.readString("Please enter extra note (e.g. good for family)");
        DVD newStudent = new DVD(title,releaseDate,mpaaRating,director,studio,note);
        return newStudent;
    }
    
    public void displayCreateDVDBanner() {
        io.print("=== Create DVD ===");
    }
    
    public void displayCreateSuccessBanner() {
        io.readString("DVD successfully created. Please hit enter to continue.");
    }
    
    public void displayDisplayAllDVDsBanner() {
        io.print("=== Display All DVDs ===");
    }

    public void displayDVDList(List<DVD> dvds) {
       int count = 1;
       for (DVD currentDVD : dvds) {
           String dvdInfo = String.format(count + ".) %s by %s, "
                   + "released on %s through %s \n"
                   + "MPAA Rating: %s | Note: %s",
                   currentDVD.getTitle(),
                   currentDVD.getDirector(),
                   currentDVD.getReleaseDate(),
                   currentDVD.getStudio(),
                   currentDVD.getMpaaRating(),
                   currentDVD.getNote());
           io.print(dvdInfo);
           count++;
       }
       io.readString("Please hit enter to continue.");
    }
    
    public void displayDisplayDVDBanner () {
        io.print("=== Display DVD ===");
    }
    
    public String getDVDTitleChoice() {
        return io.readString("Please enter the DVD title.");
    }
    
    public void displayDVD(DVD dvd) {
        if(dvd != null) {
            io.print(dvd.getTitle());
            io.print(dvd.getDirector());
            io.print(dvd.getReleaseDate());
            io.print(String.valueOf(dvd.getMpaaRating()));
            io.print(dvd.getNote());
            io.print("");
        } else {
            io.print("No such DVD.");
        }
        io.readString("Please hit enter to continue.");
    }
    
    public void displayRemoveDVDBanner() {
        io.print("=== Remove DVD ===");
    }
    
    public void displayRemoveResult(DVD dvdRecord) {
        if(dvdRecord != null) {
            io.print("DVD successfully removed.");
        } else {
            io.print("No such student.");
        }
        io.readString("Please hit enter to continue.");
    }
    
    public void displayExitBanner() {
        io.print("Good Bye!!!!");
    }
    
    public void displayUnknownCommandBanner() {
        io.print("Unkown Command!!!");
    }
    
    public void displayErrorMessage(String errorMsg) {
        io.print("=== ERROR ===");
        io.print(errorMsg);
    }

    public void displayModifyDVDBanner() {
        io.print("=== Edit DVD ===");
    }

    public void displayModifiedSuccessBanner() {
        io.print("DVD successfully modified.");
    }
}
