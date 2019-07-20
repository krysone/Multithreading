package JohnAndMarry;

public class Marry implements Runnable {

    @Override
    public void run() {

        try {
            System.out.println("MARRY - jogging");
                Thread.sleep(6000);

            System.out.println("MARRY - shower");
                Thread.sleep(2000);

            System.out.println("MARRY - breakfast");
                Thread.sleep(1000);

            System.out.println("MARRY - getting ready");
                Thread.sleep(1000);

            System.out.println("MARRY - outing with friends");
                Thread.sleep(25000);
            System.out.println("MARRY - is back home and finishes her day");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
