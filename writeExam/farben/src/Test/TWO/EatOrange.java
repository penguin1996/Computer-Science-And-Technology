package Test.TWO;

public class EatOrange {
    static int number = 9;
    public static void main(String[] args) {
        final Object boy = new Object();
        while (number > 0) {
            //小孩A
            new Thread(new Runnable() {
                @Override
                public void run() {
                    synchronized (boy) {
                        if (number >= 2) {
                            try {
                                number -= 2;
                                System.out.println("小孩A拿2个橘子还剩了" + number + "个橘子");
                                System.out.println("小孩A开始吃橘子");
                                boy.notifyAll();
                                boy.wait(2000);
                                System.out.println("小孩A吃完2个橘子");
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }else {
                            Thread.interrupted();
                            System.out.println("A不拿了");
                            return;
                        }
                    }
                }
            }).start();

            //小孩B
            new Thread(new Runnable() {
                @Override
                public void run() {
                    synchronized (boy) {
                        if (number >= 3) {
                            try {
                                number -= 3;
                                System.out.println("小孩B拿3个橘子还剩了" + number + "个橘子");
                                System.out.println("小孩B开始吃橘子");
                                boy.notifyAll();
                                boy.wait(3000);
                                System.out.println("小孩B吃完3个橘子");
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }else {
                            System.out.println("B不拿了");
                            return;
                        }
                    }
                }
            }).start();

            //小孩C
            new Thread(() -> { //lambda
                synchronized (boy) {
                    if (number >= 1) {
                        try {
                            number -= 1;
                            System.out.println("小孩C拿1个橘子还剩了" + number + "个橘子");
                            System.out.println("小孩C开始吃橘子");
                            boy.notifyAll();
                            boy.wait(1000);
                            System.out.println("小孩C吃完1个橘子");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }else {
                        System.out.println("C不拿了");
                        return;
                    }
                }
            }).start();
        }
    }
}
