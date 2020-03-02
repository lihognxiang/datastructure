package josephus;

/**
 * @Date 2018-08-19
 * @Author lihongxiang
 * 15个教徒和非教徒问题
 */
public class EvolutionByArray {

    public static void main(String[] args) {
        int eliminateCount = 15;
        int peopleCount = 30;
        int countNum = 9;
        int count = 1;
        int [] people = new int[30];
        for (int i = 0; i < peopleCount; i++) {
            people[i] = 1;
        }
        while (eliminateCount != 0) {
            for (int i = 0; i < people.length; i++) {
                if (people[i] != 0) {
                    if (count % countNum == 0) {
                        people[i] = 0;
                        eliminateCount--;
                        System.out.println((i + 1) + " is eliminate");
                    }
                    count++;
                }
            }
        }
        for (int i = 0; i < people.length; i++) {
            if (people[i] != 0) {
                System.out.println("win conclude: " + (i +1 ));
            }
        }
    }
}
