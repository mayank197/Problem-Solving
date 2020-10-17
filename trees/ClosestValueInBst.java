package trees;
/*
    File Name : ClosestValueInBst.java
    
    @author Mayank Sharma
    First Created on 12-10-2020 at 00:27
*/


public class ClosestValueInBst {

    private static int closestValueSoFar;

    private static int closestValue(Tree tree, int x) {
        if(tree==null)
            return -1;
        if(tree.data==x){
            return tree.data;
        }
        if(Math.abs(tree.data - x) < Math.abs(tree.data - closestValueSoFar)){
            closestValueSoFar = tree.data;
        }
        if(tree.data > x){
            closestValue(tree.left,x);
        }
        else{
            closestValue(tree.right, x);
        }
        return closestValueSoFar;
    }

    public static void main(String[] args) {

        Tree tree = new Tree(10);
        tree.left = new Tree(4);
        tree.right = new Tree(15);
        tree.left.left = new Tree(2);
        tree.left.right = new Tree(5);
        tree.right.left = new Tree(13);
        tree.right.right = new Tree(22);
        tree.right.left.right = new Tree(14);
        tree.left.left.left = new Tree(1);

        closestValueSoFar = tree.data;
        System.out.println(closestValue(tree, 12));

    }

}
