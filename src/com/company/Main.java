package com.company;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.io.IOException;

public class Main {
    final static int INF =999;
    public static void main(String[] args) {
        AllPairsShortestPath allpairs = new AllPairsShortestPath();
        final int INF =999;
        int n = 4;
        int graph[][] = {{0, 5, INF, 10},
                {INF, 0, 3, INF},
                {INF, INF, 0, 1},
                {INF, INF, INF, 0}};
        int trueGraph[][] = {{0, 5, 8, 9},
                {INF, 0, 3, 4},
                {INF, INF, 0, 1},
                {INF, INF, INF, 0}};
        int[][] length = allpairs.dijkstraNew(graph, n);
        allpairs.printMatrix(length, "Djikstra");
        System.out.println();
    }
}
