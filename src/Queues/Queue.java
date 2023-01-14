package Queues;

public class Queue<E> {
    private static class Node<E>{
        E data;
        Node next;
        public Node(E e){
            this.data = e;
            this.next = null;
        }
    }

    Node<E> head;
    Node<E> tail;
    int size;

    public Queue(){

    }

    public void add(E e){
        if(head == null){
            head = new Node(e);
            tail = head;
        }
        else{
            tail.next = new Node(e);
            tail = tail.next;
        }
    }

    public E poll(){
        if(head == null){
            return null;
        }
        else{
            Node<E> temp = head;
            head = head.next;
            if(head == null){
                tail = null;
            }
            return temp.data;
        }
    }

    public E peek(){
        if(head == null){
            return head.data;
        }
        else
            return null;
    }
}
