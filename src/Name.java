public class Name {
    private String firstName;
    private String lastName;

    public Name(String first, String last) {
        firstName = first;
        lastName = last;
    }

    private String getFirstName() {
        return firstName;
    }

    private String getLastName() {
        return lastName;
    }

    public String fullname() {
        return lastName + ", " + firstName;
    }

    public boolean match(Name other) {
        return firstName.toLowerCase().matches(other.getFirstName().toLowerCase())
                && lastName.toLowerCase().matches(other.getLastName().toLowerCase());
    }

    public boolean isLessThan(Name other) {
        if (lastName.toLowerCase().compareTo(other.getLastName().toLowerCase()) < 0) {
            return true;
        } else {
            if (lastName.toLowerCase().matches(other.getLastName().toLowerCase())) {
                return firstName.toLowerCase().compareTo(other.getFirstName().toLowerCase()) < 0;
            }
        }
        return false;
    }

    public String toString() {
        return "first name: " + firstName + "last name: " + lastName;
    }
}
