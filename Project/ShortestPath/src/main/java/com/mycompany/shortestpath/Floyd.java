/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.shortestpath;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Floyd {
    public int INF = (int) 1e8;
    public int numVertices = 0;
    public int weight[][] = null;
    
    public void readFromFile(String filename) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(filename));
        
        numVertices = scanner.nextInt();
        int numEdges = scanner.nextInt();
        
        initGraph();
        while (numEdges > 0) {
            numEdges--;
            int st = scanner.nextInt();
            int ed = scanner.nextInt();
            int w = scanner.nextInt();
            weight[st][ed] = w;
        }
        
        floydWarshall();
    }
    
    public void initGraph() {
        weight = new int[numVertices][numVertices];
        
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                weight[i][j] = INF;
                if (i == j) {
                    weight[i][j] = 0;
                }
            }
        }
    }
  
    void floydWarshall()
    {
        int dist[][] = new int[numVertices][numVertices];
        int i, j, k;
  
        for (i = 0; i < numVertices; i++)
            for (j = 0; j < numVertices; j++)
                dist[i][j] = weight[i][j];
  
        for (k = 0; k < numVertices; k++)
        {
            for (i = 0; i < numVertices; i++)
            {
                for (j = 0; j < numVertices; j++)
                {
                    if (dist[i][k] + dist[k][j] < dist[i][j])
                        dist[i][j] = dist[i][k] + dist[k][j];
                }
            }
        }
  
        print(dist);
    }
  
    void print(int dist[][])
    {
        System.out.println("FloydWarshall algorithm");
        for (int i=0; i<numVertices; ++i)
        {
            for (int j=0; j < numVertices; ++j)
            {
                if (dist[i][j]>INF/2)
                    System.out.print("INF ");
                else
                    System.out.print(dist[i][j]+"   ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
