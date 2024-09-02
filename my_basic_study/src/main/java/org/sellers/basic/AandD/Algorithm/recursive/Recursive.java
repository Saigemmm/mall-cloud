package org.sellers.basic.AandD.Algorithm.recursive;

public class Recursive {
    public static void main(String[] args) {
        print(10);
    }

    private static void print(int i){
        if(i>0){
            System.out.println(i);
            print(i-1);
        }
    }
}
