package gameThree;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * user:lufei
 * DATE:2021/12/5
 **/
public class Three {

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

    public String getDirections(TreeNode root, int startValue, int destValue) {
        List<Character> start = new ArrayList<>();
        List<Character> dest = new ArrayList<>();
        dfs(root,startValue,start);
        dfs(root,destValue,dest);
        int count = 0;
        for (int i = 0;i<Math.min(start.size(),dest.size());i++) {
            if (start.get(i)==dest.get(i)) {
                count++;
            }else {
                break;
            }
        }
        String s = "";
        for (int i = start.size()-1;i>=count;i--) {
            s += "U";
        }
        for (int i = count;i<dest.size();i++) {
            s += dest.get(i);
        }
        return s;
    }

    public boolean dfs(TreeNode root,int val,List<Character> list) {
        if(root==null) {
            return false;
        }
        if (root.val==val){
            return true;
        }
        list.add('L');
        boolean l = dfs(root.left, val, list);
        if (l) {
            return true;
        }else {
            list.remove(list.size()-1);
        }
        list.add('R');
        boolean r = dfs(root.right, val, list);
        if (r) {
            return true;
        }else{
            list.remove(list.size()-1);
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
