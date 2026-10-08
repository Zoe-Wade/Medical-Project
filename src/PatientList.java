import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Date;

class PatientList {
    public class Iterator {
// JS: Watch the spelling: it is "iteration." The computer doesn't care, but people reading your code will.
// Note, with class members it is generally better to initialize them in the constructor, so we can see
// all the initializations in one place.  
        int iteratonIndex = 0;

        public Iterator() {
// JS This is the main part of the merge algorithm, but it does not belond here at all. 
// In fact it would not compile, as "merged" is not defined.  
// All the iterator's constructor should do is initialize the iteration index. 
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

// JS: A merge sort routine would not be in the Iterator class, although you might well use an iterator to do it.  
        List mergesort(Iterator list) {
            return null;
        }
    }

// JS: This looks like stray code.  It does not make sense for a class to contain two more members of itself.
    PatientList list1, list2;
// JS: There's no reason to have these here. Iterators, in any case, seldom make sense as class members.
// They are created for particular purposes and used.  We don't keep them around.   
    PatientList.Iterator iter1 = list1.new Iterator();
    PatientList.Iterator iter2 = list2.new Iterator();
 // JS: what is this?
    Patient patient;

// JS: I know what this is, but it is good to comment important class members so we know what they are. 
    private Patient[] patients = null;
    private final int MAX_PATIENTS = 1000;

    public PatientList() {
        patients = new Patient[MAX_PATIENTS];
    }

// JS: This should not be in a public method.  Once we switch to trees, there will not be any maximum.
// The fact that there is one right now is just because we are using an array.  Don't build that assumption
// into your public facing methods, in any way.  
    public int getMAX_PATIENTS() {
        return MAX_PATIENTS;
    }

// JS: Very good description. It is good to have this sort of description on each public method.  
    // Adds a patient to the database. Returns true if this succeeds, false otherwise.
    public boolean add(Patient pat) {
// JS: Very good -- delegating the work to this other method.  Correct strategy. 
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

// JS: Better to use the actual patients.length
        int upper = MAX_PATIENTS;
        int lower = 0;

// JS: This next line has to be inside the while loop.  That is how the search function, recomputing mid each time. 
// Either this was not tested, or it was tested on a collection of 1 or 2 patients and happened to work. 
// It would fail (in fact, loop endlessly) on any larger set.  
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

// JS: this is a nice method, a good example of 'eat our own dog food'
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

// JS: this method is very confused about what it is doing.
// It clearly means to be making one Patient, but then it sets up a Scanner to read 
// multiple lines of a file, which would mean creation of multiple patients.
// the argument "line" would make sense if that were read from a file elsehwhere,
// but newPatient makes no sense.  
    static Patient makePatient(String line, Patient newPatient) {

// JS: Hmm? the line is the name of the file?
        File inputFile = new File(line);
        System.out.println(line);

        Scanner scanner = null;
        try {
            scanner = new Scanner(inputFile);
        } catch (FileNotFoundException e) {
            System.out.print("File could not be opened.");
            return null;
        }

// JS: Please remove this next line. I put it there when we were working in office time. 
        // This is a comment. It can be removed.
        while (scanner.hasNextLine()) {
            String nextLine = scanner.nextLine();
            String[] CSV = nextLine.split(",");

// JS: can't assume these two references work. What if the line is empty or contains just one token?
            String lastName = CSV[0];
            String firstName = CSV[1];

// JS: This should be done with a SimpleDateFormat set to match the format in the file. 
// Note, you will need a try/catch to catch ParseException
            Date dateOfBirth = Date.parse(CSV[2]);
            Name name = new Name(CSV[1], CSV[0]);

            PatientIdentity identity = new PatientIdentity(name, dateOfBirth);
            newPatient = new Patient(identity);

// JS: If we are returning here then a while loop would not make sense 
            return newPatient;
        }
// JS: ????
        return newPatient;
    }

}
