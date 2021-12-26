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
public class MergeSort {
    int num[] = null;
    long accum = 0;
    
    public void Merge(int[] ar,int l,int m,int r) {
        int i, j, k;

        int n1=m-l+1;
        int n2=r-m;

        int L[] = new int[n1];
        int R[] = new int[n2];

        for(i=0;i<n1;i++){
            L[i]=num[l+i];
        }

        for(j=0;j<n2;j++){
            R[j]=num[m+j+1];
        }

        i=0;
        j=0;
        k=l;

        while(i<n1 && j<n2){

            if(L[i]<=R[j]){
                ar[k]=L[i];
                i++;
            }else{
                ar[k]=R[j];
                j++;
            }
            k++;

        }

        while(i<n1){

            ar[k]=L[i];
            i++;
            k++;

        }

        while(j<n2){

            ar[k]=R[j];
            j++;
            k++;

        }
    }

    public void sort(int l,int r) {
       if(l < r) {
           int m = l + (r - l) / 2;
           sort(l, m);
           sort(m + 1, r);

           Merge(num, l, m, r);
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
        System.out.println("Merge Sort Algorithm\n");
        
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
