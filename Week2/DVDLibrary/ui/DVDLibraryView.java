/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Week2.DVDLibrary.ui;

import Week2.DVDLibrary.dto.DVD;

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
        DVD newStudent = new DVD(title,"",0,"","","");
        newStudent.setTitle(title);
        return newStudent;
    }
    
    public void displayCreateDVDBanner() {
        io.print("=== Create DVD ===");
    }
    
    public void displayCreateSuccessBanner() {
        io.readString("DVD successfully created. Please hit enter to continue.");
    }
}
