package Test.TWO;

public class RunRace {

    static int distanceA = 100;
    static int distanceB = 100;
    static int distanceC = 100;
    static int i = 0, j = 0, k = 0;

    public static void main(String[] args) {

        //A
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("A准备好了");
                while (distanceA > 0) {
                    distanceA -= 5;
                    i++;
                    if(distanceB<=0 || distanceC<=0){
                        break;
                    }
                }
                if(distanceB<=0){
                    System.out.println("A我跑了"+j*5+"米");
                }else if(distanceC<=0) {
                    System.out.println("A我跑了"+k*5+"米");
                }else{
                    System.out.println("A我跑完了");
                }
            }
        }).start();

        //B
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("B准备好了");
                while (distanceB > 0) {
                    distanceB -=4;
                    j++;
                    if(distanceA<=0 || distanceC<=0){
                        break;
                    }
                }
                if(distanceA<=0){
                    System.out.println("B我跑了"+i*4+"米");
                }else if(distanceC<=0) {
                    System.out.println("B我跑了"+k*4+"米");
                }else{
                    System.out.println("B我跑完了");
                }
            }
        }).start();

        //C
        new Thread(() -> { //lambda
            System.out.println("C准备好了");
            while (distanceC > 0) {
                distanceC -=3;
                k++;
                if(distanceA<=0 || distanceB<=0){
                    break;
                }
            }
            if(distanceB<=0){
                System.out.println("C我跑了"+j*3+"米");
            }else if(distanceA<=0) {
                System.out.println("C我跑了"+i*3+"米");
            }else{
                System.out.println("C我跑完了"+j);
            }
        }).start();
    }
}
