package com.lemonaidapp.misc;

/**
 * Created by ddcdanter on 7/15/14.
 */
public class SumMultiplesOf3And5 {

        public int sum(int input){
            int sum=0;
            for(int i=0; i<input; i++) {
                if((i%3 == 0) || (i%5 == 0)){
                    sum += i;
                }
            }
            return sum;
        }

        public static void main(String[] args){
            SumMultiplesOf3And5 number = new SumMultiplesOf3And5();
            System.out.println(number.sum(1000));
        }
    }
