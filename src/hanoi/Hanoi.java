package hanoi;

/**
 * @Date 2018-08-20
 * @Author lihongxiang
 *
 */
public class Hanoi {

    public static void main(String[] args) {
        hanoi(8, "A", "B", "C");
    }

    private static void hanoi(int sum, String from, String temp, String to) {
        if (sum <= 0) {
            System.out.println("not right");
        } else if (sum == 1) {
            System.out.println("move" + sum + ", " + from + "->" + to);
        } else {
            hanoi(sum - 1, from, to, temp);
            System.out.println("move" + sum + ", " + from + "->" + to);
            hanoi(sum - 1, temp, from, to);
        }
    }
}
