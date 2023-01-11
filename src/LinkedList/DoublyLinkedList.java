package LinkedList;

import java.util.Collection;

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
        if(head == null)
            return;
        if(head.data == e)
            head = head.next;
        if(tail.data == e)
            tail = tail.previous;
        for(Node x = head; x != null; x = x.next){
            if(x.data == e){
                x.previous.next = x.next;
                x.next.previous = x.previous;
            }
        }
        size--;
    }

    public boolean isEmpty(){
        if(head == null)
            return true;
        return false;
    }

    public int size(){
        return size;
    }
}
