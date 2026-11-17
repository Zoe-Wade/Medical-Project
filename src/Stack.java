import org.w3c.dom.Node;

import javax.swing.tree.TreeNode;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Stack<T> {
    @SuppressWarnings("unchecked")
    private int stackPointer;
    private Object[] theStack = null;
    Stack<TreeNode> treeNodeStack = new Stack<TreeNode>(50);
    Stack<TreeNode> iterationStack = new Stack<TreeNode>(100);
    TreeNode left, right, parent, child;

    public Stack(int stack_size) {
        theStack = new Object[stack_size];
        stackPointer = 0;
    }

    public void Push(T tobj) {
        int currentStackPos = 0;
        Stack stack = new Stack(currentStackPos);
        //write to array position of stack pointer
        theStack[stackPointer] = currentStackPos;
        //increment stack pointer
        while (stackPointer < theStack.length) {
            stackPointer++;
        }
    }

    public T Pop() {
        T obj = null;
        int refPointer = 0;
        if (stackPointer > 0) {
            obj = (T) theStack[stackPointer - 1];
            theStack[stackPointer - 1] = null;
            stackPointer--;
        }
        return obj;
    }

    public Stack Empty() {
        Stack stack = new Stack(theStack.length);
        //pop items off the stack until null
        while (stack != null) {
            stack.Pop();
        }
        return stack;
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