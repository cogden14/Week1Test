package AddressBook.dao;

import AddressBook.dto.Address;
import java.util.List;

public interface AddressBookDao {
    Address addAddress(Address addr);
    
    Address deleteAddress(String name);
    
    int countAddress();
    
    List<Address> listAddress();
    
    Address findAddress(String name);
    
    Address editAddress(String name, Address addr);
    
    void loadRoster() throws AddressBookDaoException;
    
    void saveRoster() throws AddressBookDaoException;
}
