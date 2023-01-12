package Trees;

public class BinaryTreeNode {
    int value;
    BinaryTreeNode left;
    BinaryTreeNode right;

    BinaryTreeNode(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public BinaryTreeNode add(BinaryTreeNode root, int value){
        if(root == null){
            return new BinaryTreeNode(value);
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
