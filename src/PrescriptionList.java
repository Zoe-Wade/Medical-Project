import java.awt.*;

public class PrescriptionList {

    public class Iterator {
// JS: No concept of an "index" in a linked list
        int iteratonIndex = 0;

        public Iterator() {
// JS: I have no idea what this code is doing here.  It would not compile.
// This is code to do merges, but that is not called for in a constructor. 
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
// JS: This is code for an array, but you don't have an array....
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

// JS: the list class wouold not hve instances of itself as data
    PrescriptionList list1, list2;
    PrescriptionList.Iterator iter1 = list1.new Iterator();
    PrescriptionList.Iterator iter2 = list2.new Iterator();

// JS: Should not be here.  
    private Prescription[] prescriptions = null;

// JS: Actually all we need is the head
    private ListRecord head;
    private ListRecord next;
    private ListRecord tail;

    public PrescriptionList() {
        head = null;
        next = null;
        tail = null;
    }


    public void add( Prescription pr ) {
        ListRecord pBefore = head;
        ListRecord newRecord = next;
// JS: thnis is what we do once we have found where to add the record. 
// There are two cases: adding right at the head, or adding somewhere else.  
        newRecord.next = pBefore.next;
        pBefore.next = newRecord;
        while (pBefore.data.comesBefore(pBefore.data, newRecord.data)) {
            Prescription prescription = pr;
            pBefore = pBefore.next;
            pBefore.next = newRecord;
        }
    }

    public void delete(Prescription prescription) {
        ListRecord temp = head;
        ListRecord prev = null;

// JS: in these next two if statements it would be clearer if you
// used head itself, not temp
        if (temp == null) {
            return;
        }

        if (temp != null && temp.data == prescription) {
            head = temp.next;
// JS: you also want to set temp.next = null right here, so temp is removed
// The Java garbage collector will then recycle it.  
            return;
        }

// JS: temp is not really needed here, as you can reference wverything you need to
// using hte prev variable.
        while (temp != null && temp.data != prescription) {
            prev = temp;
            temp = temp.next;
        }

// Here we do need a temp, to briefly hold on to the thing being deleted
// so we can set its next pointer to null.  
        prev.next = temp.next;
    }

    private class ListRecord {
        public Prescription data;
        public ListRecord next;
        public ListRecord( Prescription pr ) {
            data = pr;
            next = null;
        }
    }

// JS: this method and the next belong in the iterator class,
// which you did define above
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

}
