import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class PatientIdentityTest {

    @Test
    void getName() {
    }

    @Test
    void getDateOfBirth() {
    }

    @Test
    void match() {
        String first = new String();
        String last = new String();
        Name name = new Name(first, last);
        Date dob = new Date();
        PatientIdentity other = new PatientIdentity(name, dob);
        assertTrue(name.match(other.getName()) && dob.equals(other.getDateOfBirth()));
    }

    @Test
    void isLessThan() {
        String first = new String();
        String last = new String();
        Name name = new Name(first, last);
        Date dob = new Date();
        PatientIdentity other = new PatientIdentity(name, dob);
        if (name.isLessThan(other.getName())) {
            assertTrue(true);
        }
        else {
            if (name.match(other.getName())){
                assertTrue(dob.compareTo(other.getDateOfBirth()) < 0);
            }
        }
    }

    @Test
    void testToString() {
    }
}