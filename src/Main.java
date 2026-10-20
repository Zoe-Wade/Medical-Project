import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Iterator;

public class Main {
    File inputFile = new File("patients.txt");

    public static void main(String[] args, Iterator iterator) {
        String filename1 = "patients.txt";
        writeToCSV(filename1, iterator);
        readCSVFile(filename1);

        String filename2 = "prescriptions.txt";
        writeToCSV(filename2, iterator);
        readCSVFile(filename2);
    }

    static boolean writeToCSV(String filename, Iterator CSViterator) {
        boolean result = true;
        File file = new File(filename);
        FileWriter writer = null;
        try {
            writer = new FileWriter(file);
            while (CSViterator.next() != null) {
                writer.write(CSViterator.next() + "\n");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
            result = false;
        }
        return result;
    }

    static boolean readCSVFile(String filename) {
        boolean result = true;
        File file = new File(filename);
        Scanner scanner = null;
        PatientList.Iterator patientCSVIterator = null;
        PrescriptionList.Iterator prescrptionCSVIterator = null;
        try {
            scanner = new Scanner(file);
            while (patientCSVIterator.next() != null) {
                Patient nextPatient = patientCSVIterator.next();
            }
            while (prescrptionCSVIterator.next() != null) {
                Prescription nextPrescription = prescrptionCSVIterator.next();
            }
            printTokens(scanner.nextLine());
        } catch (IOException e) {
            e.printStackTrace();
            result = false;
        }
        return result;
    }

    public static void printTokens(String line) {
        String[] tokens = line.split(",");
        for (int i = 0; i < tokens.length; i++) {
            System.out.print(tokens[i] + " ");
        }
        System.out.println();
    }
}