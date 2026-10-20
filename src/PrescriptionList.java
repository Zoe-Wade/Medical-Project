import java.awt.*;

public class PrescriptionList {

    public class Iterator {
        int iteratonIndex = 0;

        public Iterator() {
            PrescriptionList.Iterator iter1 = list1.new Iterator();
            PrescriptionList.Iterator iter2 = list2.new Iterator();
            while (iter1.peek() != null && iter2.peek() != null) {
                if (iter1.peek().getDateOfIssue().before(iter2.peek().getDateOfIssue())) {
                    this.append(iter1.next());
                } else {
                    this.append(iter2.next());
                }
            }
        }

        public Prescription peek() {
            if (iteratonIndex < prescriptions.length) {
                return prescriptions[iteratonIndex];
            } else {
                return null;
            }
        }

        public Prescription next() {
            PrescriptionList prescriptionList;
            PatientList.Iterator iter;
            if (iteratonIndex < prescriptions.length || prescriptions[iteratonIndex] == null) {
                return null;
            } else {
                Prescription prescription = prescriptions[iteratonIndex];
                return prescription;
            }
        }

        protected Prescription append(Prescription prescription) {
            if (iteratonIndex < prescriptions.length) {
                iteratonIndex++;
                add(prescription);
            }
            return prescription;
        }

        List mergesort(PatientList.Iterator list) {
            return null;
        }
    }

    PrescriptionList list1, list2;
    PrescriptionList.Iterator iter1 = list1.new Iterator();
    PrescriptionList.Iterator iter2 = list2.new Iterator();
    private Prescription[] prescriptions = null;
    private ListRecord head;
    private ListRecord next;
    private ListRecord tail;
    final int MAX_PRESCRIPTIONS = 20;

    public PrescriptionList() {
        head = null;
        next = null;
        tail = null;
    }

    public void add( Prescription pr ) {
        ListRecord pBefore = head;
        ListRecord newRecord = next;
        newRecord.next = pBefore.next;
        pBefore.next = newRecord;
        while (pBefore.data.comesBefore(pBefore.data, newRecord.data)) {
            Prescription prescription = pr;
            pBefore = pBefore.next;
            pBefore.next = newRecord;
        }
    }

    private class ListRecord {
        public Prescription data;
        public ListRecord next;
        public ListRecord( Prescription pr ) {
            data = pr;
            next = null;
        }
    }

    public void init() {
        //Resets iteration to the beginning of the list and prepares to iterate.
        ListRecord current = head;
        ListRecord end = tail;
        Iterator iterator;
        while (current.data != null) {
            current = head;
        }
    }

    public Prescription next(Prescription prescription) {
        //Return current data item and advances iteration to the next item in the list.
        ListRecord current = head;
        ListRecord newItem = next;
            if (current.data.comesBefore(current.data, newItem.data)) {
                current.data = newItem.data;
                return current.data;
            }
            //If iteration has reached the end of the list, returns null.
        return null;
    }

    public void delete(Prescription prescription) {

    }
}
