package Trees;

public class PreorderTraversal {
    public static void main(String[] args) {
        Node root = new Node(6);
        root.add(root, 12);
        root.add(root, 15);
        root.add(root, 8);
        root.add(root, 3);
        root.add(root, 1);
        preorderTraversal(root);
    }

    public static void preorderTraversal(Node current){
        if(current == null)
            return;
        System.out.println(current.value);
        preorderTraversal(current.left);
        preorderTraversal(current.right);
    }

    private static class Node {
        int value;
        Node left;
        Node right;

        Node(int value){
            this.value = value;
            this.left = null;
            this.right = null;
        }

        public Node add(Node root, int value){
            if(root == null){
                return new Node(value);
            }
            else if(value < root.value){
                root.left = add(root.left, value);
            }
            else{
                root.right = add(root.right, value);
            }
            return root;
        }
    }
}
