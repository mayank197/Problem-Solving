package trees;
/*
    File Name : Tree.java
    
    @author Mayank Sharma
    First Created on 11-09-2020 at 00:34
*/

import java.util.LinkedList;
import java.util.Queue;

class Tree {

    int data;
    Tree left, right;

    public Tree(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    static int Search(int arr[], int n, int x){
        for(int i=0;i<n;i++){
            if(arr[i]==x)
                return i;
        }
        return -1;
    }

    static int searchWithIndices(int arr[], int start, int end, int x){
        int i = 0;
        for(i=start;i<=end;i++){
            if(arr[i]==x)
                return i;
        }
        return i;
    }

    static int Height(Tree tree){
        return (tree==null) ? 0 : 1 + Math.max(Height(tree.left), Height(tree.right));
    }

    public static void Inorder(Tree tree){
        if(tree==null)
            return;
        Inorder(tree.left);
        System.out.print(tree.data + " ");
        Inorder(tree.right);
    }

    public static void Preorder(Tree tree){
        if(tree==null)
            return;
        System.out.print(tree.data + " ");
        Inorder(tree.left);
        Inorder(tree.right);
    }

    public void levelOrder(){
        System.out.println("Tree Traversal : ");
        Queue<Tree> q = new LinkedList<>();
        q.add(this);

        while(!q.isEmpty()){
            int qSize = q.size();

            while(qSize-- > 0){
                Tree front = q.poll();
                System.out.print(front.data + " ");
                if(front.left!=null)
                    q.add(front.left);
                if(front.right!=null)
                    q.add(front.right);
            }
            System.out.format("%n");
        }

    }

}
