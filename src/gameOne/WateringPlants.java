package gameOne;

/** 给植物浇水    折返问题，只需要计算出回去再回来的距离即可
 * user:lufei
 * DATE:2021/11/21
 **/
public class WateringPlants {
    public static int wateringPlants(int[] plants, int capacity) {
        //List<Integer> list = new ArrayList<>();
        int cap = capacity;
        int step = 0;
        for(int i = 0;i<plants.length;i++) {
            if(cap>=plants[i]) {
                cap -= plants[i];
                step++;
            }else {
                cap = capacity-plants[i];
                step += i;
                step += i+1;
            }
        }
        return step;
    }

    public static void main(String[] args) {
        int[] plants = {1,1,1,4,2,3};
        System.out.println(wateringPlants(plants, 4));
    }
}
