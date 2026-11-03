import org.junit.jupiter.api.Test;

import javax.swing.tree.TreeNode;

import static org.junit.jupiter.api.Assertions.*;

class PatientTreeTest {
    void add() {
        Patient pat = null;
        PatientTree patientTree = null;
        TreeNode node = null;
        assertTrue(patientTree.add(pat));
    }

    @Test
    void delete() {
        Patient pat = null;
        PatientIdentity id = null;
        PatientTree patientTree = null;
        TreeNode node = null;
        assertTrue(patientTree.delete(node, id));
    }

    @Test
    void find() {
        Patient pat = null;
        PatientIdentity id = null;
        PatientTree patientTree = null;
        TreeNode node = null;
        assertTrue(patientTree.find(node, id));
    }
}