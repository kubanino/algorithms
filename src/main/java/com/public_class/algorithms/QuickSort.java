package com.public_class.algorithms;

import java.util.Arrays;

// Kubanino @ https://public-class.com/
public class QuickSort
{
    private static void swap(int[] array, int index1, int index2)
    {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    private static void sort(int[] array, int leftPointer, int rightPointer)
    {
        if (leftPointer + 1 == rightPointer)
        {
            if (array[leftPointer] > array[rightPointer])
            {
                swap(array, leftPointer, rightPointer);
            }
            return;
        }
        int threshold = leftPointer;
        for (int i = leftPointer; i < rightPointer; i++)
        {
            if (array[i] > array[rightPointer])
            {
                continue;
            }
            swap(array, threshold, i);
            threshold++;
        }
        swap(array, threshold, rightPointer);

        if (leftPointer < threshold - 1)
        {
            sort(array, leftPointer, threshold - 1);
        }
        if (threshold + 1 < rightPointer)
        {
            sort(array, threshold + 1, rightPointer);
        }
    }

    public static void main(String[] args)
    {
        int[] input = {1, 2, 5, 3, 2, 6, 7, 2, 3, 123, 54, 324, 17};
        sort(input, 0, input.length - 1);

        System.out.println(Arrays.toString(input));
    }
}