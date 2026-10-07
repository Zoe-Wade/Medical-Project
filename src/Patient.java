import java.io.File;
import java.io.IOException;
import java.util.Scanner;


public class Patient {
    private PatientIdentity identity = null;

    public Patient(PatientIdentity id) {
        this.identity = id;
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
}