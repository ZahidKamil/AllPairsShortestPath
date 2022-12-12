package com.company;

import java.util.Random;

public class AllPairsShortestPath {
    final static int INF =999;

    /**
     * Prints the matrix onto the console
     * @param a 2D matrix
     * @param s To print the type of matrix onto the console window
     */
    public void printMatrix(int [][]a, String s)
    {
        System.out.println(s);
        for (int i=0; i<a.length; i++)
        {
            for(int j=0; j<a.length; j++)
            {
                if(a[i][j] == INF)
                {
                    System.out.print("INF" + "\t");
                    continue;
                }
                System.out.print(a[i][j] + "\t");
            }
            System.out.println();
        }
    }

    /**
     * Generates filled/dense matrix
     * @param size size of square matrix nxn
     * @return matrix of [size][size] that is filled
     */
    public int[][] generateDenseMatrix(int size) {
        Random rand = new Random();
        int denseMatrix[][] = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                denseMatrix[i][j] = rand.nextInt(20);
            }
        }

        for(int i=0; i<size; i++) {
            int j = rand.nextInt(size);
            denseMatrix[i][j] = INF;
        }
        return denseMatrix;
    }

    /**
     * Generates sparse matrix
     * @param size size of square matrix nxn
     * @return matrix of [size][size] that is sparse
     */
    public int[][] generateSparseMatrix(int size)
    {
        Random rand = new Random();
        int sparseMatrix[][] = new int [size][size];
        for(int i=0; i<size;i++) {
            for (int j = 0; j < size; j++) {
                if(i ==j) {
                    sparseMatrix[i][j] =0;
                    continue;
                }
                sparseMatrix[i][j] = rand.nextInt(20);
            }
        }

        for(int i =0; i< (((size*size)*2)/3); i++) {
            int row = rand.nextInt(size);
            int col = rand.nextInt(size);
            sparseMatrix[row][col] = 0;
        }

        for(int i=0; i<size; i++) {
            int j = rand.nextInt(size);
            sparseMatrix[i][j] = INF;
        }

        return sparseMatrix;

    }

    /**
     *
     * @param Matrix Input Matrix of Dense or Sparse
     * @return all pairs shortest path
     */
    public int[][] floydWarshall(int [][] Matrix)
    {
        int size = Matrix.length;;
        int [][] outputMatrix = Matrix;
        for(int k=0; k<size;k++)
        {
            for(int i=0; i<size; i++) {
                for(int j=0; j<size; j++) {
                    if(outputMatrix[i][k] + outputMatrix[k][j] < outputMatrix[i][j]) {
                        outputMatrix[i][j] = outputMatrix[i][k] + outputMatrix[k][j];
                    }
                }
            }
        }
        return outputMatrix;
    }

    /**
     *
     * @param graph Input graph of size nxn
     * @param n number of vertices
     * @return all pairs shortest path
     */
    public int[][] dijkstraNew(int graph[][], int n)
    {

        int finalLength[][] = new int[n][n];
        for(int start=0; start<n; start++)
        {
            int length[] = new int[n];
            Boolean vertices[] = new Boolean[n];

            for (int i = 0; i < n; i++) {
                length[i] = Integer.MAX_VALUE;
                vertices[i] = false;
            }

            length[start] = 0;

            for (int i = 0; i < n - 1; i++) {
                int min = Integer.MAX_VALUE;
                int min_index = 0;
                int dist[] = length;

                for (int j = 0; j < n; j++) {
                    if (vertices[j] == false){
                        if (dist[j] <= min){
                            min = dist[j];
                            min_index = j;
                        }
                    }
                }
                int u = min_index;
                vertices[u] = true;

                for (int v = 0; v < n; v++) {
                    int len = length[u] + graph[u][v];
                    if (!vertices[v] && graph[u][v] != 0 && length[u] != Integer.MAX_VALUE && len < length[v]) {
                        length[v] = length[u] + graph[u][v];
                    }
                }

            }
            finalLength[start] = length;
        }
        return finalLength;
    }
}
