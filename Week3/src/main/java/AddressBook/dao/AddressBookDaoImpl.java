package AddressBook.dao;

import AddressBook.dto.Address;
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

public class AddressBookDaoImpl implements AddressBookDao{
    public final String FILE_NAME;
    public static final String DELIMITER = "::";
    
    private Map<String, Address> book = new HashMap<String, Address>();
    
    public AddressBookDaoImpl() {
        FILE_NAME = "book.txt";
    }

    public AddressBookDaoImpl(String bookTextFile) {
        FILE_NAME = bookTextFile;
    }

    @Override
    public Address addAddress(Address addr) {
        return book.put(addr.getLastName(), addr);
    }

    @Override
    public Address deleteAddress(String name) {
        return book.remove(name);
    }

    @Override
    public int countAddress() {
        return book.size();
    }

    @Override
    public List<Address> listAddress() {
        return new ArrayList<Address>(book.values());
    }

    @Override
    public Address findAddress(String name) {
        System.out.println("Addresses found listed bellow:");
        return book.get(name);
    }
    
    @Override
    public Address editAddress(String name, Address addr){
        book.remove(name);
        return book.put(addr.getLastName(), addr);
    }
    
    public Address unmarshallAddress(String addressAsText){
        String[] addressTokens = addressAsText.split(DELIMITER);
        String lastName = addressTokens[1];
        Address addr = new Address(lastName);
        
        addr.setFirstName(addressTokens[0]);
        addr.setAddress(addressTokens[2]);
        addr.setCity(addressTokens[3]);
        addr.setState(addressTokens[4]);
        addr.setZipcode(Integer.parseInt(addressTokens[5]));
        
        return addr;
    }
    
    @Override
    public void loadRoster() throws AddressBookDaoException{
        Scanner read;
        try{
            read = new Scanner(
                new BufferedReader(
                        new FileReader(FILE_NAME)));
        }catch(FileNotFoundException fnfe){
            throw new AddressBookDaoException(
                "-_- Could not load roster data into memory.", fnfe);
        }
        String currentLine;
        Address currentAddress;
        while(read.hasNextLine()){
            currentLine = read.nextLine();
            currentAddress = unmarshallAddress(currentLine);
            book.put(currentAddress.getLastName(), currentAddress);
        }
        read.close();
    }
    
    public String marshallAddress(Address addr){
        String addrAsText = addr.getFirstName() + DELIMITER;
        addrAsText += addr.getLastName() + DELIMITER;
        addrAsText += addr.getAddress() + DELIMITER;
        addrAsText += addr.getCity() + DELIMITER;
        addrAsText += addr.getState() + DELIMITER;
        addrAsText += addr.getZipcode();
        
        return addrAsText;
    }
    
    @Override
    public void saveRoster() throws AddressBookDaoException{
        PrintWriter out;
        
        try{
            out = new PrintWriter(new FileWriter(FILE_NAME));
        }catch(IOException ioe){
            throw new AddressBookDaoException(
            "Could not save student data.", ioe);
        }
        String addrAsText;
        List<Address> addrList = this.listAddress();
        for(Address addr : addrList){
            addrAsText = marshallAddress(addr);
            out.println(addrAsText);
            out.flush();
        }
        out.close();
    }
}