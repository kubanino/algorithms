package com.public_class.algorithms;

import java.util.Arrays;

public class SelectionSort
{
    private static void swap(int[] array, int index1, int index2)
    {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    private static void sort(int[] array)
    {
        for (int i = 0; i < array.length; i++)
        {
            int indexOfSmallerElement = i;
            for (int j = i; j < array.length; j++)
            {
                indexOfSmallerElement = (array[j] < array[indexOfSmallerElement]) ? j : indexOfSmallerElement;
            }
            if (indexOfSmallerElement != i)
            {
                swap(array, indexOfSmallerElement, i);
            }
        }
    }

    public static void main(String[] args)
    {
        int[] input = {7777, 1, 2, 5, 3, 2, 6, 555, 7, 2, 3, 123, 54, 324, 17};
        sort(input);

        System.out.println(Arrays.toString(input));
    }
}
