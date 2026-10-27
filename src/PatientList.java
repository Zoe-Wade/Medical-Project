import java.awt.*;
import java.io.*;
import java.util.Date;
import java.util.Scanner;

class PatientList {
    public class Iterator {
        int iteratonIndex = 0;

        public Iterator() {
            Iterator iter1 = list1.new Iterator();
            Iterator iter2 = list2.new Iterator();
            while (iter1.peek() != null && iter2.peek() != null) {
                if (iter1.peek().getIdentity().isLessThan(iter2.peek().getIdentity())) {
                    this.append(iter1.next());
                } else {
                    this.append(iter2.next());
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
            PatientList patientList;
            Iterator iter;
            if (iteratonIndex < patients.length || patients[iteratonIndex] == null) {
                return null;
            } else {
                Patient pat = patients[iteratonIndex];
                return pat;
            }
        }

        protected Patient append(Patient patient) {
            if (iteratonIndex < patients.length) {
                iteratonIndex++;
                add(patient);
            }
            return patient;
        }

        List mergesort(Patient[] finalList) {
            int index1 = 0;
            int index2 = 0;
            int[] list1 = null;
            int[] list2 = null;
            while (index1 < list1.length && index2 < list2.length) {
                if (list1[index1] < 2 && list2[index2] < 2) {

                }
                if (list1[index1] < list2[index2]) {
                    add(finalList[list1[index1]]);
                    index1++;
                }
                else {
                    if (list2[index2] < list1[index1]) {
                        add(finalList[list2[index2]]);
                        index2++;
                    }
                }
            }
            return mergesort(finalList);
        }
    }

    PatientList list1, list2;
    Iterator iter1 = list1.new Iterator();
    Iterator iter2 = list2.new Iterator();
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
        while (currentIndex >= 0 && patients[currentIndex].getIdentity().isLessThan(pat.getIdentity())) {
            //move patient at current_index to current_index +1
            // at this point, element currentIndex is empty
            currentIndex--;
            add(patients[currentIndex]);
        }
// we are now at a patient who does not come after us. add patient to slot currentIndex+1
        add(pat);
        return false;
    }

    public Patient binarySearch(PatientIdentity id) {
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
        Iterator iter = this.new Iterator();
        while ((pat = iter.next()) != null) {
//            if this patient matches the identity, this is the one you want
            if (this.patient.equals(id)) {
                return pat;
            }
        }
        return null;
    }

    public boolean saveToFile(String filename) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(filename);
            Iterator iter = this.new Iterator();
            while (iter.next() != null) {
                writer.write(iter.next().toCSV() + "\n");
            }
            writer.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean importFromFile( String filename) {
        Scanner scanner = null;
        File file = new File(filename);
        try {
            scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                Patient p = Patient.fromCSV(scanner.nextLine());
                if (p != null) {
                    add(p);
                }
            }
            scanner.close();
            return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }
}
