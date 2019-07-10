package datastructures.union_find;

import java.util.Scanner;

public class KruskalAlgorithmUnionFind {

  public static void main(String[] args) {
    System.out.println("Enter number of nodes:");
    int numberOfNodes = new Scanner(System.in).nextInt();
    UnionFind unionFind = new UnionFind(numberOfNodes);

    System.out.println(unionFind.connected(0, 5));
    unionFind.union(0, 5);
    System.out.println(unionFind.connected(1, 4));
    unionFind.union(1, 4);

  }
}
