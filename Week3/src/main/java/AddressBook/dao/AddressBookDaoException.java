package AddressBook.dao;


public class AddressBookDaoException extends Exception {

    public AddressBookDaoException(String string) {
        super(string);
    }

    public AddressBookDaoException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }
}
