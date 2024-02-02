import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AddressBook {
    HashMap<Integer,Person> contactList = new HashMap<>();

    @Override
    public String toString() {
        return "\nAddressBook " +
                "\ncontactList " + contactList +
                ' ';
    }


}
