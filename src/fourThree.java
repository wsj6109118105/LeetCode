import java.util.ArrayList;
import java.util.List;

/**
 * user:lufei
 * DATE:2022/4/3
 **/
public class fourThree {

    public static List<List<Integer>> findWinners(int[][] matches) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> win = new ArrayList<>();
        List<Integer> los1 = new ArrayList<>();
        List<Integer> loser = new ArrayList<>();
        for(int[] i : matches) {
            if(!loser.contains(i[0])&&!los1.contains(i[0])&&!win.contains(i[0])) {
                win.add(i[0]);
            }
            if(los1.contains(i[1])&&!loser.contains(i[1])) {
                loser.add(i[1]);
                los1.remove(new Integer(i[1]));
            }
            if(!loser.contains(i[1])&&!los1.contains(i[1])) {
                los1.add(i[1]);
                if (win.contains(i[1]))
                    win.remove(new Integer(i[1]));
            }
        }
        win.sort((a,b)->a-b);
        los1.sort((a,b)->a-b);
        list.add(win);
        list.add(los1);
        return list;
    }

    public static void main(String[] args) {
        int[][] arr = {{1,3},{2,3},{3,6},{5,6},{5,7},{4,5},{4,8},{4,9},{10,4},{10,9}};
        findWinners(arr);
    }
}
