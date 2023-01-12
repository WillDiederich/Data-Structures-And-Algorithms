package Trees;

public class LevelOrderTraversal {
    public static void main(String[] args) {
        Node root = new Node(6);
        root.add(root, 12);
        root.add(root, 15);
        root.add(root, 8);
        root.add(root, 3);
        root.add(root, 1);
        levelOrderTraversal(root);
    }

    public static void levelOrderTraversal(Node root){
        int height = getHeight(root);
        for(int x = 1; x <= height; x++){
            System.out.print("Level " + x + ": ");
            printLevel(root, x);
            System.out.println();
        }
    }

    public static void printLevel(Node root, int level){
        if(root == null)
            return;
        if(level == 1)
            System.out.print(root.value + " ");
        if(level > 1){
            printLevel(root.left, level - 1);
            printLevel(root.right, level - 1);
        }
    }

    public static int getHeight(Node root){
        if(root == null){
            return 0;
        }
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
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
