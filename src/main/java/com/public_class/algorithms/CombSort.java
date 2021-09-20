package com.public_class.algorithms;

import java.util.Arrays;

public class CombSort
{
    private static void swap(int[] array, int index1, int index2)
    {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    private static void sort(int[] array)
    {
        int gap = (array.length * 10) / 13;
        boolean swapped = false;

        while (gap != 1 || swapped == true)
        {
            swapped = false;
            for (int i = 0; i < array.length - gap; i++)
            {
                if (array[i] > array[i + gap])
                {
                    swapped = true;
                    swap(array, i, i + gap);
                }
            }
            gap = (gap * 10) / 13;
            gap = (gap < 1) ? 1 : gap;
        }
    }

    public static void main(String[] args)
    {
        int[] input = {3, 44, 76, 21, 35, 7, 4, 8, 6, 78, 91, 42, 33, 2, 1, 5};
        sort(input);

        System.out.println(Arrays.toString(input));
    }
}
