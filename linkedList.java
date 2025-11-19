
package Driver;

// *doubly linked list*
public class linkedList {

    // Node class supports both next and previous references
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

    // Append adds node to the tail of the list
    public void append(Object value) {
        Node newNode = new Node(value);

        if (head == null) {
            head = newNode;
            end = newNode;
            return;
        }

        end.next = newNode;
        newNode.previous = end;
        end = newNode;
    }

    // Prepend adds a node to the head of the list
    public void prepend(Object value) {
        Node newNode = new Node(value);

        if (head == null) {
            head = newNode;
            end = newNode;
            return;
        }

        newNode.next = head;
        head.previous = newNode;
        head = newNode;
    }

    // Insert after a target value
    public void insertAfter(Object target, Object value) {
        Node current = head;

        while (current != null && !current.data.equals(target)) {
            current = current.next;
        }

        if (current != null) {
            Node newNode = new Node(value);
            newNode.next = current.next;
            newNode.previous = current;

            if (current.next != null) {
                current.next.previous = newNode;
            } else {
                end = newNode;
            }

            current.next = newNode;
        } else {
            System.out.println("Target value not found: " + target);
        }
    }

    // Insert before a target value
    public void insertBefore(Object target, Object value) {
        if (head == null) return;

        if (head.data.equals(target)) {
            prepend(value);
            return;
        }

        Node current = head;
        while (current != null && !current.data.equals(target)) {
            current = current.next;
        }

        if (current != null) {
            Node newNode = new Node(value);
            newNode.next = current;
            newNode.previous = current.previous;

            current.previous.next = newNode;
            current.previous = newNode;
        } else {
            System.out.println("Target value not found: " + target);
        }
    }

    // Delete a single node by value
    public void delete(Object value) {
        if (head == null) return;

        Node current = head;

        while (current != null && !current.data.equals(value)) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("Value not found: " + value);
            return;
        }

        if (current == head) {
            head = head.next;
            if (head != null) head.previous = null;
            else end = null;
            return;
        }

        if (current == end) {
            end = end.previous;
            end.next = null;
            return;
        }

        current.previous.next = current.next;
        current.next.previous = current.previous;
    }

    // Remove last element
    public void remove() {
        if (head == null) return;

        if (head == end) {
            head = null;
            end = null;
            return;
        }

        end = end.previous;
        end.next = null;
    }

    // Search for a value
    public boolean search(Object value) {
        Node current = head;
        while (current != null) {
            if (current.data.equals(value)) return true;
            current = current.next;
        }
        return false;
    }

    // Length of the list
    public int length() {
        int count = 0;
        Node current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    // Is list empty
    public boolean isEmpty() {
        return head == null;
    }

    // Bubble Sort (forward traversal only)
    public void sort() {
        if (head == null || head.next == null) return;

        boolean swapped;
        do {
            swapped = false;
            Node current = head;

            while (current.next != null) {
                Comparable a = (Comparable) current.data;
                Comparable b = (Comparable) current.next.data;

                if (a.compareTo(b) > 0) {
                    Object temp = current.data;
                    current.data = current.next.data;
                    current.next.data = temp;
                    swapped = true;
                }
                current = current.next;
            }
        } while (swapped);
    }

    // Print list from head to tail
    public void print() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    // Print list in reverse (tail to head)
    public void printReverse() {
        Node current = end;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.previous;
        }
        System.out.println();
    }

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

        System.out.print("Reverse print: ");
        list.printReverse();
    }
}

