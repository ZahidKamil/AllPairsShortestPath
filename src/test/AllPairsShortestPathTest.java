package test;

import com.company.AllPairsShortestPath;
import org.junit.Test;

import java.util.Arrays;

public class AllPairsShortestPathTest {

    @Test
    public void floydWarshall()
    {
        final int INF =999;
        int graph[][] = {{0, 5, INF, 10},
                {INF, 0, 3, INF},
                {INF, INF, 0, 1},
                {INF, INF, INF, 0}};
        int trueGraph[][] = {{0, 5, 8, 9},
                {INF, 0, 3, 4},
                {INF, INF, 0, 1},
                {INF, INF, INF, 0}};
        AllPairsShortestPath allpairs = new AllPairsShortestPath();
        int checkGraph [][] = allpairs.floydWarshall(graph);
        Arrays.equals(trueGraph, checkGraph);
    }

    @Test
    public void DjikstraNew()
    {
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
        Arrays.equals(trueGraph, length);
    }


}
