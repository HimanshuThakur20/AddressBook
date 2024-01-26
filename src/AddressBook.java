import java.util.HashMap;

public class AddressBook {
    HashMap<Integer,Person> contactList = new HashMap<>();

    @Override
    public String toString() {
        return "\nAddressBook " +
                "\ncontactList " + contactList +
                ' ';
    }
}
