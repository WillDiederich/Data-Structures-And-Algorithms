package Lists;

import java.util.Collection;
import java.util.LinkedList;

public class DoublyLinkedList<E> {
    class Node<E>{

        E data;
        Node previous;
        Node next;

        Node(E e){
            this.data = e;
            this.previous = null;
            this.next = null;
        }
    }

    Node head = null;
    Node tail = null;
    int size;

    public void DoublyLinkedList(){

    }

    public void add(E e){
        Node newNode = new Node(e);
        if(head == null){
            head = newNode;
        }
        else{
            tail.next = newNode;
            newNode.previous = tail;
        }
        tail = newNode;
        size++;
    }

    public void add(Collection<? extends E> c){
        for(E e : c){
            add(e);
        }
    }

    public void remove(E e){
        if(head == null){
            return;
        }
        else if(head.data == e && tail.data == e){
            head = null;
            tail = null;
        }
        else if(head.data == e){
            head = head.next;
            head.previous = null;
        }
        else if(tail.data == e){
            tail = tail.previous;
            tail.next = null;
        }
        else{
            Node current = head;
            while(current != null && current.data != e){
                current = current.next;
            }
            if(current != null && current.data == e){
                current.previous.next = current.next;
                current.next.previous = current.previous;
            }
        }
        size--;
    }

    public boolean isEmpty(){
        return head == null;
    }

    public int size(){
        return size;
    }
}
