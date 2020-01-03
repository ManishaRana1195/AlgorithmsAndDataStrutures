package algorithms.Recursion;

public class PowerX {

    public static void main(String[] args) {
        int N = 2;
        int pow = 6;

        System.out.println(pow + " to the power " + N + " is:");
        System.out.println(getPowerOfX(pow, N));
    }

    private static int getPowerOfX(int pow, int n) {
        if (pow == 1) return n;

        int temp = getPowerOfX(pow / 2, n);
        if (pow % 2 == 0) {
            return temp * temp;
        } else {
            return temp * temp * n;
        }
    }
}
