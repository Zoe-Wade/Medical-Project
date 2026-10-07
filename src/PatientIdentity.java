import java.util.Date;
import java.util.Random;
import java.util.random.RandomGenerator;
import java.util.Scanner;

public class PatientIdentity {
    private Name name = null;
    private Date dateOfBirth;

    public PatientIdentity(Name nm, Date dob) {
        name = nm;
        dateOfBirth = dob;
    }

    public Name getName() {
        return name;
    }

    Date getDateOfBirth() {
        return dateOfBirth;
    }

    public boolean match(PatientIdentity other) {
        return name.match(other.getName()) && dateOfBirth.equals(other.getDateOfBirth());
    }

    public boolean isLessThan(PatientIdentity other) {
        if (name.isLessThan(other.getName())) {
            return true;
        } else {
            if (name.match(other.getName())) {
                return dateOfBirth.compareTo(other.getDateOfBirth()) < 0;
            }
        }
        return false;
    }

    public String toString() {
        return "name: " + name.toString() + " dob: " + dateOfBirth.toString();
    }
}