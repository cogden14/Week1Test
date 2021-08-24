package AddressBook;

import AddressBook.controller.AddressBookController;
import AddressBook.dao.AddressBookDao;
import AddressBook.dao.AddressBookDaoImpl;
import AddressBook.ui.AddressBookView;
import AddressBook.ui.UserIO;
import AddressBook.ui.UserIOImpl;

public class App_AddressBook {
    public static void main(String[] args) {
        UserIO io = new UserIOImpl();
        AddressBookView view = new AddressBookView(io);
        AddressBookDao dao = new AddressBookDaoImpl();
        AddressBookController controller = new AddressBookController(view, dao);
        controller.run();
    }
}
