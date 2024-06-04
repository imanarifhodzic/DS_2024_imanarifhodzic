package homework3;

public class Entry implements Comparable<Entry> {
    // implement the relevant data attributes
    private String name;
    private String street_address;
    private String city;
    private String postcode;
    private String country;
    private String phone_number;

    public Entry(String name, String streetAddress, String city, String postcode, String country, String phoneNumber) {
        //The below part initializes the instance variables with the values passed to the constructor.
        this.name = name;
        this.street_address = streetAddress;
        this.city = city;
        this.postcode = postcode;
        this.country = country;
        this.phone_number = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getStreetAddress() {
        return street_address;
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
        return phone_number;
    }

    @Override
    //Now for this, I Override the compareTo method from the Comparable interface to let comparison of Entry objects based on the name attribute.
    public int compareTo(Entry other) {
        // implement the actual compareTo logic (remove next line)
        return this.name.compareTo(other.name);
    }
    @Override
    //However, this Overrides the toString method to provide a string representation of the Entry object.
    public String toString() {
        return "Name: " + this.name + "\n" +
                "Street Address: " + this.street_address + "\n" +
                "City: " + this.city + "\n" +
                "Postal code: " + this.postcode + "\n" +
                "Country: " + this.country + "\n" +
                "Phone Number: " + this.phone_number + "\n";
    }
}