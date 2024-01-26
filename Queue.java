public class Queue {
  public static void main(String[] args) {
    QueueArray queue1 = new QueueArray();
    queue1.enqueue(5);
    queue1.enqueue(6);
    queue1.enqueue(7);
    queue1.enqueue(8);
    queue1.poll();
    queue1.poll();
    queue1.poll();
    queue1.poll();
    // queue1.poll();
    System.out.println(queue1.isEmpty());

    System.out.println("----------------------------");

    QueueLinkedList queue2 = new QueueLinkedList();
    queue2.enqueue(10);
    queue2.enqueue(20);
    queue2.enqueue(30);
    queue2.enqueue(40);
    queue2.poll();
    queue2.poll();
    System.out.println(queue2.front());
  }
}

// implementation of Queues using Arrays
class QueueArray {
  static final int MAX = 1000;
  int frontIndex = 0, backIndex = -1;
  int[] queueArray = new int[MAX]; // Maximum size of Queue
  
  public boolean isEmpty() {
    return this.frontIndex > this.backIndex;
  }

  // add element at the end of the queue
  public void enqueue(int val) {
    this.queueArray[++this.backIndex] = val;
  }

  // Returns the value in front of the queue without removing it.
  public int front() throws ArrayIndexOutOfBoundsException {
    if(this.isEmpty()) {
      throw new ArrayIndexOutOfBoundsException("Not found as queue is empty");
    }else {
      return this.queueArray[this.frontIndex];
    }
  }

  // Returns the value in front of the queue and remove it.
  public int poll() throws ArrayIndexOutOfBoundsException {
    if(this.isEmpty()) {
      throw new ArrayIndexOutOfBoundsException("queue is empty");
    }else {
      int copy = this.queueArray[this.frontIndex];
      this.queueArray[this.frontIndex] = 0;
      this.frontIndex++;
      return copy;
    }
  }
}

// implementation of Queues using LinkedLists
class QueueLinkedList {
  QueueNode front, back;
  
  class QueueNode {
    int data;
    QueueNode next;
    QueueNode (int data) {
      this.data = data;
    }
  }

  public boolean isEmpty() {
    return this.front == null;
  }

  // add element at the end of the queue
  public void enqueue(int val) {
    // create new node
    QueueNode newNode = new QueueNode(val);

    if(this.isEmpty()) {
      this.front = this.back = newNode;
    }else {
      this.back.next = newNode;
      this.back = newNode;
    }
  }

  // Returns the value in front of the queue without removing it.
  public int front() throws ArrayIndexOutOfBoundsException {
    if(this.isEmpty()){ 
      throw new ArrayIndexOutOfBoundsException("Not found as queue is empty");
    }else {
      return this.front.data;
    }
  }

  // Returns the value in front of the queue and remove it.
  public int poll() throws ArrayIndexOutOfBoundsException {
    if(this.isEmpty()){ 
      throw new ArrayIndexOutOfBoundsException("Not found as queue is empty");
    }else {
      int copy = this.front.data;
      this.front = this.front.next;
      return copy;
    }
  }
}