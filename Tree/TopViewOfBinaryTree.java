package Tree;

import java.util.Map;
import java.util.TreeMap;

class Node{
    int data;
    Node left,right;
    Node(int data){
        this.data=data;
        left=right=null;
    }
}


public class TopViewOfBinaryTree {
    Node root;
    TopViewOfBinaryTree(){
        root=null;
    }
    static class Pair{
        int first,second;
        Pair(int i,int j){
         first=i;
         second=j;
        }
    }
    static TreeMap<Integer,Pair> map=new TreeMap<>();
    //function To Print TopView
    private static void fillMap(Node root,int d,int l){
    if(root==null)
        return;
    if(map.get(d)==null)
        map.put(d,new Pair(root.data,l));
    else if(map.get(d).second>l){
        map.put(l,new Pair(root.data,l));
    }
    fillMap(root.left,d-1,l+1);
    fillMap(root.right,d+1,l+1);
    }
    static void topView(Node root){
        fillMap(root,0,0);
        for (Map.Entry<Integer,Pair> entry:map.entrySet()){
            System.out.println(entry.getValue().first+" ");
        }
    }

    public static void main(String[] args) {
        TopViewOfBinaryTree tree=new TopViewOfBinaryTree();
        tree.root=new Node(1);
        tree.root.left=new Node(2);
        tree.root.right=new Node(3);
        tree.root.left.left=new Node(4);
        tree.root.left.right=new Node(5);
        tree.root.right.left=new Node(6);
        tree.root.right.right=new Node(7);
        topView(tree.root);
/*
                    1
            2               3
        4       5       6       7
* */
    }
}
