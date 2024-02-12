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

  // displays the tree using-breadth first search (BFS) traversal (prints to the console)
  public void BFS(Node node) {
    if(node == null) return; // if tree is empty
    Queue<Node> queue = new LinkedList<>();
    queue.add(node);

    while (!queue.isEmpty()) {
      Node n = queue.poll();
      System.out.println(n.val);
      if(n.left != null) queue.add(n.left);
      if(n.right != null) queue.add(n.right);
    }
  }

  // Add a node to the tree with a value of key
  public void insert(int key, Node root) {
    // tree is empty
    if(root == null) {
      this.root = new Node(key);
      return;
    }
    
    if(root.left == null && root.val > key) {// insert to left
      root.left = new Node(key);
      return;
    
    }else if(root.right == null && root.val < key) {// insert to left
      root.right = new Node(key);
      return;

    }else if(root.val < key) // go to right
      insert(key, root.right);
    else if(root.val > key) // go to left
      insert(key, root.left);
  }

  // Find a node in the tree with a value of key
  public boolean search(int key, Node root) {
    if(root == null) return false;
    if(key == root.val) return true;
    else if(root.val > key)
      return search(key, root.left);
    else
      return search(key, root.right);
  }

  // find minimum value in a tree or subtree
  public Node findMin(Node root) {
    if(root.left == null) return root;
    return findMin(root.left);
  }

  // Delete a node in the tree with a value of key
  public Node delete(int key, Node root) {
    if(root == null) return root; // tree is empty
    else if(root.val > key) 
      return delete(key, root.left); // go to right
    else if(root.val < key)
      return delete(key, root.right); // go to left
    else { // find the node to delete

      // case I: leaf node
      if(root.right == null && root.left == null ) {
        root = null;
      }

      // case II: has one child
      // has only left child
      else if(root.right == null) {
        Node temp = root;
        root = temp.left;
        temp = null;
        
      }

      // has only right child
      else if(root.left == null) {
        Node temp = root;
        root = temp.right;
        temp = null;
      }

      // case III: has two children
      else  {
        Node temp = findMin(root.right);
        root.val = temp.val;
        delete(temp.val, root.right);
        temp = null;
      }

      return this.root;
    }
  }

  public static void main(String[] args) {
    BinaryTree tree2 = new BinaryTree();

    tree2.insert(1, tree2.root);
    tree2.insert(2, tree2.root);
    tree2.insert(4, tree2.root);
    tree2.insert(5, tree2.root);
    tree2.insert(3, tree2.root);

    tree2.delete(-1, tree2.root);

    tree2.inorder(tree2.root);
    System.out.println("--------------------");
    tree2.postorder(tree2.root);
    System.out.println("--------------------");
    tree2.preorder(tree2.root);
    System.out.println("--------------------");
    tree2.BFS(tree2.root);

    System.out.println(tree2.search(3, tree2.root));
  }
  
}
