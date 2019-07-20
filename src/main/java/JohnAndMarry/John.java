package JohnAndMarry;

public class John implements Runnable {

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

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
