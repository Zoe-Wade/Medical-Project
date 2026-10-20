public class ListRecord {
    Object data;
    Prescription prescription;
    ListRecord next;

    private Prescription getPrescription() {
        return prescription;
    }

    private ListRecord getNext() {
        return next;
    }

    private Object getData() {
        return data;
    }
}
