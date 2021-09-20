package com.public_class.algorithms;

import java.util.Arrays;

public class ShellSort
{
    private static void insert(int[] array, int elementToBeInserted, int distance)
    {
        int tempValueOfElement = array[elementToBeInserted];
        for (int i = elementToBeInserted; i > 0; i -= distance)
        {
            if (tempValueOfElement < array[i - distance])
            {
                array[i] = array[i - distance];
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
        for (int distance = array.length / 2; distance > 0; distance /= 2)
        {
            if (array.length > 1)
            {
                for (int i = 0; i < array.length - distance; i += distance)
                {
                    if (array[i + distance] <= array[i])
                    {
                        insert(array, i + distance, distance);
                    }
                }
            }
        }
    }

    public static void main(String[] args)
    {
        int[] input = {1, 2, 5, 3, 2, 6, 7, 2, 3, 123, 54, 324, 17, 1, 2123, 21, 2, 13, 65, 33, 12, 54, 3, 43, 888};
        sort(input);

        System.out.println(Arrays.toString(input));
    }
}
