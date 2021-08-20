/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Week2.AddressBook.controller;

import Day3.UserIO;
import Day3.UserIOImpl;
import Week2.AddressBook.dao.AddressBookDao;

/**
 *
 * @author coleogden
 */
public class AddressBookController {
    public void run() {
        UserIO userIO = new UserIOImpl();
        AddressBookDao dao = new AddressBookDao();
    }
}
