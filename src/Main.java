import java.io.*;
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
            System.out.println("\n Enter what you want to perform---- \n" +
                    "1-Enter values in 1 address book \n" +
                    "2- Enter values in specified no of address books\n" +
                    "3- Update values using name in an specified address book\n" +
                    "4- Delete a entry using name in an specified address book)\n" +
                    "5- Display the address books\n" +
                    "6- Save Address books into a txt file\n" +
                    "7- Retrive address books from a txt file\n" +
                    "8- Search for all the persons in a city or state\n" +
                    "0- Exit the address book system");
            int choice = sc.nextInt();

            switch (choice) {
                case 0:
                    System.out.println("***** Hope you liked our address book system *****");
                    System.exit(0);
                    break;
                case 1:
                    s1.insertAddress(addressBooks);
                    break;
                case 2:
                    System.out.println("Enter the no of address books you want to enter:");
                    Integer numberOfElements = sc.nextInt();
                    for (Integer i = 0; i < numberOfElements; i++) {
                        s1.insertAddress(addressBooks);
                    }
                    break;
                case 3:
                    s1.callEdit(addressBooks);
                    break;
                case 4:
                    s1.callDelete(addressBooks);
                    break;
                case 5:
                    System.out.println("Displaying all address books");
                    s1.displayAdressBook(addressBooks);
                    break;
                case 6:
                    String fileName = "AddressBook.txt";
                    s1.fileHandler(fileName,true,addressBooks);
                    break;
                case 7:
                    String fileName2 = "AddressBook.txt";
                    s1.fileHandler(fileName2,false,addressBooks);
                    break;
                case 8:
                    s1.searchByCityNState(addressBooks);
                    break;
                default:
                    System.out.println("Invalid entry");
                    break;
            }
        }

    }


}
