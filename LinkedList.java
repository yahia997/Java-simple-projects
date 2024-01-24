/*
 * This is an implementation of LinkedList in Java
 * made by Yahya Mahmoud Zakaria
 * methods: 
 *  - printList - insertBegining - insertEnd - insertMiddle - DeleteFirst
 *  - DeleteLast - delete - printReversed - insertInSortedList - mergeLists
 *  
 */

public class LinkedList<T> {
  // head of the list
  Node<T> head;

  // inner class (node class)
  static class Node<T> {
    T data;
    Node<T> next;

    // constructor method
    public Node(T data) {
      this.data = data;

      // next node is null by default
      this.next = null;
    }
  }

  // prints all nodes of the LinkedList
  public void printList(LinkedList<T> list) {
    Node<T> currentNode = list.head;
    
    while (currentNode != null) {
      // Print node data
      System.out.println(currentNode.data);

      // go to next node
      currentNode = currentNode.next;
    }
  }

  
  public void insertBegining(LinkedList<T> list, T data) {
    // create new node
    Node<T> newNode = new Node<T>(data);
    newNode.next = list.head;

    // change the head to new Node
    list.head = newNode;
  }

  public void insertEnd(LinkedList<T> list, T data) {
    // create new node
    Node<T> newNode = new Node<T>(data);

    // if list is empty
    if(list.head == null) {
      list.head = newNode;
    }else {
      
      // go to the end of the list and put new node
      Node<T> currentNode = list.head;
      while (currentNode.next != null) {
        currentNode = currentNode.next;
      }

      currentNode.next = newNode;
    }

  }

  public void insertMiddle(LinkedList<T> list, T data,int index) {
    // create new node
    Node<T> newNode = new Node<T>(data);

    if(index < 0) {
      System.out.println("This index is out of range");
      return;      
    }

    // if the user will insert at index 0
    if(index == 0) {
      newNode.next = list.head;
      list.head = newNode;
    }else {

      // go to the specified position and put new node
      Node<T> currentNode = list.head;
      int counter = 0;

      while (counter < index-1) { // go to previous position
        currentNode = currentNode.next;
        counter++;

        // index not found
        if(currentNode == null) {
          System.out.println("This index is out of range");
          return;
        }
      }

      newNode.next = currentNode.next;
      currentNode.next = newNode;      
    }
  }

  public void DeleteFirst(LinkedList<T> list) {
    // if head is empty
    if(list.head == null) {
      System.out.println("list is empty");
      return;
    }

    list.head = list.head.next;
  }

  public void DeleteLast(LinkedList<T> list) {
    // if head is empty
    if(list.head == null) {
      System.out.println("list is empty");
      return;
    }

    Node<T> currentNode = list.head;

    // go to the node that is previous the last node
    while (currentNode.next.next != null) {
      currentNode = currentNode.next;
    }

    currentNode.next = null;
  }

  public void delete(LinkedList<T> list, int index) {
    // if head is empty
    if(list.head == null) {
      System.out.println("list is empty");
      return;
    }
    
    // go to the specified position and delete the node
    Node<T> currentNode = list.head;
    int counter = 0;

    while (counter < index-1) { // go to previous position
      currentNode = currentNode.next;
      counter++;
    
      // index not found
      if(currentNode.next == null) {
        System.out.println("This index is out of range");
        return;
      }
    }

    currentNode.next = currentNode.next.next;    
  }

  // in a reverse order using recursion (tail recursion) This is insane
  public void printReversed(Node<T> node) {
    if(node != null) {
      printReversed(node.next);
      System.out.println(node.data);
    }
  }

  // type of linkedList has to be Integer
  public void insertInSortedList(LinkedList<Integer> list,int data) {
    Node<Integer> newNode = new Node<Integer>(data);
    
    if(list.head == null) { // list is empty
      list.head = newNode;
    }else if(list.head.data > data) { // at the beginning of the list (smaller than all nodes)
      newNode.next = list.head;
      list.head = newNode;
    }else {
      
      Node<Integer> prev = list.head;
      Node<Integer> currentNode = list.head.next;
      

      while (currentNode.data < data) {
        prev = currentNode;
        currentNode = currentNode.next;

        if(currentNode == null) { // at the end of the list (greater than all nodes)
          prev.next = newNode;
          break;
        }
      }

      newNode.next = currentNode;
      prev.next = newNode;
    }
  }

  public LinkedList<T> mergeLists(LinkedList<T> x, LinkedList<T> y) {
    Node<T> currentNode = x.head;

    if(currentNode == null) { // list x is empty so return list y
      return y;
    }else { // merge two lists

      while(currentNode.next != null) {
        currentNode = currentNode.next;
      }

      currentNode.next = y.head;

      return x;
    }

  }

  public static void main(String[] args) {
    LinkedList<Integer> list1 = new LinkedList<Integer>();
    LinkedList<Integer> list2 = new LinkedList<Integer>();
    list1.insertEnd(list1, 1);
    list1.insertEnd(list1, 2);
    list1.insertEnd(list1, 3);
    list1.insertEnd(list1, 4);
    list1.printList(list1);
    System.out.println("--------------------------");
    list2.insertEnd(list2, 0);
    list2.insertEnd(list2, -1);
    list2.insertEnd(list2, -2);
    list2.insertEnd(list2, -3);
    list2.insertEnd(list2, -4);
    list2.printList(list2);
    System.out.println("--------------------------");
    LinkedList<Integer> list3 = list1.mergeLists(list1, list2);
    list3.printList(list3);
  }
}
