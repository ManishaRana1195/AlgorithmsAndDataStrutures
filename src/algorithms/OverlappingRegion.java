package algorithms;

public class OverlappingRegion {

  public static void main(String[] args) {

    int[][] rect1 = {{2, 1}, {5, 5}};
    int[][] rect2 = {{3, 2}, {7, 5}};

    int x1 = Math.max(rect1[0][0], rect2[0][0]);
    int y1 = Math.max(rect1[0][1], rect2[0][1]);
    int x2 = Math.min(rect1[1][0], rect2[1][0]);
    int y2 = Math.min(rect1[1][1], rect2[1][1]);
    System.out.println(x1 + ", " + x2 + ", " + y1 + ", " + y1);
    System.out.println("The overlapping region is:" + (x2 - x1) * (y2 - y1));
  }
}
