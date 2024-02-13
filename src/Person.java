public class Person {
    private String firstName;
    private String lastName;
    //String fullAddress;
    private String State;
    private String city;
    private String email;
    private String zip;
    private String phoneNumber;

//    public Person(String firstName, String lastName, String state, String city, String email, Integer zip, Integer phoneNumber) {
//        this.firstName = firstName;
//        this.lastName = lastName;
//        State = state;
//        this.city = city;
//        this.email = email;
//        this.zip = zip;
//        this.phoneNumber = phoneNumber;
//    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Person " +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", State='" + State + '\'' +
                ", city='" + city + '\'' +
                ", email='" + email + '\'' +
                ", zip=" + zip +
                ", phoneNumber=" + phoneNumber + "\n";
    }
}
