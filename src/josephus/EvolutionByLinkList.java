package josephus;

import java.util.Objects;

/**
 * @Date 2018-08-19
 * @Author lihongxiang
 */
public class EvolutionByLinkList {

    public static void main(String[] args) {
        CrewList crewList = new CrewList(30, 9, 15);
        crewList.count();
    }


    static class Crew {
        private int no;
        private Crew nextCrew;

        public Crew(int no) {
            this.no = no;
        }
    }

    static class CrewList {
        private int crewSum;

        private int countNum;

        private int eliminateSum;

        private Crew tempCrew;

        private Crew firstCrew;

        public CrewList(int crewSum, int countNum, int eliminateSum) {
            this.crewSum = crewSum;
            this.countNum = countNum;
            this.eliminateSum = eliminateSum;
            createList();
        }

        private void createList() {
            for (int i = 1; i <= crewSum; i++) {
                if (i == 1) {
                    Crew crew = new Crew(i);
                    this.firstCrew = crew;
                    this.tempCrew = crew;
                } else if (i == crewSum) {
                    Crew crew = new Crew(i);
                    this.tempCrew.nextCrew = crew;
                    this.tempCrew = crew;
                    this.tempCrew.nextCrew = firstCrew;
                } else {
                    Crew crew = new Crew(i);
                    this.tempCrew.nextCrew = crew;
                    this.tempCrew = crew;
                }
            }
        }

        void count() {
            while (this.eliminateSum > 0) {
                for (int i = 1; i < countNum; i++) {
                    tempCrew = tempCrew.nextCrew;
                }
                Crew removeCrew = this.tempCrew.nextCrew;
                System.out.println(removeCrew.no + " eliminate");
                this.tempCrew.nextCrew = removeCrew.nextCrew;
                if (removeCrew.no == firstCrew.no) {
                    firstCrew = removeCrew.nextCrew;
                }
                tempCrew = tempCrew.nextCrew;
                eliminateSum --;
            }
            Crew startCrew = this.firstCrew;
            boolean showFlag = true;
            while (showFlag) {
                System.out.println(startCrew.no + " is survive");
                startCrew = startCrew.nextCrew;
                if (Objects.equals(startCrew, this.firstCrew)) {
                    showFlag = false;
                }
            }
        }
    }


}
