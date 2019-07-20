package JohnAndMaryCountDown;


import java.util.concurrent.CountDownLatch;

public class Main {

    public static void main(String[] args) {

        CountDownLatch countDownLatch = new CountDownLatch(2);

        Thread john = new Thread(new John(countDownLatch));
        Thread marry = new Thread(new Marry(countDownLatch));

        john.start();
        marry.start();

   /*     try {
            john.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            marry.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

//        while (john.isAlive() || marry.isAlive()){
//
//        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("\nAND after both John and Marry have finished their doings - \nTHE DAY ENDS");
//    }
    }
}
