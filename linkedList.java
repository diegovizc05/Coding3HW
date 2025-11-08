package Driver;

public class linkedList {

    // Node class: represents each element in the list
    private static class Node {
        Object data;   // stores any type of value
        Node next;     // reference to the next node

        Node(Object data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;  // head node of the linked list

    // Append: Adds a new node to the end of the list
    public void append(Object value) {
        Node newNode = new Node(value);

        if (head == null) {
            head = newNode;
            return;
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;
    }
    
    // Prepend: Adds a new node to the beginning of the list
    public void prepend(Object value) {
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;
    }

    // insertAfter: Inserts a new node after a target value
    public void insertAfter(Object target, Object value) {
        Node current = head;

        while (current != null && !current.data.equals(target)) {
            current = current.next;
        }

        if (current != null) {
            Node newNode = new Node(value);
            newNode.next = current.next;
            current.next = newNode;
        } else {
            System.out.println("Target value not found: " + target);
        }
    }

    // insertBefore: Inserts a new node before a target value
    public void insertBefore(Object target, Object value) {
        if (head == null) return;

        if (head.data.equals(target)) {
            prepend(value);
            return;
        }

        Node current = head;
        while (current.next != null && !current.next.data.equals(target)) {
            current = current.next;
        }

        if (current.next != null) {
            Node newNode = new Node(value);
            newNode.next = current.next;
            current.next = newNode;
        } else {
            System.out.println("Target value not found: " + target);
        }
    }

    // delete: Deletes the first node that contains the given value
    public void delete(Object value) {
        if (head == null) return;

        if (head.data.equals(value)) {
            head = head.next;
            return;
        }

        Node current = head;
        while (current.next != null && !current.next.data.equals(value)) {
            current = current.next;
        }

        if (current.next != null) {
            current.next = current.next.next;
        } else {
            System.out.println("Value not found: " + value);
        }
    }

    // remove: Removes the last node of the list
    public void remove() {
        if (head == null) return;

        if (head.next == null) {
            head = null;
            return;
        }

        Node current = head;
        while (current.next.next != null) {
            current = current.next;
        }

        current.next = null;
    }


    // search: Returns true if a node contains the value
    public boolean search(Object value) {
        Node current = head;
        while (current != null) {
            if (current.data.equals(value)) return true;
            current = current.next;
        }
        return false;
    }

    // length: Counts the total number of nodes
    public int length() {
        int count = 0;
        Node current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    // isEmpty: Returns true if the list is empty
    public boolean isEmpty() {
        return head == null;
    }

    //Bubble Sort
    public void sort() {
        if (head == null || head.next == null) return;

        boolean swapped;
        do {
            swapped = false;
            Node current = head;
            Node prev = null;

            // Bubble sort: compare pairs and swap if needed
            while (current != null && current.next != null) {
                Comparable currentData = (Comparable) current.data;
                Comparable nextData = (Comparable) current.next.data;

                // Compare current and next; swap if out of order
                if (currentData.compareTo(nextData) > 0) {
                    Node temp = current.next;
                    current.next = temp.next;
                    temp.next = current;

                    if (prev == null) {
                        head = temp;
                    } else {
                        prev.next = temp;
                    }

                    prev = temp;
                    swapped = true;
                } else {
                    prev = current;
                    current = current.next;
                }
            }
        } while (swapped);

        // How Bubble Sort works:
        // - Repeatedly compares each pair of adjacent nodes
        // - Swaps them if they are out of order
        // - Continues until a full pass occurs with no swaps
    }

    // print: Displays all elements in the list
    public void print() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    // Test the linked list
    public static void main(String[] args) {
        linkedList list = new linkedList();

        list.append(5);
        list.append(3);
        list.append(8);
        list.append(1);

        System.out.print("Initial list: ");
        list.print();

        list.prepend(10);
        System.out.print("After prepend(10): ");
        list.print();

        list.insertAfter(3, 7);
        System.out.print("After insertAfter(3,7): ");
        list.print();

        list.insertBefore(8, 6);
        System.out.print("After insertBefore(8,6): ");
        list.print();

        list.delete(1);
        System.out.print("After delete(1): ");
        list.print();

        list.remove();
        System.out.print("After remove(): ");
        list.print();

        System.out.println("Search(5): " + list.search(5));
        System.out.println("Length: " + list.length());
        System.out.println("IsEmpty: " + list.isEmpty());

        list.sort();
        System.out.print("After sort(): ");
        list.print();
    }
}
