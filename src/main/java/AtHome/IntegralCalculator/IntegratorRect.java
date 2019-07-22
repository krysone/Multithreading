package AtHome.IntegralCalculator;


import com.google.common.util.concurrent.AtomicDouble;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class IntegratorRect {

    private static double function(double x) {
        return (3 * Math.sin(x)) - (0.2 * Math.pow(x, 3)) + (3 * Math.pow(x, 2));
    }

    public static double IntegrateRectagMultithreadedOptimized(final double startX, final double endX, final int step) {
        ExecutorService threadPool = Executors.newFixedThreadPool(8);

        final AtomicDouble integralsSum = new AtomicDouble(0.0);

        final int howManyBigRanges = 150;
        final double bigRangeLength = (endX - startX) / howManyBigRanges;

        //we divide the whole range, the user ask us to calculate Integral for, on smaller ranges
        //in this case we have 150 of them
        //each of those smaller ranges will be passed to the pool of threads threadpool
        for (int i = 0; i < howManyBigRanges; i++) {
            final double startBigRangeX = startX + i * bigRangeLength;
            final double endBigRangeX = startBigRangeX + bigRangeLength;

            threadPool.submit(new Runnable() {

                //and each thread will calculate Integral for the given range according to the user instructed step
                @Override
                public void run() {
                    double integralBigRange = integrate(startBigRangeX, endBigRangeX, step / howManyBigRanges);

                    integralsSum.addAndGet(integralBigRange);
                }
            });
        }
        try {
            threadPool.shutdown();
            threadPool.awaitTermination(1, TimeUnit.HOURS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return integralsSum.get();
    }

    public static double integrate(double startX, double endX, int step) {

        double deltaX = (endX - startX) / step; // 0.1
        double integral = 0.0;

        for (double x = startX; x < endX; x += deltaX) {
            double y = function(x + (0.5 * deltaX));
            double rectangleArea = deltaX * y;
            integral += rectangleArea;
        }
        return integral;
    }
}
