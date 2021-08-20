/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Week2.AddressBook.dao;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author coleogden
 */
public class AddressBookDao {
    private List<Address> addresses = new ArrayList<>();
    
    public void addAddress(Address address) {
        addresses.add(address);
    }
    
    public void removeAddress(Address address) {
        addresses.remove(address);
    }
    
    public Address getAddressByLastName(String lName) {
        for(Address adr : addresses) {
            if(adr.getlName().equals(lName)) {
                return adr;
            }
        }
        return null;
    }
    
    public int getAddressCount() {
        return addresses.size();
    }

    public List<Address> getAllAddresses() {
        return addresses;
    }
}
