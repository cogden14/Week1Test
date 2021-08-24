package AddressBook.ui;




import AddressBook.dto.Address;
import java.util.List;

public class AddressBookView {
    private UserIO io;

    public AddressBookView(UserIO io) {
        this.io = io;
    }
    
    public int printMenuAndGetSelection() {
        io.print("Main Menu");
        io.print("1. Add Address");
        io.print("2. Delete Address");
        io.print("3. Find Address");
        io.print("4. List Address Count");
        io.print("5. List All Addresses");
        io.print("6. Edit Address");
        io.print("7. Exit");

        return io.readInt("Please select the operation you wish to perform: ", 1, 7);
    }
    
    public void displayAddAddressBanner(){
        io.print("=== Add Address ===");
    }
    
    public Address getNewAddressInfo() {
        String firstName = io.readString("Enter First Name: ");
        String lastName = io.readString("Enter Last Name: ");
        String address = io.readString("Enter Address Name: ");
        String city = io.readString("Enter City: ");
        String state = io.readString("Enter State: ");
        int zipcode  = io.readInt("Enter Zipcode: ");
        
        Address addr = new Address(lastName);
        addr.setFirstName(firstName);
        addr.setAddress(address);
        addr.setCity(city);
        addr.setState(state);
        addr.setZipcode(zipcode);
        
        return addr;
    }
    
    public void displayAddAddressSuccess(){
        io.readString("Address successfully added.  Please hit enter to continue");
    }
    
    public void displayDeleteAddressBanner () {
        io.print("=== Delete Address ===");
    }
    
    public String getAddressLastName(){
        return io.readString("Enter last name: ");
    }
    
    public void displayDeleteAddressResult(Address addr){
        if(addr != null){
            io.print("Address successfully deleted");
        } else {
            io.print("No such address.");
        }
        io.readString("Please hit enter to continue.");
    }
    
    public void displayFindAddressBanner () {
        io.print("=== Find Address ===");
        
    }
    
    public void displayAddress(Address addr){
        if(addr != null){
            io.print(addr.getFirstName() + " " + addr.getLastName());
            io.print(addr.getAddress());
            io.print(addr.getCity() + ", " + addr.getState() + ", " + addr.getZipcode());
            io.print("");
        }else {
            io.print("No such address.");
        }
        io.readString("Please hit enter to continue.");
    }
    
    public void displayListCountBanner() {
        io.print("=== List Address Count ===");
    }
    
    public void showCount(int count){
        switch(count){
            case 0:
                io.print("The address book is empty");
                break;
            case 1:
                io.print("There is one address in the book");
                break;
            default:
                io.print("There are " + count + " addresses in the book");
                break;
        }
        io.readString("Please hit enter to continue.");
    }
    
    public void displayListAllBanner() {
        io.print("=== List All Addresses ===");
    }
    
    public void listAddresses(List<Address> list) {
        for(Address addr : list){
            io.print(addr.getFirstName() + " " + addr.getLastName());
            io.print(addr.getAddress());
            io.print(addr.getCity() + ", " + addr.getState() + ", " + addr.getZipcode());
            io.print("");
        }
        io.readString("Please hit enter to continue.");
    }
    
    public void displayEditBanner() {
        io.print("=== Edit Address ===");
    }
    
    public void displayEditResult(Address addr){
        if(addr != null){
            io.print("Address successfully edited");
        } else {
            io.print("No such address.");
        }
        io.readString("Please hit enter to continue.");
    }
    
    public void displayLoadBanner() {
        io.print("=== Loading Address Book... ===");
    }
    
    public void displaySaveBanner() {
        io.print("=== Saving Address Book... ===");
    }
    
    public void displayExitBanner() {
        io.print("Good Bye!!!");
    }

    public void displayUnknownCommandBanner() {
        io.print("Unknown Command!!!");
    }
    
    public void displayErrorMessage(String errorMsg) {
        io.print("=== ERROR ===");
        io.print(errorMsg);
    }
}
