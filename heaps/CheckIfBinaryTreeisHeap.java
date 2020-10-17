package heaps;

/*
    File Name : CheckIfBinaryTreeisHeap.java
    
    @author Mayank Sharma
    First Created on 17-10-2020 at 13:23
*/

class Tree{
    int key;
    Tree left, right;

    public Tree(int key) {
        this.key = key;
        left = right = null;
    }
}

public class CheckIfBinaryTreeisHeap {

    static int totalNodes(Tree tree){
        return (tree==null) ? 0 : 1 + totalNodes(tree.left) + totalNodes(tree.right);
    }

    // Condition 1 to be checked
    private static boolean isComplete(Tree root, int index, int nodes){
        if(root==null)
            return true;
        if(index >= nodes)
            return false;
        return isComplete(root.left, 2*index+1, nodes) &&
                isComplete(root.right, 2*index+2, nodes);
    }

    // Condition 2 to be checked
    static boolean isHeapHelper(Tree root){
        if(root.left==null && root.right==null)
            return true;
        if(root.left==null)
            return root.key >= root.right.key;
        if(root.right==null)
            return root.key >= root.left.key;
        if(root.key >= root.left.key && root.key >= root.right.key)
            return isHeapHelper(root.left) && isHeapHelper(root.right);
        return false;
    }

    private static boolean isHeap(Tree root) {
        if(root==null)
            return true;
        int nodeCount = totalNodes(root);
        return isHeapHelper(root) && isComplete(root, 0, nodeCount);
    }

    public static void main(String[] args) {

        Tree root = new Tree(10);
        root.left = new Tree(9);
        root.right = new Tree(8);
        root.left.left = new Tree(7);
        root.left.right = new Tree(6);
        root.right.left = new Tree(5);
        root.right.right = new Tree(4);
        root.left.left.left = new Tree(3);
        root.left.left.right = new Tree(2);
        root.left.right.left = new Tree(1);

        System.out.println(isHeap(root));

    }

}
