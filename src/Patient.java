import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;


public class Patient {
    private PatientIdentity identity = null;
    public PrescriptionList prescriptionList = null;

    public Patient(PatientIdentity id, PrescriptionList prescList) {
        this.identity = id;
        this.prescriptionList = prescList;
    }

    public Patient(Patient otherPatient) {
        this.identity = otherPatient.identity;
    }

    public PatientIdentity getIdentity() {
        return identity;
    }

    public String toString() {
        return "identity: " + identity.toString();
    }

    public Patient toCSV(Patient newPatient) {
        String line = "patients.txt";
        File inputFile = new File(line);
        System.out.println(line);

        Scanner scanner = null;
        try {
            scanner = new Scanner(inputFile);
            PatientList.Iterator iter = null;
        } catch (FileNotFoundException e) {
            System.out.print("File could not be opened.");
            return null;
        }

        while (scanner.hasNextLine()) {
            newPatient = new Patient(identity.toCSV());
        }
        return newPatient;

        Patient output = new Patient(identity.toCSV(getIdentity()), prescriptionList);
        return output;
    }
}