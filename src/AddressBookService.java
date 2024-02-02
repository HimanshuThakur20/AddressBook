import java.util.*;


public class AddressBookService {
    public String display(Person p){
        System.out.println("\nYou entered these values- ");
        return p.getFirstName()+" "+p.getLastName()+" "+p.getEmail()+" "+p.getCity()+" "+p.getState()+" "+p.getZip()+" "+p.getPhoneNumber()+"\n";
    }

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

        System.out.println("Enter your email: ");
        String email = sc.next();
        p.setEmail(email);

        try{
            System.out.println("Enter your zip code: ");
            Integer zip = Integer.valueOf(sc.next());
            p.setZip(zip);
        }catch(NumberFormatException e){
            System.out.println("\nKindly put an integer value otherwise next time program will be terminated");
            System.out.println("Enter your zip code: ");
            Integer zip = Integer.valueOf(sc.next());
            p.setZip(zip);
        }

        try{
            System.out.println("Enter your phone number: ");
            Integer phn = Integer.valueOf(sc.next());
            p.setPhoneNumber(phn);
        }catch(NumberFormatException e){
            System.out.println("\nKindly put an integer value otherwise next time program will be terminated");
            System.out.println("Enter your phone number: ");
            Integer phn = Integer.valueOf(sc.next());
            p.setPhoneNumber(phn);
        }

    }

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

    public void displayAdressBook(ArrayList<AddressBook> addressBooks){
        Integer count =1;
        for (AddressBook addressBook : addressBooks){
            System.out.println("\n\n*** Address Book "+count+"***");
            System.out.println(addressBook);
            count++;
        }
    }
}



//previous code used for deleting which threw exception ConcurrentModificationException
//        for(Map.Entry<Integer,Person> entry : a.contactList.entrySet()) {
//            if (entry.getValue().getFirstName().equalsIgnoreCase(nameToRemove)) {
////                Integer key=entry.getKey();
////                a.contactList.remove(key);
//                entry.remove();
//                System.out.println("Details deleted");
//            } else {
//                System.out.println("value not found");
//            }
//        }