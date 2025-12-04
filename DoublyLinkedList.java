package Driver;

// Using a doubly linked list for the new methods
public class DoublyLinkedList {


    // Node Class

    private static class Node {
        Object data;
        Node next;
        Node previous;

        Node(Object data) {
            this.data = data;
            this.next = null;
            this.previous = null;
        }
    }

    private Node head;
    private Node end;


    // Append (from old doubly linked list code)

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

    // Prepend (from old doubly linked list code)

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


    // Insert 
    
    public void insertAt(int index, Object value) {
        if (index < 0) {
            System.out.println("Index out of bounds.");
            return;
        }

        if (index == 0) {
            prepend(value);
            return;
        }

        Node current = head;
        int count = 0;

        while (current != null && count < index) {
            current = current.next;
            count++;
        }

        if (current == null) {  
            append(value);
            return;
        }

        Node newNode = new Node(value);
        newNode.previous = current.previous;
        newNode.next = current;

        current.previous.next = newNode;
        current.previous = newNode;
    }

 
    // Remove At Index
  
    public Object removeAt(int index) {
        if (index < 0 || head == null) {
            System.out.println("Index out of bounds.");
            return null;
        }

        if (index == 0) {
            Object value = head.data;
            head = head.next;

            if (head != null) head.previous = null;
            else end = null;

            return value;
        }

        Node current = head;
        int count = 0;

        while (current != null && count < index) {
            current = current.next;
            count++;
        }

        if (current == null) {
            System.out.println("Index out of bounds.");
            return null;
        }

        Object value = current.data;

        if (current == end) {
            end = end.previous;
            if (end != null) end.next = null;
        } else {
            current.previous.next = current.next;
            current.next.previous = current.previous;
        }

        return value;
    }


    // Search 
  
    public int search(Object value) {
        Node current = head;
        int index = 0;

        while (current != null) {
            if (current.data.equals(value)) {
                return index;
            }
            current = current.next;
            index++;
        }

        return -1; // not found
    }

   
    // Sort (Bubble Sort)
 
    public void sort(boolean ascending) {
        if (head == null || head.next == null) return;

        boolean swapped;

        do {
            swapped = false;
            Node current = head;

            while (current.next != null) {

                Comparable a = (Comparable) current.data;
                Comparable b = (Comparable) current.next.data;

                boolean condition = ascending ? (a.compareTo(b) > 0)
                                              : (a.compareTo(b) < 0);

                if (condition) {
                    Object temp = current.data;
                    current.data = current.next.data;
                    current.next.data = temp;
                    swapped = true;
                }

                current = current.next;
            }
        } while (swapped);
    }

  
    // Print List
   
    public void print() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

}
