import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class PatientListTest {
    Patient patient;
    Patient[] patients;
    final int MAX_PATIENTS = 1000;
    PatientIdentity pId = null;

    @Test
    void getMAX_PATIENTS() {
    }

    @Test
    void add() {
        Patient pat = null;
        assertTrue(add(pat));
    }

    @Test
    void find() {
        assertTrue();
    }

    @Test
    void binarySearch() {
        int upper = MAX_PATIENTS;
        int lower = 0;
        int mid = (upper + lower) / 2;
        assertTrue(patients[mid].getIdentity().isLessThan(pId));
    }

    @Test
    void linearSearch() {
        PatientIdentity pId = null;
        Patient pat = null;
        PatientList.Iterator iter;
        assertTrue(this.patient.equals(pId));
    }
}