package gameTwo;

import java.sql.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/** 5941  并查集
 * user:lufei
 * DATE:2021/11/28
 **/
public class questionFour {
    public static List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        // TODO 5941
        List<Integer> list = new ArrayList<>();
        Arrays.sort(meetings,(int[] a,int[] b)-> a[2]-b[2]);

        return list;
    }

    public static void main(String[] args) {
        int n = 6;
        int firstPerson = 1;
        int[][] meetings= {
            {0,2,1},
            {1,3,1},
            {4,5,1}
        };
        findAllPeople(n,meetings,firstPerson);
    }
}
