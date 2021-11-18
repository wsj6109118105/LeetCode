/** 二叉树的坡度
 * user:lufei
 * DATE:2021/11/18
 **/
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

public class binaryTreeTilt {
    int ans = 0;
    public int findTilt(TreeNode root) {
        dfs(root);
        return ans;
    }

    int dfs(TreeNode node) {
        if(node==null) {
            return 0;
        }
        int left = dfs(node.left);
        int right = dfs(node.right);
        ans += Math.abs(left-right);
        return left+right+node.val;
    }
}
