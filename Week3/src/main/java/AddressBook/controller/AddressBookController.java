package com.mm.addressbook.controller;

import Week2.AddressBook.dao.AddressBookDao;
import Week2.AddressBook.dao.AddressBookDaoException;
import Week2.AddressBook.dto.Address;
import Week2.AddressBook.ui.AddressBookView;
import java.util.List;

import java.util.List;

public class AddressBookController {
    private AddressBookView view;
    private AddressBookDao dao;

    public AddressBookController(AddressBookView view, AddressBookDao dao) {
        this.view = view;
        this.dao = dao;
    }
    
    public void run(){
        boolean keepGoing = true;
        int menuSelection = 0;
        try{
            load();
            while(keepGoing){
                menuSelection = view.printMenuAndGetSelection();
                
                switch(menuSelection){
                    case 1:
                        addAddress();
                        break;
                    case 2:
                        deleteAddress();
                        break;
                    case 3:
                        findAddress();
                        break;
                    case 4:
                        countAddress();
                        break;
                    case 5:
                        listAddress();
                        break;
                    case 6:
                        editAddress();
                        break;
                    case 7:
                        keepGoing = false;
                        break;
                    default:
                        unknownCommand();
                        break;
                }
            }
            save();
            exitMessage();
        }catch(AddressBookDaoException abde){
                view.displayErrorMessage(abde.getMessage());
        }
    }
    
    private void addAddress() throws AddressBookDaoException{
        view.displayAddAddressBanner();
        Address addr = view.getNewAddressInfo();
        dao.addAddress(addr);
        view.displayAddAddressSuccess();
    }
    
    private void deleteAddress() throws AddressBookDaoException{
        view.displayDeleteAddressBanner();
        String name = view.getAddressLastName();
        Address addr = dao.deleteAddress(name);
        view.displayDeleteAddressResult(addr);
    }
    
    private void findAddress() throws AddressBookDaoException{
        view.displayFindAddressBanner();
        String name = view.getAddressLastName();
        Address addr = dao.findAddress(name);
        view.displayAddress(addr);
    }
    
    private void countAddress() throws AddressBookDaoException{
        view.displayListCountBanner();
        int count = dao.countAddress();
        view.showCount(count);
    }
    
    private void listAddress() throws AddressBookDaoException{
        view.displayListAllBanner();
        List<Address> list = dao.listAddress();
        view.listAddresses(list);
    }
    
    private void editAddress() throws AddressBookDaoException{
        view.displayEditBanner();
        String name = view.getAddressLastName();
        Address addr = dao.findAddress(name);
        Address edit = null;
        if(addr != null){
            addr = view.getNewAddressInfo();
            edit = dao.editAddress(name, addr);
        }
        view.displayEditResult(edit);
    }
    
    private void load() throws AddressBookDaoException{
        view.displayLoadBanner();
        dao.loadRoster();
    }
    
    private void save() throws AddressBookDaoException{
        view.displaySaveBanner();
        dao.saveRoster();
    }
    
    private void unknownCommand(){
        view.displayUnknownCommandBanner();
    }
    
    private void exitMessage(){
        view.displayExitBanner();
    }
}
