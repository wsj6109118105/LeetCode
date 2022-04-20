package reflect;

/**
 * user:lufei
 * DATE:2022/4/9
 **/
public class cat {
    String name;
    String color;

    public cat() {
    }

    public cat(String name, String color) {
        this.name = name;
        this.color = color;
    }

    public String shout(){
        return "miao";
    }

    public void eat() {
        System.out.println("eat");
    }
}
