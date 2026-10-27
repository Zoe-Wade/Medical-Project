import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


public class Patient {
    private static final SimpleDateFormat DATE_TIME_FORMATTER = new SimpleDateFormat("dd-MM-yyyy");

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

    public String toCSV() {
        return identity.getName().getLastName()
                + "," + identity.getName().getFirstName()
                + "," + DATE_TIME_FORMATTER.format(identity.getDateOfBirth());
    }

    public static Patient fromCSV(String CSV) {
        String[] tokens = CSV.split(",");
        if (tokens.length != 3) {
            return null;
        }

        try {
            Date parsedDate = DATE_TIME_FORMATTER.parse(tokens[2]);
            Name name = new Name(tokens[1], tokens[0]);
            PatientIdentity identity = new PatientIdentity(name, parsedDate);
            return new Patient(identity, new PrescriptionList());
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}