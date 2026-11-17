import javax.swing.tree.TreeNode;
import java.io.*;
import java.util.Scanner;

class PatientList {
    public class Iterator {
        int iteratonIndex = 0;
        public Iterator(int iteratorIndex) {
            iteratorIndex = iteratonIndex;
        }

        public Patient peek() {
            if (iteratonIndex < patients.length) {
                return patients[iteratonIndex];
            } else {
                return null;
            }
        }

        public Patient next() {
            if (iteratonIndex >= patients.length || patients[iteratonIndex] == null) {
                return null;
            } else {
                Patient p = patients[iteratonIndex];
                iteratonIndex++;
                return p;
            }
        }

        public Patient append(Patient patient) {
            if (iteratonIndex < patients.length) {
                iteratonIndex++;
                add(patient);
            }
            return patient;
        }

//        public List merge(Patient[] list1, Patient[] list2) {
//            Iterator iter1 = list1.new Iterator();
//            Iterator iter2 = list2.new Iterator();
//            while (iter1.peek() != null && iter2.peek() != null) {
//                if (iter1.peek().getIdentity().isLessThan(iter2.peek().getIdentity())) {
//                    this.append(iter1.next());
//                } else {
//                    this.append(iter2.next());
//                }
//            }
//
//            int index1 = 0;
//            int index2 = 0;
//            int[] list1 = null;
//            int[] list2 = null;
//            while (index1 < list1.length && index2 < list2.length) {
//                if (list1[index1] < 2 && list2[index2] < 2) {
//
//                }
//                if (list1[index1] < list2[index2]) {
//                    add(finalList[list1[index1]]);
//                    index1++;
//                }
//                else {
//                    if (list2[index2] < list1[index1]) {
//                        add(finalList[list2[index2]]);
//                        index2++;
//                    }
//                }
//            }
//            return mergesort(finalList);
//        }
    }

//    public List merge(Patient[] list1, Patient[] list2) {
//        return merge();
//    }

//    PatientList list1, list2;
//    Iterator iter1 = list1.new Iterator();
//    Iterator iter2 = list2.new Iterator();
    // patients array
    private Patient[] patients = null;
    private int logicalSize = 0;
    // maximum patient capacity for hospital
    private final int MAX_PATIENTS = 1000;


    public PatientList() {
        patients = new Patient[MAX_PATIENTS];
    }

    public int getNumPatients() {
        return logicalSize;
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
        if (logicalSize >= MAX_PATIENTS) {
            return false;
        }

        int currentIndex = logicalSize - 1;
        while (currentIndex >= 0 && patients[currentIndex].getIdentity().isLessThan(pat.getIdentity())) {
            //move patient at current_index to current_index +1
            // at this point, element currentIndex is empty
            patients[currentIndex + 1] = patients[currentIndex];
            currentIndex--;
        }
// we are now at a patient who does not come after us. add patient to slot currentIndex+1
        patients[currentIndex + 1] = pat;
        logicalSize++;
        return true;
    }

    public Patient binarySearch(PatientIdentity id) {
        int upper = logicalSize;
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

    public class binarySearchTree<T> {
        T obj = null;
        PatientIdentity id;
        int stackPointer;
        TreeNode left, right;
        TreeNode root;
        Patient pat;
        final int MAX_PATIENTS = 1000;
        Stack<TreeNode> treeNodeStack = new Stack<TreeNode>(50);
        Stack<TreeNode> iterationStack = new Stack<TreeNode>(100);
        Stack<Patient> patientStack = new Stack<Patient>(MAX_PATIENTS);
        Object[] theStack = null;

        public binarySearchTree(int value) {
            root = new TreeNode(value);
        }

        TreeNode insert(T value) {
            TreeNode node = new TreeNode(value);
            TreeNode nextNode = iterationStack.Pop();
            while (node > node.Next()) {
                if (nextNode.right != null && find(id).equals(pat)) {
                    add(pat);
                }
            }
            return nextNode;
        }

        private void findLeftmost( TreeNode startingNode, Stack<TreeNode> stack ) {
            TreeNode node = startingNode;
            TreeNode leftNode = stack.left;
            while (node != null) {
//            push this node on the stack
                stack.Push(node);
//            proceed to left child node
                node = leftNode;
            }
        }

        private TreeNode Next() {
            TreeNode returnNode = iterationStack.Pop();
            if (returnNode.right != null) {
                findLeftmost(returnNode.right, iterationStack);
            }
            return returnNode;
        }
    }

    Patient linearSearch(PatientIdentity id) {
        Patient pat = null;
        Iterator iter = this.new Iterator();
        while ((pat = iter.next()) != null) {
//            if this patient matches the identity, this is the one you want
            if (pat.getIdentity().match(id)) {
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
            Patient p = iter.next();
            while (p != null) {
                writer.write(p.toCSV() + "\n");
                p = iter.next();
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
