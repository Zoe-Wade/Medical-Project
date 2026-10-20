import java.io.File;
import java.io.FileNotFoundException;
import java.util.Date;
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

    public PatientIdentity toCSV(PatientIdentity newIdentity) {
        String line = "patients.txt";
        File inputFile = new File(line);
        System.out.println(line);

        Scanner scanner = null;
        try {
            scanner = new Scanner(inputFile);
        } catch (FileNotFoundException e) {
            System.out.print("File could not be opened.");
            return null;
        }

        while (scanner.hasNextLine()) {
            String nextLine = scanner.nextLine();
            String[] CSV = nextLine.split(",");

            String lastName = CSV[0];
            String firstName = CSV[1];
            Date dateOfBirth = Date.parse(CSV[2]);
            Name name = new Name(CSV[1], CSV[0]);

            PatientIdentity identity = new PatientIdentity(name, dateOfBirth);
            identity = newIdentity;
            return newIdentity;
        }
        return newIdentity;
    }
}