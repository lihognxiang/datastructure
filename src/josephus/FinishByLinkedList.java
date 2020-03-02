package josephus;

/**
 * @Date 2018-08-19
 * @Author lihongxiang
 */
public class FinishByLinkedList {


    public static void main(String[] args) {
        long starttime=System.currentTimeMillis();
        CircleLinkList game=new CircleLinkList(10000, 99, 533);
        long endtime=System.currentTimeMillis();
        game.play();
        long time2=System.currentTimeMillis();
        System.out.println("创建链表用了"+(endtime-starttime)/1000.0+"秒");
        System.out.println("玩游戏共用了"+(time2-starttime)/1000.0+"秒");
    }

    static class Child {
        private int no;
        private Child nextChild;

        public Child(int no) {
            this.no = no;
        }
    }

    static class CircleLinkList {
        private int playBoys;

        private int startIndex;

        private int countNum;

        private Child firstChild;

        private Child temp;

        public CircleLinkList(int playBoys, int startIndex, int countNum) {
            this.playBoys = playBoys;
            this.startIndex = startIndex;
            this.countNum = countNum;
            createList();
        }

        private void createList() {
            for (int i = 1; i <= playBoys; i++) {
                if (i == 1) {
                    Child child = new Child(i);
                    this.firstChild = child;
                    this.temp = child;
                } else if (i == playBoys) {
                    Child child = new Child(i);
                    this.temp.nextChild = child;
                    this.temp = child;
                    this.temp.nextChild = firstChild;
                } else {
                    Child child = new Child(i);
                    this.temp.nextChild = child;
                    this.temp = child;
                }
            }
        }


        private void play() {
            temp = firstChild;
            for (int i = 1; i < startIndex; i++) {
                temp = temp.nextChild;
            }
            System.out.println("游戏开始,从第" + temp.no + "个小孩开始数,数到第" + this.countNum + "个小孩退出游戏");
            while (this.playBoys > 1) {
                //找到要退出游戏的前一个小孩
                for (int i = 1; i < countNum - 1; i++) {
                    temp = temp.nextChild;
                }
                //当前temp是要退出的前一个小孩
                Child leaveChild = temp.nextChild;
                System.out.println("当前退出的小孩编号为:" + leaveChild.no);
                temp.nextChild = leaveChild.nextChild;
                if (leaveChild.no == firstChild.no) {
                    //如果要退出的小孩是第一个小孩,则将第一个小孩重置为退出小孩的下一个小孩
                    this.firstChild = leaveChild.nextChild;
                }
                temp = temp.nextChild;
                this.playBoys--;//玩游戏人数少一个
            }
            System.out.println("最后剩下的小孩是:" + temp.no);
        }
    }
}
