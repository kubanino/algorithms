package com.public_class.algorithms;

import java.util.Arrays;

// Kubanino @ https://public-class.com/
public class GnomeSort
{
    private static void swap(int[] array, int index1, int index2)
    {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    private static void sort(int[] array)
    {
        if (array.length > 2)
        {
            int i = 1;
            int j = 2;

            while (i < array.length)
            {
                if (array[i - 1] <= array[i])
                {
                    i = j++;
                }
                else
                {
                    swap(array, i, i - 1);
                    i = (i > 1) ? --i : 1;
                }
            }
        }
    }

    public static void main(String[] args)
    {
        int[] input = {7777, 8768, 765, 1, 2, 5, 3, 2, 6, 555, 7, 2, 3, 123, 54, 324, 17};
        sort(input);

        System.out.println(Arrays.toString(input));
    }
}
