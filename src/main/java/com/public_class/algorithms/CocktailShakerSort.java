package com.public_class.algorithms;

import java.util.Arrays;

// Kubanino @ https://public-class.com/
public class CocktailShakerSort
{
    private static void swap(int[] array, int index1, int index2)
    {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    private static boolean traverseRightwards(int[] array, int margin)
    {
        boolean somethingWasSwapped = false;
        for (int j = 0; j < array.length - 1 - margin; j++)
        {
            if (array[j] > array[j + 1])
            {
                swap(array, j, j + 1);
                somethingWasSwapped = true;
            }

            if (j == array.length - 2 - margin)
            {
                if (!somethingWasSwapped)
                {
                    System.out.println("Pointless iteration, ending run.");
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean traverseLeftwards(int[] array, int margin)
    {
        boolean somethingWasSwapped = false;
        for (int j = array.length - 1 - margin; j > margin; j--)
        {
            if (array[j] < array[j - 1])
            {
                swap(array, j, j - 1);
                somethingWasSwapped = true;
            }

            if (j == margin + 1)
            {
                if (!somethingWasSwapped)
                {
                    return false;
                }
            }
        }
        return true;
    }

    private static void sort(int[] array)
    {
        for (int i = 0; i < array.length / 2; i++)
        {
            if (!(traverseRightwards(array, i) && traverseLeftwards(array, i)))
            {
                return;
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
