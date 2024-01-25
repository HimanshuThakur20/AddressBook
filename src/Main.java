import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("\nWelcome to the Address book\n");
        Person p1 = new Person();
        AddressBookService s1 = new AddressBookService();
        AddressBook a1 = new AddressBook();

        System.out.println("Set the values:");
        s1.setValues(p1);
        System.out.println(s1.display(p1));

        a1.contactList.put(1,p1);
        System.out.println(a1.contactList);

        boolean check1=false;

        System.out.println("Do you want to edit details(true/false)");
        check1 = sc.nextBoolean();
        if(check1) {
            System.out.println("Enter the first name of person to be edited:");
            String searchName = sc.next();
            s1.editDetails(searchName, p1);
        }

        boolean check2=false;

        System.out.println("Do you want to edit details(true/false)");
        check2 = sc.nextBoolean();
        if(check2) {
            System.out.println("Enter the first name of person to be deleted:");
            String removeName = sc.next();
            s1.removeDetails(removeName, p1);
        }

    }
}
