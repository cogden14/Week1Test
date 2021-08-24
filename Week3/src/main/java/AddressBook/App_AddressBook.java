package Week2.AddressBook;

import Week2.AddressBook.AddressBookController;
import Week2.AddressBook.AddressBookController;
import com.mm.addressbook.dao.AddressBookDao;
import Week2.AddressBook.AddressBookDaoImpl;
import com.mm.addressbook.ui.AddressBookView;
import Week2.AddressBook.UserIO;
import Week2.AddressBook.UserIOImpl;

public class App_AddressBook {
    public static void main(String[] args) {
        UserIO io = new UserIOImpl();
        AddressBookView view = new AddressBookView(io);
        AddressBookDao dao = new AddressBookDaoImpl();
        AddressBookController controller = new AddressBookController(view, dao);
        controller.run();
    }
}
