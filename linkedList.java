package Driver;

// *Stack interface with doubly linked list logic*
public class linkedList {

    public static void main(String[] args) {

        // Test stack
        MyStack stack = new MyStack();
        stack.push(3);
        stack.push(5);
        stack.push(7);

        System.out.println("Peek: " + stack.peek());
        System.out.println("Pop: " + stack.pop());
        System.out.print("New Stack: ");
        stack.print();

        // Test Queue
        MyQueue queue = new MyQueue();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        System.out.println("Queue Front: " + queue.front());
        System.out.println("Dequeued: " + queue.dequeue());
        System.out.print("New Queue: ");
        queue.print();
    }
}

// Stack interface
interface Stack {
    void push(Object value);
    Object pop();
    Object peek();
}

// Queue interface
interface Queue {
    void enqueue(Object value);
    Object dequeue();
    Object front();
}

// Doubly Linked List
class MyDoublyLinkedList {

    protected static class Node {
        Object data;
        Node next;
        Node previous;

        Node(Object data) {
            this.data = data;
        }
    }

    protected Node head;
    protected Node end;

    // Append 
    public void append(Object value) {
        Node newNode = new Node(value);

        if (head == null) {
            head = end = newNode;
            return;
        }

        end.next = newNode;
        newNode.previous = end;
        end = newNode;
    }

    // Prepend
    public void prepend(Object value) {
        Node newNode = new Node(value);

        if (head == null) {
            head = end = newNode;
            return;
        }

        newNode.next = head;
        head.previous = newNode;
        head = newNode;
    }

    // Remove last
    public Object removeLast() {
        if (head == null) return null;

        Object value = end.data;

        if (head == end) {
            head = end = null;
            return value;
        }

        end = end.previous;
        end.next = null;
        return value;
    }

    // Remove first
    public Object removeFirst() {
        if (head == null) return null;

        Object value = head.data;

        if (head == end) {
            head = end = null;
            return value;
        }

        head = head.next;
        head.previous = null;
        return value;
    }

    // Front/back access
    public Object getFirst() { return head != null ? head.data : null; }
    public Object getLast()  { return end != null ? end.data : null; }

    // Print list
    public void print() {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }
}

// Stack implemented
class MyStack extends MyDoublyLinkedList implements Stack {

    public void push(Object value) {
        append(value);
    }

    public Object pop() {
        return removeLast();
    }

    public Object peek() {
        return getLast();
    }
}

// Queue implemented
class MyQueue extends MyDoublyLinkedList implements Queue {

    public void enqueue(Object value) {
        append(value);
    }

    public Object dequeue() {
        return removeFirst();
    }

    public Object front() {
        return getFirst();
    }
}




