import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class AddressBookService {

    // method that displays the values stored in objects of calss person
    public void display(Person p){
        System.out.println("\nYou entered these values- ");
//        return p.getFirstName()+" "+p.getLastName()+" "+p.getEmail()+" "+p.getCity()+" "+p.getState()+" "+p.getZip()+" "+p.getPhoneNumber()+"\n";
        System.out.println(p);
        return;
    }

    // method to enter the values in class person
    public void setValues(Person p){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your first name: ");
        String fn = sc.next();
        p.setFirstName(fn);

        System.out.println("Enter your last name: ");
        String ln = sc.next();
        p.setLastName(ln);

        System.out.println("Enter your city name: ");
        String city  = sc.next();
        p.setCity(city);

        System.out.println("Enter your State name: ");
        String state = sc.next();
        p.setState(state);


        Pattern emialPattern = Pattern.compile("^[^\\s@]+@[^\\s@]+\\.[^\\s@]+$");
        do{
            System.out.println("Enter your email: ");
            String email = sc.nextLine();
            Matcher matcher = emialPattern.matcher(email);
            if(matcher.matches()){
                p.setEmail(email);
                break;
            }else{
                System.out.println("\nPlease input a proper email address with '@'");
            }

        }while (true);

        Pattern zipPattern = Pattern.compile("^[0-9]{6}+$");
        while(true) {
            try {
                System.out.println("Enter your zip code: ");
                String zip = sc.nextLine();
                Matcher matcher = zipPattern.matcher(zip);
                if(matcher.matches()){
                    p.setZip(zip);
                }else {
                    throw new NumberFormatException();
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("\nKindly put an integer value");
//                sc.nextLine();
            }
        }

//        try{

        Pattern phnpattern = Pattern.compile("^[7-9]{1}[0-9]{9}+$");
        do {
            System.out.println("Enter your phone number: ");
            String phn = sc.next();
            Matcher matcher = phnpattern.matcher(phn);
            if (matcher.matches()) {
                p.setPhoneNumber(phn);
                break;
            } else {
                System.out.println("\nPlease input 10 digit phone no. starting from 7-9");
            }
        }while (true);


//        }catch(NumberFormatException e){
//            System.out.println("\nKindly put an integer value otherwise next time program will be terminated");
//            System.out.println("Enter your phone number: ");
//            String phn = sc.next();
//            p.setPhoneNumber(phn);
//        }

    }

    //main editing method that edits details directly in the hashmap
    public void editDetails(String searchName, AddressBook a1){
        for(Map.Entry<Integer, Person> entry : a1.contactList.entrySet()) {
            if(entry.getValue().getFirstName().equalsIgnoreCase(searchName)){
                System.out.println("\n***Person found***");
                Person p = new Person();
                System.out.println("\nEnter new details");
                setValues(p);
                Integer key = entry.getKey();
                a1.contactList.put(key,p);
                return;
            }
            System.out.println("value not found");

        }

    }

    //main deleting method that edits details directly in the hashmap
    public void removeDetails(String nameToRemove, AddressBook a){
        Iterator<Map.Entry<Integer,Person>> iterator = a.contactList.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<Integer,Person> entry = iterator.next();
            if(entry.getValue().getFirstName().equalsIgnoreCase(nameToRemove)){
                iterator.remove();
                System.out.println("Details deleted");
                return;
            }
            System.out.println("value not found");

        }
    }

    //function that inserts addresses and calls other required funtions
    public void insertAddress(ArrayList<AddressBook> addressBooks){
        AddressBook adb = new AddressBook();
        createAddressBook(adb);
        addressBooks.add(adb);
    }

    //Function creating the address book
    public  void createAddressBook(AddressBook a1){
        Scanner sc = new Scanner(System.in);
        System.out.println("\nWelcome to the Address book\n");
        AddressBookService s1 = new AddressBookService();

        System.out.println("How many address details you want to keep in the book (Please enter an integer)");
        int noOfAddresses;
        while(true) {
            try {
                noOfAddresses = sc.nextInt();
                break;
            } catch (Exception e) {
                System.out.println("\nPlease enter a number");
                sc.nextLine();
            }
        }

        for (int i = 1; i <= noOfAddresses;i++) {
            Person p1 = new Person();
            insertValues(p1, s1, a1, i);
        }

        for (Map.Entry<Integer, Person> entry : a1.contactList.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

    }

    //Function for entering values in the hashmap
    public void insertValues(Person p, AddressBookService s, AddressBook a, Integer i) {
        System.out.println("Set the values:");
        s.setValues(p);
        s.display(p);
        a.contactList.put(i, p);
    }

    public void displayAdressBook(ArrayList<AddressBook> addressBooks){
        Integer count =1;
        for (AddressBook addressBook : addressBooks){
            System.out.println("\n\n*** Address Book "+count+" ***");
            System.out.println(addressBook);
            count++;
        }
    }

    public void callEdit(ArrayList<AddressBook> addressBooks){
        Scanner sc = new Scanner(System.in);

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
                editDetails(searchName, addressBooks.get(position-1));
            }
            System.out.println("\n\nUpdated hashmap:");
            for (Map.Entry<Integer, Person> entry : addressBooks.get(position-1).contactList.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }
    }

    public void callDelete(ArrayList<AddressBook> addressBooks){
        Scanner sc = new Scanner(System.in);

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
                removeDetails(removeName, addressBooks.get(position-1));
            }
            System.out.println("\n\nUpdated hashmap:");
            for (Map.Entry<Integer, Person> entry : addressBooks.get(position-1).contactList.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }
    }
}
