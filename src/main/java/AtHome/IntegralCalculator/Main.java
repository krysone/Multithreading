package AtHome.IntegralCalculator;

public class Main {
    public static void main(String[] args) throws InterruptedException {

         Long startTime = System.currentTimeMillis();
        System.out.println(IntegratorRect.integrate(0, 15, 100000000));
         Long endTime = System.currentTimeMillis();
         Long executionTime = endTime - startTime;
        System.out.println("time: " + executionTime + " [ms]");

        startTime = System.currentTimeMillis();
        System.out.println(IntegratorRect.IntegrateRectagMultithreadedOptimized(0, 15, 100000000));
        endTime = System.currentTimeMillis();
        executionTime = endTime - startTime;
        System.out.println("time: " + executionTime + " [ms]");

        //hereby, by multithreading, we were able to speed up calculations by 3 times
        //however we got some precision downfalls
    }
}
