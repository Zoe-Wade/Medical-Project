import java.util.Date;
import java.util.List;

public class Prescription {
    public String medicineName;
    public Date dateOfIssue;
    public int dosage = 0;
    public String prescriber;
    private ListRecord head;

    public Prescription(String medName, Date issuedDate, int dosage, String prescriberName) {
        this.medicineName = medName;
        this.dateOfIssue = issuedDate;
        this.dosage = dosage;
        this.prescriber = prescriberName;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public String getPrescriber() {
        return prescriber;
    }

    public Date getDateOfIssue() {
        return dateOfIssue;
    }

//    private ListRecord linkedList() {
//        int count = 0;
//        ListRecord pRecord = head;
//        while (pRecord != null) {
//            count++;
//            pRecord = pRecord.next;
//        }
//        return pRecord;
//    }

    public boolean comesBefore(Prescription pr1, Prescription pr2 ) {
        // Returns true if pr1 should come before pr2 in our list, false otherwise.
        return (pr1.getDateOfIssue().compareTo(pr2.dateOfIssue) < 0);
    }

    public static Prescription toCSV(String medicineName, int dosage, Date dateOfIssue, String prescriber) {
        Prescription output = new Prescription(medicineName, dateOfIssue,dosage, prescriber);
        return output;
    }
}
