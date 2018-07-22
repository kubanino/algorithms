package com.public_class.algorithms;

import java.util.Arrays;

// Kubanino @ https://public-class.com/
public class InsertionSort
{
    private static void insert(int[] array, int elementToBeInserted)
    {
        int tempValueOfElement = array[elementToBeInserted];
        for (int i = elementToBeInserted; i > 0; i--)
        {
            if (tempValueOfElement < array[i - 1])
            {
                array[i] = array[i - 1];
            }
            else
            {
                array[i] = tempValueOfElement;
                return;
            }
        }
        array[0] = tempValueOfElement;
    }

    private static void sort(int[] array)
    {
        if (array.length > 1)
        {
            for (int i = 0; i < array.length - 1; i++)
            {
                if (array[i + 1] <= array[i])
                {
                    insert(array, i + 1);
                }
            }
        }
    }

    public static void main(String[] args)
    {
        int[] input = {1, 2, 5, 3, 2, 6, 7, 2, 3, 123, 54, 324, 17};
        sort(input);

        System.out.println(Arrays.toString(input));
    }
}
