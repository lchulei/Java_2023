package lab0;

public class Variant8 {

    /**
     *
     * @param a is integer number
     * @param b is integer number
     * @return arithmetic average
     */
    public int inputOutputTask(int a, int b) {
        return (a + b) / 2;
    }

    /**
     *
     * @param num is two-digit number
     * @return number obtained by permuting the digits of the original number
     */

    public int integerNumbersTask(int num) {
        assert num > 9 && num < 100: "Num should be greater than 9 and less than 100";
        return num % 10 * 10 + num / 10;
    }

    /**
     *
     * @param a is integer number
     * @param b is integer number
     * @return true, if each of the numbers A and B is odd
     */
    public boolean booleanTask(int a, int b) {
        return a % 2 != 0 && b % 2 != 0;
    }


    /**
     *
     * @param num1 is integer number
     * @param num2 is integer number
     * @return Output first the larger, and then the smaller of them.
     */
    public int[] ifTask(int num1, int num2) {
        int[] res = new int[2];
        res[0] = Math.max(num1, num2);
        res[1] = Math.min(num1, num2);
        return res;
    }


    /**
     *
     * @param day is integer number
     * @param month is integer number
     * @return date preceding the specified one
     */
    public int[] switchTask(int day, int month) {
        assert  month > 0 && month < 13 : "Month should be less than 13 and greater than 0";
        assert day > 0 : "Day should be greater than 0";
        int daysCount = 0;
        switch (month) {
            case 2:
                daysCount = 28;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                daysCount = 30;
                break;
            default:
                daysCount = 31;
        }

        assert day < daysCount + 1 : "Day should be less than " + daysCount + 1 + " for month " + month;

        if (day > 1) {
            return new int[]{day - 1, month};
        } else {
            if (month > 1) {
                switch (month - 1) {
                    case 2:
                        daysCount = 28;
                        break;
                    case 4:
                    case 6:
                    case 9:
                    case 11:
                        daysCount = 30;
                        break;
                    default:
                        daysCount = 31;
                }
                return new int[]{daysCount, month - 1};
            } else {
                return new int[]{31, 12};
            }
        }
    }


    /**
     *
     * @param a is integer number
     * @param b is integer number
     * @return sum of number between a and b
     */
    public double forTask(int a, int b) {
        assert a < b: "A should be less than b";
        int res = a;
        for (int i = a + 1; i <= b; i++) {
            res += i;
        }
        return res;
    }


    /**
     *
     * @param n is integer number
     * @return the largest integer K whose square does not exceed N: K^2 <= N
     */
    public int whileTask(int n) {
        assert (n > 0): "Argument should be more than zero";
        int k = 1;
        while (k * k < n) k++;
        return k - 1;
    }


    /**
     *
     * @param array is integer number
     * @param N is integer number
     * @return the largest integer K whose square does not exceed N: K^2 <= N
     */
    public int[] minMaxTask(int[] array, int N) {
        int minElement = array[0];
        int firstMinIndex = 0;

        for (int i = 1; i < N; i++) {
            if (array[i] < minElement) {
                minElement = array[i];
                firstMinIndex = i;
            }
        }

        int lastMinIndex = 0;

        for (int i = N - 1; i >= 0; i--) {
            if (array[i] == minElement) {
                lastMinIndex = i;
                break;
            }
        }
        return new int[]{ firstMinIndex, lastMinIndex };
    }


    /**
     *
     * @param array is integer array with size n
     * @param n is integer number, array size
     * @return all the odd numbers contained in this array in ascending order of their indices, as well as their quantity K.
     */
    public int[][] arrayTask(int[] array, int n) {
        int[] temp = new int[n];
        int k = 0;
        for (int i = 0; i < n; i++) {
            if (array[i] % 2 != 0) {
                temp[k] = array[i];
                k++;
            }
        }
        int[][] result = new int[2][k];
        result[1][0] = k;
        for (int i = 0; i < k; i++) {
            result[0][i] = temp[i];
        }
        return result;
    }


    /**
     *
     * @param array - two dimension array with size M x N
     * @param k - integer number 1 < k < n
     * @return Output the elements of the Kth column of this matrix.
     */
    public int[]  twoDimensionArrayTask(int[][] array, int m, int n, int k) {
        assert k < n && 1 < k : "K should be less than M and greater than 1";
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = array[i][k - 1];
        }
        return res;
    }

    public static void main(String... strings) {
        System.out.println("Start of zero lab");
        System.out.println("Done!!!");
    }
}
