package com.company;

import java.util.Random;

public class FloydWarshall {
    final static int INF =999;

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
}
