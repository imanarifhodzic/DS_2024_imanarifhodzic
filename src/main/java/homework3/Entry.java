package homework3;

public class Entry implements Comparable<Entry> {
    // implement the relevant data attributes
    private String surname;
    private String name;
    private String streetAddress;
    private String city;
    private String postcode;
    private String country;
    private String phoneNumber;

    public Entry(String surname, String name, String streetAddress, String city, String postcode, String country, String phoneNumber) {
        //The below part initializes the instance variables with the values passed to the constructor.
        this.surname = surname;
        this.name = name;
        this.streetAddress = streetAddress;
        this.city = city;
        this.postcode = postcode;
        this.country = country;
        this.phoneNumber = phoneNumber;
    }

    @Override
    //This Overrides the toString method to provide a string representation of the Entry object.
    public String toString(){
        return  "\nName: " + this.surname + ", " + this.name
                + "\nAddress: " + this.streetAddress
                + "\nCity: " + this.city
                + "\nPost Code: " + this.postcode
                + "\nCountry: " + this.country
                + "\nPhone Number: " + this.phoneNumber + "\n";
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public String getCity() {
        return city;
    }

    public String getPostcode() {
        return postcode;
    }

    public String getCountry() {
        return country;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    //Now for this, I Override the compareTo method from the Comparable interface to let comparison of Entry objects based on the name attribute.
    public int compareTo(Entry other) {
        // implement the actual compareTo logic (remove next line)
        int surnameComparison = this.surname.compareTo(other.surname);
        if (surnameComparison != 0) {
            return surnameComparison;
        }
        return this.name.compareTo(other.name);
    }
}