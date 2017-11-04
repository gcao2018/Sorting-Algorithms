import java.util.Arrays;
import java.util.Random;

/** main class */
public class LazyQuicksort {

    // random number generator
    public static Random rng = new Random();

    // regular quicksort
    public static int[] quickSort(int[] toBeSorted) {
        LazyQuicksort.quickSortHelp(toBeSorted, 0, toBeSorted.length);
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
            System.out.println(start);
            System.out.println(length);
            int pivotIndex = start;
            int pivot = toBeSorted[pivotIndex];
            System.out.println("pivot: " + pivot);
            int[] left = new int[length];
            int[] right = new int[length];
            int leftCount = 0;
            int rightCount = 0;
            for (int i = start; i < start + length; i++) {
                if (i != pivotIndex) {
                    if (toBeSorted[i] <= pivot) {
                        left[leftCount] = toBeSorted[i];
                        leftCount++;
                    }
                    if (toBeSorted[i] > pivot) {
                        right[rightCount] = toBeSorted[i];
                        rightCount++;
                    }
                }
            }
            for (int j = 0; j < leftCount; j++) {
                toBeSorted[start + j] = left[j];
            }
            toBeSorted[start + leftCount] = pivot;
            for (int k = 0; k < rightCount; k++) {
                toBeSorted[start + leftCount + k + 1] = right[k];
            }
            //System.out.println("leftCount: " + leftCount);
            //System.out.println("rightCount: " + rightCount);
            System.out.println(Arrays.toString(toBeSorted));
            System.out.println("left");
            LazyQuicksort.quickSortHelp(toBeSorted, start, leftCount);
            System.out.println("right");
            LazyQuicksort.quickSortHelp(toBeSorted, start + leftCount + 1, rightCount);
        }
    }

    /** make a random-case scenario for insertion sort on array of length n */
    public static int[] makeRandomCase(int n) {
        int[] randomCase = new int[n];
        for (int i = 0; i < n; i++) {
            randomCase[i] = LazyQuicksort.rng.nextInt(n);
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
        //int arrayLength = new Integer(args[0]);
        //int[] toBeSorted = LazyQuicksort.makeRandomCase(10);
        int [] toBeSorted = {100, 9, 10, 10, 6, 19, 5, 5, 0, 8, 1000, 15, 3, 7, 14, 13, 2, 12, 18, 16, 99};
        //System.out.println(Arrays.toString(toBeSorted));
        long prev = System.nanoTime();
        //LazyQuicksort.printElements(LazyQuicksort.quickSort(test));
        System.out.println(Arrays.toString(LazyQuicksort.quickSort(toBeSorted)));
        //LazyQuicksort.quickSort(test);
        System.out.println((System.nanoTime() - prev) + " nanoseconds");
        //LazyQuicksort.test2();
        //System.out.println(LazyQuicksort.rng.nextInt(3));
    }
}