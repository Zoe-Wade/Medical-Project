import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertTrue;

class PatientListTest {
    Patient patient;
    Patient[] patients;
    final int MAX_PATIENTS = 1000;

    @Test
    void getMAX_PATIENTS() {
    }

    @Test
    void add() {
        Patient pat = null;
        PatientList list = new PatientList();
        assertTrue(list.add(pat));
    }

    @Test
    void find() {
        String first = new String();
        String last = new String();
        Name name = new Name(first, last);
        Date dob = new Date();
        PatientIdentity pId = new PatientIdentity(name, dob);
        PrescriptionList prescriptionList = null;
        PatientList list = new PatientList();
        Patient pat = new Patient(pId, prescriptionList);
        list.binarySearch(pId);
        assertTrue(list.find(pId));
    }

    @Test
    void addOrdered() {
    }

    @Test
    void binarySearch() {
        String first = new String();
        String last = new String();
        Name name = new Name(first, last);
        Date dob = new Date();
        PatientIdentity pId = new PatientIdentity(name, dob);
        PrescriptionList prescriptionList = null;
        PatientList list = new PatientList();
        Patient[] patients;
        int upper = MAX_PATIENTS;
        int lower = 0;
        int mid = (upper + lower) / 2;
//        assertTrue(list.binarySearch(pId));
    }

    @Test
    void linearSearch() {
        String first = new String();
        String last = new String();
        Name name = new Name(first, last);
        Date dob = new Date();
        PatientIdentity pId = new PatientIdentity(name, dob);
        PrescriptionList prescriptionList = null;
        PatientList list = null;
        Patient pat = null;
        PatientList.Iterator iter;
//        assertTrue(list.linearSearch(pId));
    }

    @Test
    void testIO() {
        PatientList list = new PatientList();
        list.importFromFile("patients.txt");
        list.saveToFile("patientexport.txt");
    }
}