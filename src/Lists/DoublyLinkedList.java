package Lists;
import java.util.Collection;

public class DoublyLinkedList<E> {
    private static class Node<E> {
        E data;
        Node<E> previous;
        Node<E> next;

        Node(E e){
            this.data = e;
            this.previous = null;
            this.next = null;
        }
    }

    Node<E>head = null;
    Node<E> tail = null;
    int size;

    public DoublyLinkedList() {
    }

    // Adds a new node to the end of the list
    public void add(E e) {
        Node<E> newNode = new Node<>(e);
        if(head == null) {
            head = newNode;
        }
        else {
            tail.next = newNode;
            newNode.previous = tail;
        }
        tail = newNode;
        size++;
    }

    // Adds a collection of values to the list
    public void add(Collection<? extends E> c) {
        for(E e : c) {
            add(e);
        }
    }

    // Remove first occurrence of a node, if it exists.
    // This method is a mess and will be updated.
    public void remove(E e) {
        // List is not empty.
        if(head != null) {
            // List contains a single node and that node is our target node.
            if (head.data == e && tail.data == e) {
                head = null;
                tail = null;
                size--;
            }
            // The head of the list is our target node.
            else if (head.data == e) {
                head = head.next;
                head.previous = null;
                size--;
            }
            // The tail of the list is our target node.
            else if (tail.data == e) {
                tail = tail.previous;
                tail.next = null;
                size--;
            }
            // The target node is potentially somewhere between the head of the list and the tail.
            else {
                Node<E> current = head;
                while (current != null && current.data != e) {
                    current = current.next;
                }
                if (current != null) {
                    current.previous.next = current.next;
                    current.next.previous = current.previous;
                    size--;
                }
            }
        }
    }

    // Returns true if the list is empty, false if the list contains one or mode nodes.
    public boolean isEmpty(){
        return head == null;
    }

    public int size(){
        return size;
    }
}