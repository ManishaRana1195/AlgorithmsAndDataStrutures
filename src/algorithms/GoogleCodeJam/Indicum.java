package algorithms.GoogleCodeJam;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Indicum {
    private static int testcaseNumber = 0;

    /*
    * Problem:
    * Indicium means "trace" in Latin. In this problem we work with Latin squares and matrix traces. A Latin square
    * is an N-by-N square matrix in which each cell contains one of N different values, such that no value is
    * repeated within a row or a column. In this problem, we will deal only with "natural Latin squares" in which the N
    * values are the integers between 1 and N. The trace of a square matrix is the sum of the values on the main diagonal
     * (which runs from the upper left to the lower right). Given values N and K, produce any N-by-N "natural Latin square"
     * with trace K, or say it is impossible. For example, here are two possible answers for N = 3, K = 6. In each case, the
      * values that contribute to the trace are underlined. */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Integer testcases = scan.nextInt();

        while (testcases > 0) {
            testcaseNumber += 1;
            int colDuplicateCount = 0;
            int rowDuplicateCount = 0;
            int size = scan.nextInt();
            boolean isImpossible = false;
            int matrix[][] = new int[size][size];
            int sum = 0;
            Set<Integer>[] columnUniqueValues = getColumnHashset(size);

            for (int i = 0; i < size; i++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < size; j++) {
                    int curr = scan.nextInt();
                    matrix[i][j] = curr;
                    if (i == j) {
                        sum += curr;
                    }
                    if (!rowSet.contains(curr)) {
                        rowSet.add(curr);
                    } else {
                        isImpossible = true;
                        break;
                    }
                    Set<Integer> colUnique = columnUniqueValues[j];
                    if (!colUnique.contains(curr)) {
                        colUnique.add(curr);
                        columnUniqueValues[j] = colUnique;
                    }
                }
                if (rowSet.size() < size) {
                    rowDuplicateCount += 1;
                }
            }

            for (Set<Integer> set : columnUniqueValues) {
                if (set.size() < size) {
                    colDuplicateCount += 1;
                }
            }


            System.out.println("Case #" + testcaseNumber + ": " + sum + " " + rowDuplicateCount + " " + colDuplicateCount);

            testcases--;
        }

    }

    public static Set<Integer>[] getColumnHashset(int size) {
        Set<Integer>[] set = new HashSet[size];
        for (int i = 0; i < size; i++) {
            set[i] = new HashSet<Integer>();
        }
        return set;
    }

}
