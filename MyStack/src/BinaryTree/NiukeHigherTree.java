package BinaryTree;

public class NiukeHigherTree {
    /* public class Solution {
        TreeNode prev = null;
        public void ConvertChild(TreeNode pCur){
            if(pCur == null){
                return;
            }
            ConvertChild(pCur.left);
            pCur.left = prev;
            if(prev != null){
                prev.right = pCur;
            }
            prev = pCur;
            ConvertChild(pCur.right);
        }
        public TreeNode Convert(TreeNode pRootOfTree) {
            ConvertChild(pRootOfTree);
            TreeNode head = pRootOfTree;
            while(head != null && head.left != null){
                head = head.left;
            }
            return head;
        }
    }*/


   /* public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return null;
        }
        if(root == p || root == q){
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        if(left != null && right != null){
            return root;
        }
        if(left != null){
            return left;
        }
        if(right != null) {
            return right;
        }
        return null;

    }*/

   /* public boolean idSymmetricChild(TreeNode leftTree,TreeNode rightTree){
        if(leftTree == null && rightTree == null){
            return true;
        }
        if((leftTree == null&&rightTree != null)||(leftTree != null && rightTree == null)){
            return false;
        }
        return (leftTree.val == rightTree.val)&&idSymmetricChild(leftTree.left,rightTree.right)&&idSymmetricChild(rightTree.left,leftTree.right);
    }
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        return idSymmetricChild(root.left,root.right);
    }*/

}
