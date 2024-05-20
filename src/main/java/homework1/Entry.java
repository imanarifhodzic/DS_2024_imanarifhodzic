package homework1;

public class Entry implements Comparable<Entry> {
    //public class Entry: Declares a public class named Entry.
    //implements Comparable<Entry>: Indicates that the Entry class implements the Comparable interface, allowing Entry objects to be compared to each other.
    // implement the relevant data attributes
    String name;
    String streetAddress;
    String city;
    String postcode;
    String country;
    String phoneNumber;

    public Entry(String name, String streetAddress, String city, String postcode, String country, String phoneNumber) {
        this.name = name;
        this.streetAddress = streetAddress;
        this.city = city;
        this.postcode = postcode;
        this.country = country;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public int compareTo(Entry that) {

        return this.name.compareTo(that.name);
        //Compares the name attribute of the current Entry object (this) with
        // the name attribute of another Entry object (that)
    }
}

//Isto sto sam na prethodnom zadatku uradila, objasnjenje svega ukupno:
//The Entry class represents a user with attributes such as name, streetAddress, city, postcode, country, and phoneNumber.
//The class implements the Comparable<Entry> interface, allowing Entry objects to be compared based on their name attribute.
//The compareTo method provides the comparison logic, using the natural ordering of the String class to compare names.
