package datastructures.arrays;

public class KadaneAlgorithm {

    public static void main(String[] args) {

        int[] inputArray = {-4, 2 , -1, 5 , -1, 6, 2, -7};

        int maxHere = inputArray[0], maxTotal = inputArray[0];
        for (int index = 1; index < inputArray.length; index++) {
            maxHere = Math.max(inputArray[index], inputArray[index] + maxHere);
            maxTotal = Math.max(maxHere, maxTotal);
        }

        System.out.println("The maximum sum of subarray possible:");
        System.out.println(maxTotal);
    }


}
