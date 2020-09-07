package com.TWO;

public class Boy extends Thread {

    String name;
    int orange;

    public Boy(String name, int orange) {
        this.name = name;
        this.orange = orange;
    }



    public void eatOrange(Boy boy,int number) {
        while (number > 0) {

            if (boy.name == "A") {
                number -= boy.orange;
                System.out.println();
            }

            if (boy.name == "B") {
                number -= boy.orange;
            }

            if (boy.name == "C") {
                number -= boy.orange;
            }
        }
    }
}
