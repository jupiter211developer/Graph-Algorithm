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
public class QuickSort {
    int num[] = null;
    long accum = 0;
    
    public void swap(int[] a,int x,int y) {
        int temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }

    public int partition(int[] ar,int low, int high){

        int pivot= num[high];
        int i=low-1;
        for(int j=low;j<num.length;j++){
                if(num[j]<pivot){
                    i++;
                    swap(num,i,j);
                }
        }
        swap(num,i+1,high);
        return i+1;
    }

    public void sort(int low, int high){

        if(low<high){
            int pi = partition(num,low,high);
            sort(low,pi-1);
            sort(pi+1,high);
        }
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
        System.out.println("QuickSort Algorithm\n");
        
        for (int i = 0; i < Config.ARRAY_SIZE.length; i++) {
            int len = Config.ARRAY_SIZE[i];
            num = new int[len];
            accum = 0;
            
            for (int t = 0; t < Config.TIMES; t++) {
                for (int j = 0; j < len; j++) {
                    num[j] = rand.nextInt(Config.RANGE);
                }
                long startTime = System.nanoTime();
                sort(0, len-1);
                long endTime = System.nanoTime();
                long timeElapsed = endTime - startTime;
                accum += timeElapsed;
            }
            System.out.println(String.format("%d elements: %d", len, accum / Config.TIMES));
        }
        System.out.println("\n");
    }
}
