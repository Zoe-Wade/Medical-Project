class PatientTree {
    private class TreeNode {
        public Patient patient;
        public TreeNode left, right;

        public TreeNode (Patient pat) {
            patient = pat;
        }
    }

    private TreeNode root;
    public PatientTree() {
        root = null;
    }

    // Add the new node newNode to the tree rooted at root.
    // Returns resulting tree.
    private TreeNode addNode(TreeNode root, TreeNode newNode) {
        if (root == null) {
            return newNode;
        }
        else {
            if (newNode.patient.getIdentity().isLessThan(root.patient.getIdentity())) {
// JS: Your use of isLessThan is correct, but the recursive call is wrong.
// You want to be calling addNode here, not add, and assigning its result back
// to root.left.    root.left = addNode( root,left, newNode );
                add(root.left.patient);
            }
            else {
                if (root.patient.getIdentity().isLessThan(newNode.patient.getIdentity())) {
// JS: same comment here.  
                    add(root.right.patient);
                }
            }
        }
        return root;
    }

    // JS: This would not return a TreeNode. Those are not public. 
    // Would just return null.  It is addNode that returns a TreeNode. 
    public TreeNode add(Patient pat) {
        root = addNode(root, new TreeNode(pat));
        return root;
    }

    // JS: You want the same distinction between delete and deleteNode
    // as you did for add.  
    public TreeNode delete (TreeNode root, PatientIdentity id) {
        TreeNode temp = root;
        TreeNode prev = null;

        if (temp != null && temp.patient.getIdentity() == id) {
            root = temp.right;
// JS: the assignment of the new root is correct, but we have to
// add the temp.left child to tht new root before we return.  
            return root;
        }

// JS: this part is not correct.  You want to just call delete recursively
// on either the left or right child as appropriate, same pattern as add and find
        while (temp != null && temp.patient.getIdentity() == id) {
            prev = temp;
            temp = temp.right;
        }

        if (temp == null) {
            return null;
        }

        prev.right = temp.right;
        return root;
    }

    public Patient find(TreeNode root, PatientIdentity id) {
        if (root == null) {
            return null;
        }
        else {
            if (id == root.patient.getIdentity()) {
                return root.patient;
            }
            else {
                if (id.isLessThan(root.patient.getIdentity())) {
// JS: test on isLessThan is correct, but the line below should be 
// a recursive call to find on root.left
                    return root.left.patient;
                }
                else {
                    if (id.isLessThan(root.patient.getIdentity())) {
// js: same comment here.  
                        return root.left.patient;
                    }
                }
            }
        }
        return root.patient;
    }

    private void printTree( TreeNode rootNode ) {
        if (rootNode != null) {
            System.out.println(rootNode.left);
            System.out.println(rootNode.toString());
            System.out.println(rootNode.right);
        }
    }
}