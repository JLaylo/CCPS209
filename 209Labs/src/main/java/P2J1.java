public class P2J1
{
    public static long fallingPower(int n, int k) {
        long total = n;
        int base = n;

        if(k == 0) { return 1; }

        for(int i=0; i<k-1; i++) {
            base -= 1;
            total *= base;
        }

        return total;
    }

    public static int[] everyOther(int[] arr)
    {
        if (arr.length <= 1) { return arr; }

        int arr_len = 0;

        if (arr.length % 2 == 1) {
            arr_len = arr.length / 2 + 1;
        }
        else {
            arr_len = arr.length / 2;
        }

        int[] new_arr = new int[arr_len];

        for(int i=0; i < arr.length; i+=2) { new_arr[i/2] = arr[i]; }

        return new_arr;
    }

    public static int[][] createZigZag(int rows, int cols, int start)
    {
        int[][] matrix = new int[rows][cols];
        int counter = start;

        for(int i = 0; i < rows; i++) {
            if (i % 2 != 0) {
                for (int j = cols-1; j >= 0; j--) {
                    matrix[i][j] = counter;
                    counter++;
                }
            }
            else {
                for (int j = 0; j < cols; j++) {
                    matrix[i][j] = counter;
                    counter++;
                }
            }
        }

        return matrix;
    }

    public static int countInversions(int[] arr)
    {
        if(arr.length <= 1) { return 0; }
        int count = 0;

        for(int i=0; i < arr.length; i++) {
            for(int j = i+1; j < arr.length; j++) {
                if(arr[i] > arr[j]) {
                    count++;
                }
            }
        }

        return count;
    }
}
