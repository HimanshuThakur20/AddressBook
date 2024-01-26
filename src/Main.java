import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nWelcome to the Address book\n");
        AddressBookService s1 = new AddressBookService();
        AddressBook a1 = new AddressBook();
        Main m1 = new Main();


        for (int i = 1; i < 3;i++) {
            Person p1 = new Person();
            m1.insertValues(p1, s1, a1, i);
        }


        for (Map.Entry<Integer, Person> entry : a1.contactList.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        boolean check1=false;
        System.out.println("Do you want to edit details(true/false)");
        check1 = sc.nextBoolean();
        if(check1) {
            System.out.println("Enter the first name of person to be edited:");
            String searchName = sc.next();
            s1.editDetails(searchName,a1);
        }


        boolean check2=false;
        System.out.println("Do you want to delete details(true/false)");
        check2 = sc.nextBoolean();
        if(check2) {
            System.out.println("Enter the first name of person to be deleted:");
            String removeName = sc.next();
            s1.removeDetails(removeName,a1);
        }

        System.out.println("\n\nUpdated hashmap:");
        for (Map.Entry<Integer, Person> entry : a1.contactList.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

    }

    //Function for entering values in the hashmap
    public void insertValues(Person p, AddressBookService s, AddressBook a, Integer i) {
            System.out.println("Set the values:");
            s.setValues(p);
            System.out.println(s.display(p));
            a.contactList.put(i, p);
    }


}
