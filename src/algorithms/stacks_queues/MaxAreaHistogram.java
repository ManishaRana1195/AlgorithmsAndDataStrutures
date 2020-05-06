package algorithms.stacks_queues;

import java.util.Stack;

public class MaxAreaHistogram {

    public static void main(String[] args) {
        largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3, 1, 2});
    }

    public static int largestRectangleArea(int[] heights) {
        int len = heights.length;
        if (len == 0) return 0;
        if (len == 1) return heights[0];

        Stack<Pair> leftMinIndexStack = new Stack<>();
        int[] leftMinIndexArray = new int[len];
        Stack<Pair> rightMinIndexStack = new Stack<>();
        int[] rightMinIndexArray = new int[len];

        leftMinIndexStack.push(new Pair(heights[0], -1));
        leftMinIndexArray[0] = -1;
        for (int i = 1; i < len; i++) {
            Pair topmost = leftMinIndexStack.peek();
            if (leftMinIndexStack.isEmpty()) {
                leftMinIndexArray[i] = -1;
            } else if (heights[i] < topmost.value) {
                while (!leftMinIndexStack.isEmpty() && topmost.value > heights[i]) {
                    topmost = leftMinIndexStack.pop();
                }
                if (leftMinIndexStack.size() == 0) {

                }

            } else {

            }
            leftMinIndexArray[i] = topmost.index;
            leftMinIndexStack.push(new Pair(heights[i], i));
            System.out.println(leftMinIndexArray[i]);
        }

//        rightMinIndexArray[len - 1] = len;
//        rightMinIndexStack.push(new Pair(heights[len - 1], len));
//        for (int i = len - 2; i >= 0; i--) {
//            Pair topmost = rightMinIndexStack.peek();
//            if (heights[i] < topmost.value) {
//                while (!rightMinIndexStack.isEmpty() && topmost.value > heights[i]) {
//                    topmost = rightMinIndexStack.pop();
//                }
//            }
//            rightMinIndexArray[i] = topmost.index;
//            rightMinIndexStack.push(new Pair(heights[i], i));
//            //System.out.println(rightMinIndexArray[i]);
//        }

        int maxValue = -1;
        for (int i = 0; i < len; i++) {
            int calculatedArea = heights[i] * (rightMinIndexArray[i] - leftMinIndexArray[i] - 1);
            if (calculatedArea > maxValue) {
                maxValue = calculatedArea;
            }
        }
        return maxValue;
    }

}

class Pair {
    int value;
    int index;

    public Pair(int value, int index) {
        this.value = value;
        this.index = index;
    }
}
