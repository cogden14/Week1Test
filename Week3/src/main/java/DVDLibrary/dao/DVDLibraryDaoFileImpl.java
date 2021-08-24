/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DVDLibrary.dao;

import DVDLibrary.dto.DVD;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author coleogden
 */
public class DVDLibraryDaoFileImpl implements DVDLibraryDao {

    private Map<String, DVD> dvds = new HashMap<>();
    private final String LIBRARY_FILE;
    public static final String DELIMITER = "::";
    
    public DVDLibraryDaoFileImpl() {
        LIBRARY_FILE = "library.txt";
    }

    public DVDLibraryDaoFileImpl(String libraryTextFile) {
        LIBRARY_FILE = libraryTextFile;
    }

    @Override
    public DVD addDVD(String title, DVD dvd) throws DVDLibraryDaoException {
        loadLibrary();
        DVD newDVD = dvds.put(title, dvd);
        writeLibrary();
        return newDVD;
    }

    @Override
    public DVD modifyDVD(String title, DVD dvd) throws DVDLibraryDaoException{
        dvds.remove(title);
        return dvds.put(dvd.getTitle(), dvd);
    }

    @Override
    public DVD removeDVD(String title) throws DVDLibraryDaoException{
        loadLibrary();
        DVD removedDVD = dvds.remove(title);
        writeLibrary();
        return removedDVD;
    }

    @Override
    public List<DVD> getAllDVDs() throws DVDLibraryDaoException{
        loadLibrary();
        return new ArrayList(dvds.values());
    }

    @Override
    public DVD getDVD(String title) throws DVDLibraryDaoException{
        loadLibrary();
        return dvds.get(title);
    }

    private DVD unmarshallDVD(String DVDAsText) {
        String[] DVDTokens = DVDAsText.split(DELIMITER);
        DVD DVDFromFile = new DVD(DVDTokens[0]);
        DVDFromFile.setReleaseDate(DVDTokens[1]);
        DVDFromFile.setMpaaRating(Double.parseDouble(DVDTokens[2]));
        DVDFromFile.setDirector(DVDTokens[3]);
        DVDFromFile.setStudio(DVDTokens[4]);
        DVDFromFile.setNote(DVDTokens[5]);
        return DVDFromFile;
    }

    private void loadLibrary() throws DVDLibraryDaoException {
        Scanner scanner;

        try {
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(LIBRARY_FILE)));
        } catch (FileNotFoundException e) {
            throw new DVDLibraryDaoException(
                    "-_- Could not load library data into memory.", e);
        }
        String currentLine;
        DVD currentDVD;
        while (scanner.hasNextLine()) {
            // get the next line in the file
            currentLine = scanner.nextLine();
            // unmarshall the line into a DVD
            currentDVD = unmarshallDVD(currentLine);

            dvds.put(currentDVD.getTitle(), currentDVD);
        }
        // close scanner
        scanner.close();
    }

    private String marshallDVD(DVD aDVD) {
        String DVDAsText = aDVD.getTitle() + DELIMITER;
        DVDAsText += aDVD.getReleaseDate()+ DELIMITER;
        DVDAsText += aDVD.getMpaaRating() + DELIMITER;
        DVDAsText += aDVD.getDirector()+ DELIMITER;
        DVDAsText += aDVD.getStudio()+ DELIMITER;
        DVDAsText += aDVD.getNote();

        return DVDAsText;
    }

    /**
     * Writes all DVDs in the library out to a LIBRARY_FILE. See loadLibrary
     * for file format.
     *
     * @throws DVDLibraryDaoException if an error occurs writing to the file
     */
    private void writeLibrary() throws DVDLibraryDaoException {
        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(LIBRARY_FILE));
        } catch (IOException e) {
            throw new DVDLibraryDaoException(
                    "Could not save student data.", e);
        }

        String DVDAsText;
        List<DVD> DVDList = this.getAllDVDs();
        for (DVD currentDVD : DVDList) {
            DVDAsText = marshallDVD(currentDVD);
            // write the Student object to the file
            out.println(DVDAsText);
            // force PrintWriter to write line to the file
            out.flush();
        }
        // Clean up
        out.close();
    }
}
