import org.junit.Assert;
import org.junit.Test;
/** tester class for Sort */
public class SortTest {
    @Test
    /** test getList */
    public final void testGetList() {
        int[] list1 = new int[5];
        list1[0] = 3;
        list1[1] = 4;
        list1[2] = 2;
        list1[3] = 1;
        list1[4] = 0;
        Sort sort1 = new Sort(list1);
        Assert.assertEquals(sort1.getList(), list1);
        int[] list2 = new int[5];
        list2[0] = 0;
        list2[1] = 1;
        list2[2] = 2;
        list2[3] = 3;
        list2[4] = 4;
        Sort sort2 = new Sort(list2);
        Assert.assertEquals(sort2.getList(), list2);
    }
    @Test
    /** test bubbleSort */
    public final void testBubbleSort() {
        int[] list1 = new int[5];
        list1[0] = 3;
        list1[1] = 4;
        list1[2] = 2;
        list1[3] = 1;
        list1[4] = 0;
        Sort sort1 = new Sort(list1);
        Assert.assertEquals(sort1.getList(), list1);
        int[] list2 = new int[5];
        list2[0] = 0;
        list2[1] = 1;
        list2[2] = 2;
        list2[3] = 3;
        list2[4] = 4;
        Sort sort2 = new Sort(list2);
        Assert.assertEquals(sort2.getList(), list2);
        sort1.bubbleSort();
        Assert.assertTrue(sort1.sameListElements(sort2));
    }
    @Test
    /** test insertionSort */
    public final void testInsertionSort() {
        int[] list1 = new int[5];
        list1[0] = 3;
        list1[1] = 4;
        list1[2] = 2;
        list1[3] = 1;
        list1[4] = 1;
        Sort sort1 = new Sort(list1);
        Assert.assertEquals(sort1.getList(), list1);
        int[] list2 = new int[5];
        list2[0] = 1;
        list2[1] = 1;
        list2[2] = 2;
        list2[3] = 3;
        list2[4] = 4;
        Sort sort2 = new Sort(list2);
        Assert.assertEquals(sort2.getList(), list2);
        sort1.insertionSort();
        Assert.assertTrue(sort1.sameListElements(sort2));
        Assert.assertTrue(sort1.insertionSort().sameListElements(sort1.bubbleSort()));
    }
    @Test
    /** test linear123Sort */
    public final void testLinear123Sort() {
        Sort sort1 = Sort.makeRandom(20);
        int[] list2 = new int[20];
        list2[0] = 3;
        Sort sort2 = new Sort(list2);
        Assert.assertEquals(sort2.getList(), list2);
        sort1.linear123Sort();
        Assert.assertTrue(sort1.sameListElements(sort2));
    }
}