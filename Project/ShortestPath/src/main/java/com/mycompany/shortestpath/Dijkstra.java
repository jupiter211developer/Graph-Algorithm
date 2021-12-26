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
public class Dijkstra {
    public int INF = (int) 1e8;
    public int numVertices = 0;
    public int weight[][] = null;
    public int dist[][] = null;
    
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
        
        for (int i = 0; i < numVertices; i++) {
            dijkstra(i);
        }
        
        print();
    }
    
    public void initGraph() {
        weight = new int[numVertices][numVertices];
        dist = new int[numVertices][numVertices];
        
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                weight[i][j] = INF;
                if (i == j) {
                    weight[i][j] = 0;
                    dist[i][j] = 0;
                }
            }
        }
    }
    
    int minDistance(int d[], Boolean vis[])
    {
        int min = INF, min_id = -1;
  
        for (int v = 0; v < numVertices; v++)
            if (vis[v] == false && d[v] <= min) {
                min = d[v];
                min_id = v;
            }
  
        return min_id;
    }
  
    void print()
    {
        System.out.println("Dijkstra algorithm");
        for (int i=0; i< numVertices; ++i)
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
  
    // Function that implements Dijkstra's single source shortest path
    // algorithm for a graph represented using adjacency matrix
    // representation
    void dijkstra(int src)
    {
        int d[] = new int[numVertices];
        Boolean vis[] = new Boolean[numVertices];
  
        for (int i = 0; i < numVertices; i++) {
            d[i] = INF;
            vis[i] = false;
        }
  
        d[src] = 0;
  
        for (int count = 0; count < numVertices; count++) {
            int u = minDistance(d, vis);
  
            // Mark the picked vertex as processed
            vis[u] = true;
  
            // Update dist value of the adjacent vertices of the
            // picked vertex.
            for (int v = 0; v < numVertices; v++)
                if (!vis[v] && weight[u][v] != 0 && 
                   d[u] != INF && d[u] + weight[u][v] < d[v])
                    d[v] = d[u] + weight[u][v];
        }
        
        for (int i = 0; i < numVertices; i++) {
            dist[src][i] = d[i];
        }
    }
 
}
