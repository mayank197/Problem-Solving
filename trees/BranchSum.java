package trees;

/*
    File Name : BranchSum.java
    
    @author Mayank Sharma
    First Created on 12-10-2020 at 00:52
*/


import java.util.Arrays;

public class BranchSum {

    private static void printAllPathSums(Tree tree, int[] path, int index) {
        if(tree==null)
            return;
        path[index++] = tree.data;
        // If leaf encountered, that path is done
        if(tree.left==null && tree.right==null){
            System.out.println(Arrays.stream(path).limit(index).map(i->Integer.valueOf(i)).sum());
        }
        else{
            printAllPathSums(tree.left, path, index);
            printAllPathSums(tree.right, path, index);
        }
    }

    private static void AllPathSumsFromRootToLeaf(Tree tree) {
        int paths[] = new int[100];
        printAllPathSums(tree, paths,0);
    }

    public static void main(String[] args) {

        Tree tree = new Tree(1);
        tree.left = new Tree(2);
        tree.right = new Tree(3);
        tree.left.left = new Tree(4);
        tree.left.right = new Tree(5);
        tree.right.left = new Tree(6);
        tree.right.right = new Tree(7);
        tree.left.left.left = new Tree(8);
        tree.left.left.right = new Tree(9);
        tree.left.right.left = new Tree(10);

        AllPathSumsFromRootToLeaf(tree);

    }

}
