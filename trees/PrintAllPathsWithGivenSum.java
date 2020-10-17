package trees;
/*
    File Name : PrintAllPathsWithGivenSum.java
    
    @author Mayank Sharma
    First Created on 12-10-2020 at 01:41
*/


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

public class PrintAllPathsWithGivenSum {

    private static void PrintPath(Tree tree, int sum) {
        List<Integer> paths = new ArrayList<>();
        printPathsHelper(tree, sum, paths,0);
    }

    private static void printPathsHelper(Tree tree, int sum, List<Integer> paths, int tempSum) {
        if(tree==null)
            return;
        paths.add(tree.data);
        tempSum += tree.data;
        if(tempSum==sum){
            paths.forEach(val -> System.out.print(val + " "));
            return;
        }
        printPathsHelper(tree.left, sum , paths, tempSum);
        printPathsHelper(tree.right, sum, paths, tempSum);
        paths.remove(paths.size()-1);
    }

    public static void main(String[] args) {

        Tree tree = new Tree(1);
        tree.left = new Tree(20);
        tree.right = new Tree(3);
        tree.right.left = new Tree(4);
        tree.right.right = new Tree(15);
        tree.right.left.left = new Tree(6);
        tree.right.left.right = new Tree(7);
        tree.right.right.left = new Tree(8);
        tree.right.right.right = new Tree(9);

        PrintPath(tree,8);

    }

}
