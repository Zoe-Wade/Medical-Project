import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class PatientTest {

    @Test
    void getIdentity() {
        String first = new String();
        String last = new String();
        Name name = new Name(first, last);
        Date dob = new Date();
        PatientIdentity id = new PatientIdentity(name, dob);
        Patient pat = new Patient(id);
        assertTrue(pat.getIdentity().match(id));
    }

    @Test
    void testToString() {
    }
}