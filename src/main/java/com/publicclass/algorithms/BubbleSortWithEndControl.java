package com.publicclass.algorithms;

import java.util.Arrays;

// Kubanino @ https://public-class.com/
public class BubbleSortWithEndControl
{
    private static void swap(int[] array, int index1, int index2)
    {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    private static void sort(int[] array)
    {
        for (int i = 0; i < array.length - 1; i++)
        {
            boolean somethingWasSwapped = false;
            for (int j = 0; j < array.length - 1 - i; j++)
            {
                if (array[j] > array[j + 1])
                {
                    swap(array, j, j + 1);
                    somethingWasSwapped = true;
                }
                if (j == array.length - 2 - i)
                {
                    if (!somethingWasSwapped)
                    {
                        System.out.println("Pointless iteration, ending run.");
                        return;
                    }
                }
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
