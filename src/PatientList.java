import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Date;

class PatientList {
    public class Iterator {
        int iteratonIndex = 0;

        public Iterator() {
            Iterator iter1 = list1.new Iterator();
            Iterator iter2 = list2.new Iterator();
            while (iter1.peek() != null && iter2.peek() != null) {
                if (iter1.peek().getIdentity().isLessThan(iter2.peek().getIdentity())) {
                    merged.append(iter1.next().csvString());
                } else {
                    merged.append(iter2.next().csvString());
                }
            }
        }

        public Patient peek() {
            if (iteratonIndex < patients.length) {
                return patients[iteratonIndex];
            } else {
                return null;
            }
        }

        public Patient next() {
            if (iteratonIndex < patients.length || patients[iteratonIndex] == null) {
                return null;
            } else {
                Patient pat = patients[iteratonIndex];
                return pat;
            }
        }

        List mergesort(Iterator list) {
            return null;
        }
    }

    PatientList list1, list2;
    PatientList.Iterator iter1 = list1.new Iterator();
    PatientList.Iterator iter2 = list2.new Iterator();
    Patient patient;
    private Patient[] patients = null;
    private final int MAX_PATIENTS = 1000;

    public PatientList() {
        patients = new Patient[MAX_PATIENTS];
    }

    public int getMAX_PATIENTS() {
        return MAX_PATIENTS;
    }

    // Adds a patient to the database. Returns true if this succeeds, false otherwise.
    public boolean add(Patient pat) {
        return addOrdered(pat);
    }

    // Returns Patient matching the given identity, null if not found.
    public Patient find(PatientIdentity id) {
        return binarySearch(id);
    }

    private boolean addOrdered(Patient pat) {
        int currentIndex = MAX_PATIENTS;
        while (currentIndex >= 0 && patients[currentIndex] < patients[currentIndex - 1]) {
            //move patient at current_index to current_index +1
            // at this point, element currentIndex is empty
            currentIndex--;
            add(patients[currentIndex]);
        }
// we are now at a patient who does not come after us. add patient to slot currentIndex+1
        add(pat);
        return false;
    }

    private Patient binarySearch(PatientIdentity id) {
        int upper = MAX_PATIENTS;
        int lower = 0;
        int mid = (upper + lower) / 2;
        while (upper >= lower) {
            if (patients[mid].getIdentity().match(id)) {
                return patients[mid];
            }
            if (patients[mid].getIdentity().isLessThan(id)) {
                lower = mid + 1;
            } else {
                upper = mid - 1;
            }
        }
        return null;
    }

    Patient linearSearch(PatientIdentity id) {
        Patient pat = null;
        PatientList.Iterator iter = this.new Iterator();
        while ((pat = iter.next()) != null) {
//            if this patient matches the identity, this is the one you want
            if (this.patient.equals(id)) {
                return pat;
            }
        }
        return null;
    }

    static Patient makePatient(String line, Patient newPatient) {
        File inputFile = new File(line);
        System.out.println(line);

        Scanner scanner = null;
        try {
            scanner = new Scanner(inputFile);
        } catch (FileNotFoundException e) {
            System.out.print("File could not be opened.");
            return null;
        }

        // This is a comment. It can be removed.
        while (scanner.hasNextLine()) {
            String nextLine = scanner.nextLine();
            String[] CSV = nextLine.split(",");

            String lastName = CSV[0];
            String firstName = CSV[1];
            Date dateOfBirth = Date.parse(CSV[2]);
            Name name = new Name(CSV[1], CSV[0]);

            PatientIdentity identity = new PatientIdentity(name, dateOfBirth);
            newPatient = new Patient(identity);
            return newPatient;
        }
        return newPatient;
    }

}
