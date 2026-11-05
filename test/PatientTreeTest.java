import org.junit.jupiter.api.Test;

import javax.swing.tree.TreeNode;

// JS: You import here is correct. The issue was with what the asserts were asserting.
import static org.junit.jupiter.api.Assertions.*;

class PatientTreeTest {
    void add() {
        Patient pat = null;
        PatientTree patientTree = null;
        TreeNode node = null;
// JS: Not boolean.  Consider using the count of items in the tree.  
        assertTrue(patientTree.add(pat));
    }

    @Test
    void delete() {
        Patient pat = null;
        PatientIdentity id = null;
        PatientTree patientTree = null;
        TreeNode node = null;
// JS: I don't think a boolean test is sufficient here. 
// Consider deleting and then doing a find on what was deleted.  
        assertTrue(patientTree.delete(node, id));
    }

    @Test
    void find() {
        Patient pat = null;
        PatientIdentity id = null;
        PatientTree patientTree = null;
        TreeNode node = null;
// JS: The find routine is not boolean
        assertTrue(patientTree.find(node, id));
    }
}