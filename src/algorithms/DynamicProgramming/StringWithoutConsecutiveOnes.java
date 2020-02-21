package algorithms.DynamicProgramming;

public class StringWithoutConsecutiveOnes {

    public static void main(String[] args) {
        int length = 5;

        /*for n = 2, 01,10,00,
        * for n = 3, 000, 001, 100, 010, 101*/
        /*  n =1 , f(1) = 2 = fib(2),
        *   n =2 , f(2) = 3 = fib(3),
        *   n =3 , f(3) = 5 = fib(4),
        *   n =4 , f(4) = 8,
        *   n =5 , f(5) = 13,
        *   It looks like fibonacci series*/
        int count = getCountOfStringWithoutConsecutiveOnes(length + 1);

        System.out.println("The string count of length "+ length+" without consecutive ones:" + count);
    }

    private static int getCountOfStringWithoutConsecutiveOnes(int length) {
        if (length == 1) return 1;
        if (length == 0) return 1;

        return getCountOfStringWithoutConsecutiveOnes(length - 1) +
                getCountOfStringWithoutConsecutiveOnes(length - 2);
    }
}
