import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertTrue;

class PatientListTest {

    @Test
    void getNumPatients() {
    }

    @Test
    void add() {
        Patient pat = null;
        PatientList list = new PatientList();
        assertTrue(list.add(pat));
    }

    @Test
    void find() {
        String first = "John";
        String last = "Doe";
        Name name = new Name(first, last);
        Date dob = new Date();
        PatientIdentity pId = new PatientIdentity(name, dob);
        PatientList list = new PatientList();
        Patient pat = new Patient(pId, null);
        list.add(pat);
        assertTrue(list.find(pId).getIdentity().match(pId));
    }

    @Test
    void linearSearch() {
        String first = "John";
        String last = "Doe";
        Name name = new Name(first, last);
        Date dob = new Date();
        PatientIdentity pId = new PatientIdentity(name, dob);
        PatientList list = new PatientList();
        Patient pat = new Patient(pId, null);
        list.add(pat);
        assertTrue(list.linearSearch(pId).getIdentity().match(pId));
    }

    @Test
    void testIO() {
        PatientList list = new PatientList();
        list.importFromFile("patients.txt");
        list.saveToFile("patientexport.txt");
    }
}