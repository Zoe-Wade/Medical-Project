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
                add(root.left.patient);
            }
            else {
                if (root.patient.getIdentity().isLessThan(newNode.patient.getIdentity())) {
                    add(root.right.patient);
                }
            }
        }
        return root;
    }

    public TreeNode add(Patient pat) {
        root = addNode(root, new TreeNode(pat));
        return root;
    }

    public TreeNode delete (TreeNode root, PatientIdentity id) {
        TreeNode temp = root;
        TreeNode prev = null;

        if (temp != null && temp.patient.getIdentity() == id) {
            root = temp.right;
            return root;
        }

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
                    return root.left.patient;
                }
                else {
                    if (id.isLessThan(root.patient.getIdentity())) {
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