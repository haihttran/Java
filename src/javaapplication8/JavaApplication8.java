/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication8;

import java.util.Arrays;

/**
 *
 * @author hai.tht
 */
public class JavaApplication8 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Create first input array
        int[] array = new int[]{0, 1, 0, 1, 0, 1};
        //Print out the input array
        System.out.printf("%s %s", "Input array:", "\t");
        for (int i : array) {            
            System.out.printf("%d \t", i);
        }
        System.out.println();
        int[] output = reorder(array);
        //print out the output array
        System.out.printf("%s %s", "Output array:", "\t");
        for (int i = 0; i < output.length; i++) {
            System.out.printf("%d \t", output[i]);
        }
        System.out.println();
        //Create second input array
        int[] array2 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        //Print out the input array
        System.out.printf("%s %s", "Input array:", "\t");
        for (int i : array2) {
            System.out.printf("%d \t", i);
        }
        System.out.println();
        //Reorder input array and place items into output array
        int[] another_output = reorder(array2);
        //Print out the output array
        System.out.printf("%s %s", "Output array:", "\t");
        for (int i = 0; i < another_output.length; i++) {
            System.out.printf("%d \t", another_output[i]);
        }
    }

    /* This function accepts an int array as input and call to the recursive
     function to reorder the items of input array. 
     Finally, it returns the result array.
     */
    private static int[] reorder(int[] input) {
        int[] result = new int[input.length];
        int counter = 0;
        rearrange(input, counter, input.length, result);
        return result;
    }

    /*This recursive function reorder items of the input array.
     The algorithm is simple: since the input array length is always even, so
     we split the input array into two partitions: head and tail. The head part
     consist 2 items and the first item will be always at even indices, so we add
     it to the left half of the output array. Similarly, secondsitem of the head 
     will be place to the right half of the output array. The tail partition of 
     the input consists the remaining items and will be used as the input of the
     recursive call to the rearrange function.
     */
    private static void rearrange(int[] input, int counter, int length, int[] result) {
        if (input.length == 2) {
            result[counter] = input[0];
            result[length / 2 + counter] = input[1];
        } else {
            rearrange(Arrays.copyOfRange(input, 0, 2), counter, length, result);
            rearrange(Arrays.copyOfRange(input, 2, input.length), counter + 1, length, result);
        }
    }

}
