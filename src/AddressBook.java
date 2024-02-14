import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AddressBook implements Serializable {
    HashMap<Integer,Person> contactList = new HashMap<>();

    @Override
    public String toString() {
        return "\nAddressBook " +
                "\ncontactList " + contactList +
                ' ';
    }


}
