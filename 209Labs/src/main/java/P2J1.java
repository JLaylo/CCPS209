public class P2J1 {
    public static long fallingPower(int n, int k) {
        long total = n;
        int base = n;

        if(k == 0){
            return 1;
        }

        for(int i=0; i<k-1; i++){
            base -= 1;
            total *= base;
        }

        return total;
    }

    public static int[] everyOther(int[] arr) {
        if (arr.length <= 1) {
            return arr;
        }

        int[] new_arr = new int[arr.length / 2];

        for(int i=0; i < arr.length-1; i+=2) {
            new_arr[i/2] = arr[i];
        }

        return new_arr;
    }

    public static int[][] createZigZag(int rows, int cols, int start) {
        throw new UnsupportedOperationException();
    }

    public static int countInversions(int[] arr) {
        throw new UnsupportedOperationException();
    }
}
