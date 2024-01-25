import java.util.Objects;
import java.util.Scanner;

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

        System.out.println("Enter your zip code: ");
        Integer zip = Integer.valueOf(sc.next());
        p.setZip(zip);

        System.out.println("Enter your phone number: ");
        Integer phn = Integer.valueOf(sc.next());
        p.setPhoneNumber(phn);
    }

    public void editDetails(String searchKey,Person p){

        if(Objects.equals(p.getLastName(), searchKey)){
            System.out.println("Enter new details: ");
            setValues(p);
            display(p);
        }
        else{
            System.out.println("value not found");
        }
    }
}
