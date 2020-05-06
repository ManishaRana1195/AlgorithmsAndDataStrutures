package algorithms.arrays;

public class BitonicArray {

    /*Find the maximum value in a given Bitonic array.*/
    public static void main(String[] args) {

        int[] array = {1, 3, 8, 12, 4, 2};
        System.out.println("The max value in bitonic array:");
        int maxValueIndex = getBitonicArrayMaxPoint(array);
        System.out.println(array[maxValueIndex]);
    }

    private static int getBitonicArrayMaxPoint(int[] array) {
        int start = 0;
        int end = array.length;
        while (start != end) {
            int mid = (start + end) / 2;
            if (array[mid] < array[mid + 1]) {
                start = mid +1;
            } else {
                end = mid;
            }
        }
        return start;
    }
}
