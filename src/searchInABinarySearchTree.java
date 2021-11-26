/** 先序遍历即可
 * user:lufei
 * DATE:2021/11/26
 **/
public class searchInABinarySearchTree {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public TreeNode searchBST(TreeNode root, int val) {
        if(root==null) {
            return null;
        }
        if(root.val==val){
            return root;
        }
        TreeNode ln = searchBST(root.left,val);
        TreeNode rn = searchBST(root.right,val);
        return ln==null?rn:ln;
    }
}
