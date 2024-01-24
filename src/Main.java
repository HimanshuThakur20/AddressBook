public class Main {
    public static void main(String[] args) {
        System.out.println("\nWelcome to the Address book\n");
        Person p1 = new Person();
        AddressBookService s1 = new AddressBookService();
        AddressBook a1 = new AddressBook();

        System.out.println("Set the values:");
        s1.setValues(p1);
        System.out.println(s1.display(p1));

        a1.contactList.put(1,p1);
        System.out.println(a1.contactList);

    }
}
