package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TestBinaryTree2 {
    class TreeNode{
        char val;
        TreeNode left;
        TreeNode right;
        public TreeNode(char val) {
            this.val = val;
        }

        //根据字符串创建二叉树
        private int i=0;
        TreeNode createTestTree(String s){
            TreeNode root = null;
            if(s.charAt(i) !='#'){
                root = new TreeNode(s.charAt(i));
                i++;
                root.left = createTestTree(s);
                root.right = createTestTree(s);
            }else{
                i++;
            }
            return root;
        }

        // 结点个数
        int getSize(TreeNode root){
            if(root == null){
                return 0;
            }
            return getSize(root.left)+getSize(root.right)+1;
        }

        // 叶子结点个数
        int getLeafSize(TreeNode root){
            if(root == null){
                return 0;
            }
            if(root.left == null && root.right == null){
                return 1;
            }
            return getLeafSize(root.left)+getLeafSize(root.right);
        }
        // 第 k 层结点个数
        int getKLevelSize(TreeNode root, int k){
            if(root == null){
                return 0;
            }
            if(k == 1){
                return 1;
            }
            return getKLevelSize(root.left,k-1)+getKLevelSize(root.right,k-1);
        }

        //二叉树的高度
        int height(TreeNode root){
            if(root == null){
                return 0;
            }else{
                int left = height(root.left);
                int right = height(root.right);
                return (left>right? left:right)+1;
            }
        }

        // 查找，依次在二叉树的 根、左子树、右子树 中查找 value(前序遍历)，如果找到，返回结点，否则返回 null
        /*TreeNode find(TreeNode root, int value){
            if(root == null){
                return null;
            }else {
                find(root.left,value);
            }

        }*/
        //前序遍历
        void binaryTreePrevOrder(TreeNode root){
            if(root == null){
                return;
            }
            System.out.println(root.val+" ");
            binaryTreePrevOrder(root.left);
            binaryTreePrevOrder(root.right);
        }
        //中序遍历
        void binaryTreeInOrder(TreeNode root){
            if(root == null){
                return;
            }
            binaryTreeInOrder(root.left);
            System.out.println(root.val+" ");
            binaryTreeInOrder(root.right);
        }
        //后序
        void binaryTreePostOrder(TreeNode root){
            if(root == null){
                return;
            }
            binaryTreeInOrder(root.left);
            binaryTreeInOrder(root.right);
            System.out.println(root.val+" ");
        }

        //二叉树的前序遍历非递归
        void binaryTreePrevOrderNonR(TreeNode root){
            Stack<TreeNode> stack = new Stack<>();
            TreeNode cur = root;
            TreeNode top = null;
            while(cur != null || !stack.isEmpty()){
                while(cur != null){
                    stack.push(cur);
                    System.out.print(cur.val+" ");
                    cur = cur.left;
                }
                top = stack.pop();
                cur = top.right;
            }
        }
        //二叉树的中序遍历非递归
        void binaryTreeInOrderNonR(TreeNode root){
            Stack<TreeNode> stack = new Stack<>();
            TreeNode cur = root;
            TreeNode top = null;
            while(cur != null || !stack.isEmpty()){
                while(cur != null){
                    stack.push(cur);
                    cur = cur.left;
                }
                top = stack.pop();
                System.out.print(top.val+" ");
                cur = top.right;
            }
        }

        //二叉树的后序遍历非递归
        void binaryTreePostOrderNonR(TreeNode root){
            Stack<TreeNode> stack = new Stack<>();
            TreeNode cur = root;
            TreeNode top = null;
            while(cur != null || !stack.isEmpty()){
                while(cur != null){
                    stack.push(cur);
                    cur = cur.left;
                }
                top = stack.pop();
                cur = top.right;
                System.out.print(top.val+" ");
            }
        }
        //二叉树的层序遍历
        void binaryTreeLevelOrder(TreeNode root){
            Queue<TreeNode> queue = new LinkedList<>();
            if(root != null){
                queue.offer(root);
            }
            while(!queue.isEmpty()){
                TreeNode cur = queue.poll();
                System.out.println(cur.val);
                if(cur.left != null){
                    queue.offer(cur.left);
                }
                if(cur.right != null){
                    queue.offer(cur.right);
                }
            }
        }

        //判断一棵树是否是完全二叉树 返回0代表是完全二叉树
        /*int binaryTreeComplete(TreeNode root) {
            TreeNode cur = root;
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(cur);
            while ((cur = queue.poll()) != null) {
                queue.offer(cur.left);
                queue.offer(cur.right);
            }
            while(!queue){

            }
        }*/
    }
}
