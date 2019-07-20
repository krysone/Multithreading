package JohnAndMarry;

public class Main {

    public static void main(String[] args) {

        Thread john = new Thread(new John());
        Thread marry = new Thread(new Marry());

        john.start();
        marry.start();

        // the below logic is not very sufficient to ask the threads if they're alive over and over again
/*        long howManyTimeAsked = 0;
        while (john.isAlive() || marry.isAlive()){
        howManyTimeAsked++;
        }
        System.out.println(howManyTimeAsked);
        1,363,939,471 times*/

        // way better is to use .join
        try {
            john.join();
            marry.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("\nAND after both John and Marry have finished their doings - \nTHE DAY ENDS");
    }
}
