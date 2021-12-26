/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.shortestpath;

import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class Main {
    public static void main(String...args) {
        try {
            (new Floyd()).readFromFile("graph.txt");
            (new Dijkstra()).readFromFile("graph.txt");
            
            System.out.println("Graph containing minus edges");
            (new Floyd()).readFromFile("graph - minus.txt");
            (new Dijkstra()).readFromFile("graph - minus.txt");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

/*
4 4     // number of vertices, number of edges
0 1 5   // start point, end point, weight
1 2 3
2 3 1
0 3 10

4 4
0 1 5
1 2 3
2 3 -1
0 3 10
If a graph has only negative edges, not negative cycles, two algorithm work correctly. 
But if a graph has negative cycles, then it goes wrong.
Bellman Ford algorithm is recommended.


// A graph containing a negative cycle.
4 5
0 1 5
1 2 3
2 3 -1
3 0 -20
0 3 10
*/