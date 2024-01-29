import java.util.Queue;
import java.util.LinkedList;

public class BinaryTree {
  Node root;
  
  /*
  * Node class
  */
  public static class Node {
    int val;
    Node left;
    Node right;
    
    public Node(int data) {
      this.val = data;
    }
  }
  
  // counts the number of leaf nodes.
  public int getLeavesCount(Node node) {
    // base case (leaf node)
    if(node.left == null && node.right == null) {
      return 1;
    }else {
      return getLeavesCount(node.left) + getLeavesCount(node.right);
    }
  }

  // traversal using inorder (prints to the console)
  public void inorder(Node node) {
    if(node == null) return; // base case
    else {
      inorder(node.left);
      System.out.println(node.val);
      inorder(node.right);
    }
  }

  // traversal using preorder (prints to the console)
  public void preorder(Node node) {
    if(node == null) return; // base case
    else {
      System.out.println(node.val);
      preorder(node.left);
      preorder(node.right);
    }
  }

  // traversal using postorder (prints to the console)
  public void postorder(Node node) {
    if(node == null) return; // base case
    else {
      postorder(node.left);
      postorder(node.right);
      System.out.println(node.val);
    }
  }

  //  displays the tree using-breadth first search (BFS) traversal (prints to the console)
  public void BFS(Node node) {
    Queue<Node> queue = new LinkedList<>();
    queue.add(node);

    while (!queue.isEmpty()) {
      Node n = queue.poll();
      System.out.println(n.val);
      if(n.left != null) queue.add(n.left);
      if(n.right != null) queue.add(n.right);
    }
  }


  public static void main(String[] args) {
    BinaryTree tree = new BinaryTree();

    // create my tree
    tree.root = new Node(1);
    tree.root.left = new Node(2);
    tree.root.left.left = new Node(4);
    tree.root.left.right = new Node(5);
    tree.root.right = new Node(3);


    // System.out.println(tree.getLeavesCount(tree.root));
    tree.inorder(tree.root);
    System.out.println("--------------------");
    tree.postorder(tree.root);
    System.out.println("--------------------");
    tree.preorder(tree.root);
    System.out.println("--------------------");
    tree.BFS(tree.root);
  }
  
}
