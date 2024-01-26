import java.util.EmptyStackException;

public class Stack {

  public static void main(String[] args) {
    StackArray stack = new StackArray();
    System.out.println(stack.isEmpty());
    stack.push(5);
    stack.push(6);
    System.out.println(stack.peek());

    System.out.println("-----------------------------------");

    StackLinkedList stack2 = new StackLinkedList();
    System.out.println(stack2.isEmpty());
    stack2.push(5);
    stack2.push(6);
    System.out.println(stack2.peek());
  }
}

// implementation of Stack using Arrays
class StackArray {
  static final int MAX = 1000;
  int topIndex = -1;
  int[] stackArray = new int[MAX]; // Maximum size of Stack

  public boolean isEmpty() {
    return this.topIndex == -1;
  }

  // add element to top of the stack
  public void push(int val) {
    this.stackArray[++this.topIndex] = val;
  }

  // return element from top of the stack without removing it
  public int peek() {
    if(this.isEmpty()) throw new EmptyStackException();
    return this.stackArray[this.topIndex];
  }

  // return element from top of the stack and remove it
  public int pop() throws EmptyStackException {
    if(this.isEmpty() == true) {
      throw new EmptyStackException();
    }else {
      int copy = this.stackArray[this.topIndex];
      this.stackArray[this.topIndex] = 0;
      this.topIndex--;
      return copy;
    }
  }
}

// implementation of Stack using LinkedLists
class StackLinkedList {
  StackNode top;

  class StackNode {
    int data;
    StackNode next;
    StackNode(int data) {
      this.data = data;
    }
  }

  public boolean isEmpty() {
    return this.top == null;
  }

  // add element to top of the stack
  public void push(int val) {
    // create new node
    StackNode newNode = new StackNode(val);
    newNode.next = this.top;
    this.top = newNode;
  }

  // return element from top of the stack without removing it
  public int peek() {
    return this.top.data;
  }

  // return element from top of the stack and remove it
  public int pop() throws EmptyStackException {
    if(this.isEmpty()) {
      throw new EmptyStackException();
    }else {
      int copy = this.top.data;
      this.top = this.top.next;
      return copy;
    }
  }
}
