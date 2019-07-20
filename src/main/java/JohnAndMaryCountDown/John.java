package JohnAndMaryCountDown;

import java.util.concurrent.CountDownLatch;

public class John implements Runnable {

    private CountDownLatch countDownLatch;

    public John(final CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {

        try {
            System.out.println("JOHN - Breakfast");
            Thread.sleep(5000);

            System.out.println("JOHN - Shower");
            Thread.sleep(3000);

            System.out.println("JOHN - Getting ready to go");
            Thread.sleep(1000);

            System.out.println("JOHN - Shopping");
            Thread.sleep(15000);

            System.out.println("JOHN - FunTime");
            Thread.sleep(5000);
            System.out.println("JOHN - finishes his day");

            countDownLatch.countDown();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
