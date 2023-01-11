package Lists;

import java.util.Collection;

public class SinglyLinkedList<E> {
    private static class Node<E> {
        E data;
        Node<E> next;

        Node(E e){
            this.data = e;
            this.next = null;
        }
    }

    Node<E> head = null;
    Node<E> tail = null;
    int size;

    public SinglyLinkedList(){

    }

    public void add(E e){
        Node<E> newNode = new Node<>(e);
        if(head == null){
            head = newNode;
        }
        else{
            tail.next = newNode;
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

    public void remove(E e){
        if(head == null){
            return;
        }
        else if(head.data == e){
            head = head.next;
            size--;
        }

        Node<E> current = head;
        Node<E> previous = null;
        while(current != null){
            if(current.data == e){
                previous.next = current.next;
                size--;
                if(current == tail){
                    tail = previous;
                }
                return;
            }
            else{
                previous = current;
                current = current.next;
            }
        }
    }

    public boolean isEmpty(){
        return head == null;
    }

    public int size(){
        return size;
    }
}
