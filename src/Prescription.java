import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

// JS: Please remove this.  IntelliJ tries to guess what you want. Don't let it. 
import java.util.List;

public class Prescription {
    public Name patientName;
    public String medicineName;
    public Date dateOfIssue;
    public int dosage = 0;
    public String prescriber;
    private ListRecord head;
    private static final SimpleDateFormat DATE_TIME_FORMATTER = new SimpleDateFormat("dd-MM-yyyy");

    public Prescription(Name patName, String medName, Date issuedDate, int dosage, String prescriberName) {
        this.patientName = patName;
        this.medicineName = medName;
        this.dateOfIssue = issuedDate;
        this.dosage = dosage;
        this.prescriber = prescriberName;
    }

    public Name getPatientName() {
        return patientName;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public int getDosage() {
        return dosage;
    }

    public String getPrescriber() {
        return prescriber;
    }

    public Date getDateOfIssue() {
        return dateOfIssue;
    }

// JS: Please get rid of stuff like this.  You are correct that it does not belong here. 
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

    public static Prescription toCSV(Name patientName, String medicineName, int dosage, Date dateOfIssue, String prescriber) {
        Prescription output = new Prescription(patientName, medicineName, dateOfIssue,dosage, prescriber);
        return output;
    }

// JS: These functions are fine.  You would find String,format() useful in these situations. 
    public String toString() {
        return "Patient Name: " + patientName.toString()
                + "Medicine Name: " + medicineName.toString()
                + "Issued Date: " + dateOfIssue.toString()
                + "Dosage: " + Integer.toString(dosage)
                + "Prescriber: " + prescriber.toString();
    }

    public String toCSV() {
        Prescription prescription = new Prescription(patientName, medicineName, dateOfIssue, dosage, prescriber);
        return prescription.getPatientName()
                + "," + prescription.getMedicineName()
                + "," + DATE_TIME_FORMATTER.format(prescription.getDateOfIssue())
                + "," + prescription.getDosage()
                + "," + prescription.getPrescriber();
    }

    public static Prescription fromCSV(String CSV) {
        String[] tokens = CSV.split(",");
        if (tokens.length != 5) {
            return null;
        }

// JS: I do not understand this part.  You have already split the CSV into tokens.
// The name occupies the first token.  So you could do tokens[0].split(" "), but not CSV. 
        String[] nameTokens = CSV.split(" ");
        if (nameTokens.length != 1) {
            return null;
        }

// JS: good use of date time formatter, and also good handling of the parse exception.  
        try {
            Date parsedBirthdate = Prescription.DATE_TIME_FORMATTER.parse(tokens[1]);
            Name name = new Name(nameTokens[0], nameTokens[1]);
            String medicineName = new String(tokens[2]);
            Date parsedIssuedate = Prescription.DATE_TIME_FORMATTER.parse(tokens[3]);
            int dosage = Integer.parseInt(tokens[4]);
            String prescriber = new String(tokens[5]);
            return new Prescription(name, medicineName, parsedIssuedate, dosage, prescriber);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}
