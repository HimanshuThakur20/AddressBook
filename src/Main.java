import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<AddressBook> addressBooks = new ArrayList<>(3);
        Scanner sc = new Scanner(System.in);
        Main m1 = new Main();
        AddressBookService s1 = new AddressBookService();

        System.out.println("\n### Welcome to the address book system ###\n");
        while (true) {
            System.out.println("\nEnter what you want to perform---- \n" +
                    "1-Enter values in 1 address book \n" +
                    "2- Enter values in specified no of address books\n" +
                    "3- Update values using name in an specefied address book\n" +
                    "4- Delete a entry using name in an specefied address book)\n" +
                    "5- Display the address books\n" +
                    "0- Exit the address book system");
            int choice = sc.nextInt();

            switch (choice) {
                case 0:
                    System.out.println("***** Hope you liked our address book system *****");
                    System.exit(0);
                    break;
                case 1:
                    AddressBook adb = new AddressBook();
                    m1.createAddressBook(adb);
                    addressBooks.add(adb);
                    break;
                case 2:
                    System.out.println("Enter the no of address books you want to enter:");
                    Integer numberOfElements = sc.nextInt();
                    for (Integer i = 0; i < numberOfElements; i++) {
                        AddressBook addressBook = new AddressBook();
                        m1.createAddressBook(addressBook);
                        addressBooks.add(addressBook);
                    }
                    break;
                case 3:
                    boolean check1=false;
                    System.out.println("Do you want to edit details(true/false)");
                    check1 = sc.nextBoolean();
                    if(check1) {
                        System.out.println("Enter the first name of person to be edited:");
                        String searchName = sc.next();
                        System.out.println("Enter the address book number you want to edit in:");
                        int position = sc.nextInt();
                        if(addressBooks.get(position-1).contactList.isEmpty()) {
                            System.out.println("No addressbook found of that number");
                        }else {
                            s1.editDetails(searchName, addressBooks.get(position-1));
                        }
                        System.out.println("\n\nUpdated hashmap:");
                        for (Map.Entry<Integer, Person> entry : addressBooks.get(position-1).contactList.entrySet()) {
                            System.out.println(entry.getKey() + ": " + entry.getValue());
                        }
                    }

                    break;
                case 4:
                    boolean check2=false;
                    System.out.println("Do you want to delete details(true/false)");
                    check2 = sc.nextBoolean();
                    if(check2) {
                        System.out.println("Enter the first name of person name to be deleted:");
                        String removeName = sc.next();
                        System.out.println("Enter the address book number you want to delete in:");
                        int position = sc.nextInt();
                        if(addressBooks.get(position-1).contactList.isEmpty()) {
                            System.out.println("No addressbook found of that number");
                        }else {
                            s1.removeDetails(removeName, addressBooks.get(position-1));
                        }
                        System.out.println("\n\nUpdated hashmap:");
                        for (Map.Entry<Integer, Person> entry : addressBooks.get(position-1).contactList.entrySet()) {
                            System.out.println(entry.getKey() + ": " + entry.getValue());
                        }
                    }
                    break;
                case 5:
                    System.out.println("Displaying all address books");
                    s1.displayAdressBook(addressBooks);
                    break;
                default:
                    System.out.println("Invalid entry");
                    break;
            }
        }




    }

    //Function creating the address book
    public  void createAddressBook(AddressBook a1){
        Scanner sc = new Scanner(System.in);
        System.out.println("\nWelcome to the Address book\n");
        AddressBookService s1 = new AddressBookService();
        Main m1 = new Main();

        System.out.println("How many address details you want to keep in the book (Please enter an integer)");
        int noOfAddresses = sc.nextInt();

        for (int i = 1; i <= noOfAddresses;i++) {
            Person p1 = new Person();
            m1.insertValues(p1, s1, a1, i);
        }

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
