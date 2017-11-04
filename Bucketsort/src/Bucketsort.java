import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

// bucket sort
public class Bucketsort {

    // bucket sort
    public static double[] bucketSort(double[] toBeSorted) {
        ArrayList<ArrayList<Double>> buckets = new ArrayList<>();
        for (int i = 0; i < toBeSorted.length; i++) {
            ArrayList<Double> bucket = new ArrayList<>();
            buckets.add(bucket);
        }
        for (int i = 0; i < toBeSorted.length; i++) {
            int idx = (int) Math.floor(toBeSorted.length * toBeSorted[i]);
            buckets.get(idx).add(toBeSorted[i]);
        }
        for (ArrayList<Double> doubles : buckets) {
            double[] tmp_array = new double[doubles.size()];
            for (int i = 0; i < doubles.size(); i++) {
                tmp_array[i] = doubles.get(i);
            }
            Arrays.sort(tmp_array);
            for (int i = 0; i < tmp_array.length; i++) {
                doubles.set(i, tmp_array[i]);
            }
        }
        int k = 0;
        for (int i = 0; i < buckets.size(); i++) {
            for (int j = 0; j < buckets.get(i).size(); j++) {
                toBeSorted[k] = buckets.get(i).get(j);
                k++;
            }
        }
        return toBeSorted;
    }

    /** print array elements */
    public static void printElements(double[] array) {
        System.out.print("[ ");
        for (int i = 0; i < array.length; i++) {
            if (i == array.length - 1) {
                System.out.printf("%.2f", array[i]);
            }
            else {
                System.out.printf("%.2f, ", array[i]);
            }
        }
        System.out.println(" ]");
    }

    // main
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Please input one argument");
        }
        int num = Integer.parseInt(args[0]);
        Random rand = new Random();
        double[] toBeSorted = new double[num];
        for (int i = 0; i < num; i++) {
            toBeSorted[i] = rand.nextDouble();
        }
        System.out.println("Original Array:");
        Bucketsort.printElements(toBeSorted);
        long prev = System.nanoTime();
        Bucketsort.bucketSort(toBeSorted);
        System.out.println((System.nanoTime() - prev) + " nanoseconds");
        Bucketsort.printElements(toBeSorted);
    }
}