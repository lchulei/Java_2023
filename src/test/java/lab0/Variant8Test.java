package lab0;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import lab0.Variant8;

public class Variant8Test {

    public static double EPS = 0.0000001;

    @Test
    public void MassTest(){
        assertEquals(new int[]{1, 2, 3}, new int[]{1, 2, 3});
    }

    @Test(enabled = false)
    public void loginOld() {
        assertEquals(new Variant8().booleanTask(3, 4), false);
    }

    @Test(dataProvider = "inputProvider")
    public void inputTest(int p1, int p2, long p3) {
        assertEquals(new Variant8().inputOutputTask(p1, p2), p3);
    }

    @DataProvider
    public Object[][] inputProvider() {
        return new Object[][] { { 2, 4, 3 }, { 6, 5, 5 }, { 10, 22, 16 } };
    }

    ////////////////////////////////////////////////

    @Test(dataProvider = "integerProvider")
    public void inputTest(int p1, int p3) {
        assertEquals(new Variant8().integerNumbersTask(p1), p3);
    }

    @DataProvider
    public Object[][] integerProvider() {
        return new Object[][] { { 54, 45 }, { 12, 21 }, { 76, 67 } };
    }

    @Test(expectedExceptions = AssertionError.class)
    public void lessIntegerTest() {
        new Variant8().integerNumbersTask(2);
    }

    @Test(expectedExceptions = AssertionError.class)
    public void greaterIntegerTest() {
        new Variant8().integerNumbersTask(102);
    }

    ////////////////////////////////////////////////

    @Test(dataProvider = "ifProvider")
    public void ifTest(int p1, int p2, int p3, int p4) {
        assertEquals(new Variant8().ifTask(p1, p2), new int[]{p3, p4});
    }

    @DataProvider
    public Object[][] ifProvider() {
        return new Object[][] { { 2, 3, 3, 2 }, { 8, 5, 8, 5 }, { 3, -3, 3, -3 } };
    }

    //////////////////////////////////////////////////

    @Test(dataProvider = "booleanProvider")
    public void booleanTest(int p1, int p2, boolean p3) {
        assertEquals(new Variant8().booleanTask(p1, p2), p3);
    }

    @DataProvider
    public Object[][] booleanProvider() {
        return new Object[][] { { 5, 3, true }, { 0, 3, false }, { 2, 1, false } };
    }

    //////////////////////////////////////////////////

    @Test(dataProvider = "switchProvider")
    public void switchTest(int p1, int p2, int p3, int p4) {
        assertEquals(new Variant8().switchTask(p1, p2), new int[]{p3, p4});
    }

    @DataProvider
    public Object[][] switchProvider() {
        return new Object[][] { { 3, 10, 2, 10 }, { 1, 5, 30, 4 } };
    }

    @Test(expectedExceptions = AssertionError.class)
    public void switchNegativeTest() {
        new Variant8().switchTask(0, 0);
    }

    ///////////////////////////////////////////////////

    @Test(dataProvider = "forProvider")
    public void forTest(int a, int b, int r) {
        assertEquals(new Variant8().forTask(a, b), r);
    }

    @DataProvider
    public Object[][] forProvider() {
        return new Object[][] { { 2, 5, 14 }, { 4, 7, 22 }, { 7, 12, 57 } };
    }

    ///////////////////////////////////////////////////

    @Test(dataProvider = "minMaxProvider")
    public void minMaxTest(int[] input, int[] output) {
        assertEquals(new Variant8().minMaxTask(input, input.length), output);
    }

    @DataProvider
    public Object[][] minMaxProvider() {
        int[] input = {2, 3, 6, 9, 10, 2};
        int[] output = {0, 5};

        int[] input1 = {34, 98, 9, 2, 1, 4, 2, 1, 6, 1};
        int[] output1 = {4, 9};

        int[] input2 = {-98, 8, 1, 5, 3};
        int[] output2 = {0, 0};
        return new Object[][] { { input, output }, { input1, output1 }, { input2, output2 } };
    }

    //////////////////////////////////////////

    @Test(dataProvider = "whileProvider")
    public void whileTest(int a, int b) {
        assertEquals(new Variant8().whileTask(a), b);
    }

    @DataProvider
    public Object[][] whileProvider() {
        return new Object[][] { { 65, 8 }, { 10, 3 }, { 9, 2 }, { 4, 1 } };
    }

    @Test(expectedExceptions = AssertionError.class, dataProvider = "negativeWhileProvider")
    public void negativeWhileTest(int n) {
        new Variant8().whileTask(n);
    }

    @DataProvider
    public Object[][] negativeWhileProvider() {
        return new Object[][] { { 0 }, { -2 }, { -1000 } };
    }

    //////////////////////////////////////////
    @Test(dataProvider = "arrayProvider")
    public void arrayTest(int[] array, int[] expected, int k) {
        int[][] actual = new Variant8().arrayTask(array, array.length);
        assertEquals(actual[0], expected);
        assertEquals(actual[1][0], k);
    }

    @DataProvider
    public Object[][] arrayProvider() {
        return new Object[][] { { new int[] { 10, 2, 3, 5, 4 }, new int[] { 3, 5 }, 2 },
                                { new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 }, new int[] { 1, 3, 5, 7, 9 } , 5 },
                                { new int[] { 4, 3, 5, -4, 9, 2 }, new int[] { 3, 5, 9} , 3 } };
    }

    //////////////////////////////////////////

    @Test(dataProvider = "matrixProvider")
    public void twoDimensionArrayTest(int[][] input, int m, int n, int k, int[] output) {
        assertEquals(new Variant8().twoDimensionArrayTask(input, m, n, k), output);
    }

    @DataProvider
    public Object[][] matrixProvider() {
        int[][] input = {{2, 3, 6, 9, -9},
                {34, 98, -9, 2, 1},
                {-4, 2, 1, 6, 1},
                {-98, 8, 1, 5, 3}};
        int m = input[0].length;
        int n = input.length;
        int k = 2;
        int[] output = {3, 98, 2, 8};

        int[][] input1 = {{55, 3, 5, 77, -20},
                {6, 5, 4, 3, 2},
                {22, 15, -8, 9, 11},
                {-84, 2, 32, 46, -2},
                {34, 98, -9, 2, 1},
                {-98, 8, 1, 5, 3}};
        int m1 = input1[0].length;
        int n1 = input1.length;
        int k1 = 3;
        int[] output1 = {5, 4, -8, 32, -9, 1};

        return new Object[][] { {input, m, n, k, output}, { input1, m1, n1, k1, output1 } };

    }

}