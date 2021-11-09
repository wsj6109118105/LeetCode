import java.awt.image.AbstractMultiResolutionImage;
import java.util.HashMap;
import java.util.Map;

/**
 * 祖玛游戏
 * user:lufei
 * DATE:2021/11/9
 **/
public class zumaGame {
    final int MAXSCORE = 6;
    Map<String, Integer> map = new HashMap<>();

    public int findMinStep(String board, String hand) {
        if (backtrack(new StringBuilder(board), new StringBuilder(hand)) == MAXSCORE) return -1;
        return map.get(board + "," + hand);
    }

    private int backtrack(StringBuilder board, StringBuilder hand) {
        // 完成条件
        // 中断条件
        int score = MAXSCORE;
        if (board.length()==0) return score;
        String status = board+","+hand;
        if (map.containsKey(status)) return map.get(status);
        // 循环
        // 选择
        // 插入
        // 递归消除
        // 回溯
        // 删除插入
        for (int i = 0;i<hand.length();i++) {
            for (int j = 0;j<board.length();j++) {
                board.insert(j,hand.charAt(i));
                String newBoard = recur(board.toString());
                if (newBoard.length()==0) {
                    map.put(status,1);
                    return 1;
                }
                hand.deleteCharAt(i);
                score = Math.min(score,backtrack(new StringBuilder(newBoard),hand)+1);
                hand.insert(i,board.charAt(j));
                board.deleteCharAt(j);
            }
        }
        // 记忆
        map.put(status,score);
        return score;
    }

    // 递归消除
    String recur(String board) {
        int len = board.length();
        for (int l = 0, r = 0; r <= len; r++) {
            if (r < len && board.charAt(l) == board.charAt(r)) continue;
            if (r-l>2) return recur(board.substring(0,l)+board.substring(r));
            else l = r;
        }
        return board;
    }

    public static void main(String[] args) {
        String board = "G";
        String hand = "GGGGG";
        zumaGame zumaGame = new zumaGame();
        int minStep = zumaGame.findMinStep(board, hand);
        System.out.println(minStep);
    }
}
