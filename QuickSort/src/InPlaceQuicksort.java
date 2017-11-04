import java.util.Arrays;
import java.util.Random;

/** main class */
public class InPlaceQuicksort {

    // random number generator
    public static Random rng = new Random();

    // regular quicksort
    public static int[] quickSort(int[] toBeSorted) {
        InPlaceQuicksort.quickSortHelp(toBeSorted, 0, toBeSorted.length);
        return toBeSorted;
    }

    // regular quicksort
    public static void quickSortHelp(int[] toBeSorted, int start, int length) {
        if (length <= 1) {
            // do nothing
        }
        else if (length <= 3) {
            int min = toBeSorted[start];
            int median = -1;
            int max = -1;
            int minIndex = 0, medianIndex = 0, maxIndex = 0;
            for (int i = start; i < start + length; i++) {
                if (toBeSorted[i] < min) {
                    minIndex = i;
                    min = toBeSorted[minIndex];
                }
                if (toBeSorted[i] > max) {
                    maxIndex = i;
                    max = toBeSorted[maxIndex];
                }
            }
            for (int j = start; j < start + length; j++) {
                if (j != minIndex && j != maxIndex) {
                    medianIndex = j;
                }
            }
            median = toBeSorted[medianIndex];
            toBeSorted[start] = min;
            toBeSorted[start + 1] = median;
            toBeSorted[start + length - 1] = max;
        }
        else {
            int pivotIndex = start + InPlaceQuicksort.rng.nextInt(length);
            int pivot = toBeSorted[pivotIndex];
            toBeSorted[pivotIndex] = toBeSorted[start + length - 1];
            toBeSorted[start + length - 1] = pivot;
            int beginGreater = start;
            for (int i = start; i < start + length; i++) {
                if (toBeSorted[i] < pivot) {
                    int helper = toBeSorted[i];
                    toBeSorted[i] = toBeSorted[beginGreater];
                    toBeSorted[beginGreater] = helper;
                    beginGreater++;
                }
            }
            int helper = toBeSorted[beginGreater];
            toBeSorted[beginGreater] = toBeSorted[start + length - 1];
            toBeSorted[start + length - 1] = helper;
            System.out.println(Arrays.toString(toBeSorted));
            InPlaceQuicksort.quickSortHelp(toBeSorted, start, beginGreater - start);
            InPlaceQuicksort.quickSortHelp(toBeSorted, beginGreater, length - beginGreater);
        }
    }

    /** make a random-case scenario for insertion sort on array of length n */
    public static int[] makeRandomCase(int n) {
        int[] randomCase = new int[n];
        for (int i = 0; i < n; i++) {
            randomCase[i] = RegularQuicksort.rng.nextInt(n);
        }
        return randomCase;
    }

    /** print array elements */
    public static void printElements(int[] array) {
        System.out.print("[ ");
        for (int i = 0; i < array.length; i++) {
            if (i == array.length - 1) {
                System.out.print(array[i]);
            }
            else {
                System.out.print(array[i] + ", ");
            }
        }
        System.out.println(" ]");
    }

    /** main */
    public static void main(String[] args) {
//        int arrayLength = new Integer(args[0]);
        //int[] toBeSorted = RegularQuicksort.makeRandomCase(10);
        int [] toBeSorted = {100, 9, 10, 10, 6, 19, 5, 5, 8, 8, 1000, 15, 3, 0, 14, 13, 2, 12, 18, 16, 999};
        //System.out.println(Arrays.toString(toBeSorted));
        long prev = System.nanoTime();
        //RegularQuicksort.printElements(RegularQuicksort.quickSort(test));
        System.out.println(Arrays.toString(InPlaceQuicksort.quickSort(toBeSorted)));
        //RegularQuicksort.quickSort(test);
        System.out.println((System.nanoTime() - prev) + " nanoseconds");
        //RegularQuicksort.test2();
        //System.out.println(RegularQuicksort.rng.nextInt(3));
    }
}