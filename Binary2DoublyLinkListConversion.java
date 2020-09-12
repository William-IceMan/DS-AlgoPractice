class Node {
    Node lNode;
    int data;
    Node rNode;

    public Node(int data) {
        this.data = data;
        lNode = rNode = null;
    }

}

class BinaryTree{
Node root;
Node head;
static Node prev=null;
    void convert2LinkList(Node root){
        if(root==null)
            return;
        convert2LinkList(root.lNode);
        if(prev==null)
            head=root;
        else{
            root.lNode=prev;
            prev.rNode=root;
        }
        prev=root;
        convert2LinkList(root.rNode);
    }
    void printList(Node node){
        while(node!=null){
            System.out.println(node.data+" ");
            node=node.rNode;
        }
    }
}

public class Binary2DoublyLinkListConversion{

    public static void main(String[] args) {
        BinaryTree tree=new BinaryTree();
        tree.root=new Node(10);
        tree.root.lNode=new Node(12);
        tree.root.rNode=new Node(15);
        tree.root.lNode.lNode=new Node(25);
        tree.root.lNode.rNode=new Node(30);
        tree.root.rNode.lNode=new Node(36);
        tree.root.rNode.rNode=new Node(40);

        tree.convert2LinkList(tree.root);
        tree.printList(tree.head);
    }

}
