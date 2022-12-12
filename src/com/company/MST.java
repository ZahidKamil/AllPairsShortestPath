package com.company;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class MST {

    public static void main(String[] args) {
        int n;
        char userInput;
        String welcome = "Shortest Path Algorithms\n" + "Please Enter Maximum integer (n) of vertices for graph:\n";
        String menu = "Please enter one of the following options:\n" + "\ta) Floyd Warshall\n"
                + "\tb) Dijkstra\nEnter option: ";
        String invalidInput = "Invalid choice, please try again!";

        @SuppressWarnings("resource")
        Scanner kb = new Scanner(System.in);
        System.out.print(welcome);
        n = kb.nextInt();

        System.out.print(menu);
        userInput = kb.next().toLowerCase().charAt(0);
        while (userInput != 'a' && userInput != 'b' && userInput != 'c') {
            System.out.println("\n" + invalidInput + "\n\n" + menu);
            userInput = kb.next().toLowerCase().charAt(0);
        }

        if (userInput == 'a') {
            System.out.println();
            System.out.println("Floyd Warshalls Algorithm");
            System.out.println("----------------------------------------");
            System.out.println("The Weighted Matrix for the graph");
            AllPairsShortestPath allpairs = new AllPairsShortestPath();

            try{
                File outputFile = new File("FloydWarshallsparse.csv");
                PrintWriter writer = new PrintWriter(outputFile);
                for(int size = 10; size<= n; size=size+10)
                {
                    long time = 0;
                    for(int i=0; i< 5; i++)
                    {
                        int [][] Matrix = allpairs.generateSparseMatrix(size);
                        long start = System.currentTimeMillis();
                        int [][] outputMatrix = allpairs.floydWarshall(Matrix);
                        long end = System.currentTimeMillis();

                        time += (end - start);
                    }
                    time = time /5;
                    System.out.println(size + ":\t" + time + "ms");
                    writer.printf("%d, %d\n", size, time);
                }
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try{
                System.out.println("Finding times for Dense matrix in FloydWarshall algorithm");
                File outputFile = new File("FloydWarshalldense.csv");
                PrintWriter writer = new PrintWriter(outputFile);
                for(int size = 10; size<= n; size=size+10)
                {
                    long time = 0;
                    for(int i=0; i< 5; i++)
                    {
                        int [][] Matrix = allpairs.generateDenseMatrix(size);
                        long start = System.currentTimeMillis();
                        int [][] outputMatrix = allpairs.floydWarshall(Matrix);
                        long end = System.currentTimeMillis();
                        time += (end - start);
                    }
                    time = time /5;
                    System.out.println(size + ":\t" + time + "ms");
                    writer.printf("%d, %d\n", size, time);
                }
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if (userInput == 'b') {
            System.out.println();
            System.out.println("Dijkstras Algorithm");
            System.out.println("----------------------------------------");
            AllPairsShortestPath allpairs = new AllPairsShortestPath();
            try{
                File outputFile = new File("DjikstraSparse.csv");
                PrintWriter writer = new PrintWriter(outputFile);
                for(int size = 10; size<= n; size=size+10)
                {
                    long time = 0;
                    for(int i=0; i< 5; i++)
                    {
                        int [][] Matrix = allpairs.generateSparseMatrix(size);
                        long begin = System.currentTimeMillis();
                        int[][] outputMatrix = allpairs.dijkstraNew(Matrix, size);
                        long end = System.currentTimeMillis();
                        time += (end - begin);
                    }
                    time = time /5;
                    System.out.println(size + ":\t" + time + "ms");
                    writer.printf("%d, %d\n", size, time);
                }
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try{
                File outputFile = new File("DjikstraDense.csv");
                PrintWriter writer = new PrintWriter(outputFile);
                for(int size = 10; size<= n; size=size+10)
                {
                    long time = 0;
                    for(int i=0; i< 5; i++)
                    {
                        int [][] Matrix = allpairs.generateDenseMatrix(size);
                        long begin = System.currentTimeMillis();
                        int[][] outputMatrix = allpairs.dijkstraNew(Matrix, size);
                        long end = System.currentTimeMillis();
                        time += (end - begin);
                    }
                    time = time /5;
                    System.out.println(size + ":\t" + time + "ms");
                    writer.printf("%d, %d\n", size, time);
                }
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
