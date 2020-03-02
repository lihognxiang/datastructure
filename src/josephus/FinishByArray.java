package josephus;

/**
 * @Date 2018-08-19
 * @Author lihongxiang
 */
public class FinishByArray {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int peopleCount = 1000;
        int startNum = 56;
        int countNum = 78;
        int count = 1;
        int[] people = new int[peopleCount];
        for (int i = 0; i < people.length; i++) {
            people[i] = 1;
        }
        boolean gameFlag = true;
        while (gameFlag) {
            for (int i = 0; i < people.length; i++) {
                if (i < startNum - 1) {
                    continue;
                }
                startNum = 0;
                if (people[i] != 0) {
                    if (count % countNum == 0) {
                        if (peopleCount == 1) {
                            System.out.println("win is" + i);
                            gameFlag = false;
                            break;
                        }
                        people[i] = 0;
                        count = 0;
                        peopleCount --;
                        System.out.println(i + "quit");
                    }
                    count ++;
                }
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("time:" + (end - start));
    }
}
