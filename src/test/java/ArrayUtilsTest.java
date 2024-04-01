import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ArrayUtilsTest {

    @Test
    public void testFindLastNull() {
        // Do not execute fault
        assertThrows(NullPointerException.class, () -> {ArrayUtils.findLast(null, 3);});
    }


    @Test
    public void testFindLastEmpty() {
        // For any input where y appears in the second or later position, there is no error. Also,
        // if x is empty, there is no error.
        assertEquals(-1, ArrayUtils.findLast(new int[]{}, 3));
    }

    @Test
    public void testFindLastNonExistent() {
        assertEquals(-1, ArrayUtils.findLast(new int[]{1, 2}, 3));
    }

    @Test
    public void testFindLastExistsFirstElement() {
        assertEquals(0, ArrayUtils.findLast(new int[]{2, 3, 5}, 2));
    }

    @Test
    public void testOddOrPosNull() {
        // Do not execute fault
        assertThrows(NullPointerException.class, () -> {ArrayUtils.oddOrPos(null);});
    }


    @Test
    public void testOddOrPosAllPositives() {
        // Any nonempty x with only non-negative elements works, because the first part of the
        // compound if-test is not necessary unless the value is negative.
        assertEquals(3, ArrayUtils.oddOrPos(new int[]{1, 2, 3}));
    }

    @Test
    public void testOddOrPositiveBothPositivesAndNegatives() {
        assertEquals(3, ArrayUtils.oddOrPos(new int[]{-3, -2, 0, 1, 4}));
    }

    @Test
    public void testCountOf_TargetExists() {
        int[] x = {1, 2, 3, 2, 4, 2};
        int target = 2;
        int expected = 3;
        int result = ArrayUtils.countOf(x, target);
        assertEquals(expected, result);
    }

    @Test
    public void testCountOf_TargetDoesNotExist() {
        int[] x = {1, 2, 3, 4, 5};
        int target = 6;
        int expected = 0;
        int result = ArrayUtils.countOf(x, target);
        assertEquals(expected, result);
    }

    @Test
    public void testCountOf_EmptyArray() {
        int[] x = {};
        int target = 1;
        int expected = 0;
        int result = ArrayUtils.countOf(x, target);
        assertEquals(expected, result);
    }

    @Test
    public void testCountOf_SingleElementArray_TargetMatches() {
        int[] x = {5};
        int target = 5;
        int expected = 1;
        int result = ArrayUtils.countOf(x, target);
        assertEquals(expected, result);
    }

    @Test
    public void testCountOf_SingleElementArray_TargetDoesNotMatch() {
        int[] x = {5};
        int target = 3;
        int expected = 0;
        int result = ArrayUtils.countOf(x, target);
        assertEquals(expected, result);
    }
}