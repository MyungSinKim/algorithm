package algorithm.tree;


import java.util.Stack;

/**
 * @author 李文浩
 * @version 2017/7/30.
 */
public class BinaryTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        treeNode3.left = treeNode6;

//        System.out.println("先序递归");
//        preOrder(treeNode1);
//        System.out.println();
//        System.out.println("中序递归");
//        inOrder(treeNode1);
//        System.out.println();
        System.out.println("后序递归");
        postOrder(treeNode1);
        System.out.println();
//        System.out.println("先序非递归");
//        preStack(treeNode1);
//        System.out.println();
//        System.out.println("先序非递归2");
//        preStack2(treeNode1);
//        System.out.println();
//        System.out.println("中序非递归");
//        inStack(treeNode1);
//        System.out.println();
        System.out.println("后序非递归");
        postStack(treeNode1);
        System.out.println();
    }

    /**
     * 先序递归
     *
     * @param treeNode
     */
    public static void preOrder(TreeNode treeNode) {
        if (treeNode != null) {
            System.out.print(treeNode.val + " ");
            preOrder(treeNode.left);
            preOrder(treeNode.right);
        }
    }

    /**
     * 中序递归
     *
     * @param treeNode
     */
    public static void inOrder(TreeNode treeNode) {
        if (treeNode != null) {
            inOrder(treeNode.left);
            System.out.print(treeNode.val + " ");
            inOrder(treeNode.right);
        }
    }

    /**
     * 后序递归
     *
     * @param treeNode
     */
    public static void postOrder(TreeNode treeNode) {
        if (treeNode != null) {
            postOrder(treeNode.left);
            postOrder(treeNode.right);
            System.out.print(treeNode.val + " ");
        }
    }

    /**
     * 先序非递归
     *
     * @param root
     */
    public static void preStack(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode treeNode = stack.pop();
            System.out.print(treeNode.val + " ");
            if (treeNode.right != null) {
                stack.push(treeNode.right);
            }
            if (treeNode.left != null) {
                stack.push(treeNode.left);
            }
        }
    }

    /**
     * 先序非递归2
     *
     * @param root
     */
    public static void preStack2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode treeNode = root;
        while (treeNode != null || !stack.isEmpty()) {
            while (treeNode != null) {
                System.out.print(treeNode.val + " ");
                stack.push(treeNode);
                treeNode = treeNode.left;
            }
            if (!stack.isEmpty()) {
                treeNode = stack.pop();
                treeNode = treeNode.right;
            }

        }

    }

    /**
     * 中序非递归
     *
     * @param treeNode
     */
    public static void inStack(TreeNode treeNode) {
        Stack<TreeNode> stack = new Stack<>();
        while (treeNode != null || !stack.isEmpty()) {
            while (treeNode != null) {
                stack.push(treeNode);
                treeNode = treeNode.left;
            }
            if (!stack.isEmpty()) {
                treeNode = stack.pop();
                System.out.print(treeNode.val + " ");
                treeNode = treeNode.right;
            }
        }
    }

    public static class TagNode {
        TreeNode treeNode;
        boolean isFirst;
    }

    /**
     * 后序非递归
     *
     * @param treeNode
     */
    public static void postStack(TreeNode treeNode) {
        Stack<TagNode> stack = new Stack<>();
        TagNode tagNode;
        while (treeNode != null || !stack.isEmpty()) {
            while (treeNode != null) {
                tagNode = new TagNode();
                tagNode.treeNode = treeNode;
                tagNode.isFirst = true;
                stack.push(tagNode);
                treeNode = treeNode.left;
            }

            if (!stack.isEmpty()) {
                tagNode = stack.pop();
                if (tagNode.isFirst == true) {
                    tagNode.isFirst = false;
                    stack.push(tagNode);
                    treeNode = tagNode.treeNode.right;
                } else {
                    System.out.print(tagNode.treeNode.val + " ");
                    treeNode = null;
                }
            }
        }
    }


}
