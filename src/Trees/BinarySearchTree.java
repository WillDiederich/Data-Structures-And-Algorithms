package Trees;

import java.util.Collection;

public class BinarySearchTree {
    private static class Node {
        int value;
        Node left;
        Node right;

        Node(int value){
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    Node root;

    // Creates an empty Binary Search Tree.
    public BinarySearchTree(){
        root = null;
    }

    // Creates a Binary Search Tree containing a single node.
    public BinarySearchTree(int value){
        root = new Node(value);
    }

    // Creates a Binary Search Tree containing multiple nodes from a list of integers.
    public BinarySearchTree(Collection<Integer> values){
        add(values);
    }

    // Add a new node
    public void add(int value){
        root = add(root, value);
    }

    // Add multiple nodes from a list of integers.
    public void add(Collection<Integer> values){
        for(int value : values){
            add(value);
        }
    }

    // Add a new node after finding where it should be inserted.
    private Node add(Node current, int value){
        // If the current node is null, we create and return a new node containing the value.
        if(current == null){
            return new Node(value);
        }
        // Traverse the left subtree.
        if(value < current.value){
            current.left = add(current.left, value);
        }
        // Traverse the right subtree.
        else if(value > current.value){
            current.right = add(current.right, value);
        }
        // The value already exists in the tree.
        else {
            return current;
        }
        return current;
    }

    public void remove(int value){
        root = remove(root, value);
    }

    private Node remove(Node current, int value){
        if(current == null){
            return current;
        }
        // The node containing the value has been found
        else if(value == current.value){
            // The node is a leaf node
            if(current.left == null && current.right == null){
                return null;
            }
            // The node only has a right subtree.
            if(current.left == null){
                return current.right;
            }
            // The node only has a left subtree.
            if(current.right == null){
                return current.left;
            }
            // The node has both a left and right subtree
            Node minNode = findMin(current.right);
            current.value = minNode.value;
            current.right = remove(current.right, current.value);
        }
        // Traverse the left subtree.
        else if(value < current.value){
            current.left = remove(current.left, value);
        }
        // Traverse the right subtree.
        else if(value > current.value){
            current.right = remove(current.right, value);
        }
        return current;
    }

    public Node findMin(Node current){
        if (current.left == null) {
            return current;
        }
        return findMin(current.left);
    }
}
