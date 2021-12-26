/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sortingalgo;

import java.util.Random;
/**
 *
 * @author Admin
 */
public class InsertionSort {
    int num[] = null;
    long accum = 0;
    
    public void swap(int[] a,int x,int y) {
        int temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }

    public void sort() {
        long startTime = System.nanoTime();
        
        for(int i = 1; i<num.length; i++){
            for(int j = i; j>0; j--){
                if(num[j]<num[j-1]){
                    swap(num,j,j-1);
                }
            }
        }
        
        long endTime = System.nanoTime();
 
        // get the difference between the two nano time valuess
        long timeElapsed = endTime - startTime;
        accum += timeElapsed;
    }
    
    public void show() {
        System.out.print("Sorted Process: "+" | ");
        for(int i = 0; i < num.length; i++) {
            System.out.print(num[i] + " | ");
        }
        System.out.println("\n");
    }
    
    public void perform() {
        Random rand = new Random();
        rand.setSeed(System.currentTimeMillis());
        System.out.println("Insertion Sort Algorithm\n");
        
        for (int i = 0; i < Config.ARRAY_SIZE.length; i++) {
            int len = Config.ARRAY_SIZE[i];
            num = new int[len];
            accum = 0;
            
            for (int t = 0; t < Config.TIMES; t++) {
                for (int j = 0; j < len; j++) {
                    num[j] = rand.nextInt(Config.RANGE);
                }
                sort();
            }
            System.out.println(String.format("%d elements: %d", len, accum / Config.TIMES));
        }
        System.out.println("\n");
    }
}