package algorithms.arrays;

public class ShortestSubarraySumK {

    public static void main(String[] args) {
        int[] input = {2, -1, 2};
        //int[] input = {5,0, 2, -1, 2, 4};
        int k = 3;

        int f = 0;
        int s = 0;
        int sum = 0;
        int minLength = Integer.MAX_VALUE;
        int len = input.length;
        int length;
        while (s <= len) {
            if (sum < k) {
                if (f >= len) {
                    continue;
                }
                //System.out.println(f);
                sum += input[f];
                f += 1;
            } else if (sum > k) {
                length = f - s + 1;
                minLength = Math.min(minLength, length);
                sum -= input[s];
                s += 1;
            } else {
                length = f - s + 1;
                minLength = Math.min(minLength, length);
                if (s < len  && input[s] == 0) {
                    s += 1;
                }
                f++;
                s++;
            }
        }

        System.out.println(minLength);
    }
}
