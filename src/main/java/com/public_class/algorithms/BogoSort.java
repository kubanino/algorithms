package com.public_class.algorithms;

import java.util.Arrays;
import java.util.Random;

public class BogoSort
{
    private static final Random random = new Random();

    private static void swap(int[] array, int index1, int index2)
    {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    private static boolean isSorted(int[] array)
    {
        for (int i = 0; i < array.length - 2; i++)
        {
            if (array[i] > array[i + 1])
            {
                return false;
            }
        }
        return true;
    }

    private static void shuffleArray(int[] array)
    {
        for (int i = 0; i < array.length - 1; i++)
        {
            swap(array, i, random.nextInt(array.length));
        }
    }

    private static void sort(int[] array)
    {
        int counter = 0;

        while (!isSorted(array))
        {
            counter++;
            shuffleArray(array);
        }
        System.out.printf("It took %d shuffles to sort it! Sick!", counter);
    }

    public static void main(String[] args)
    {
        int[] input = {7777, 8768, 5, 3, 2, 54, 324, 17};
        sort(input);

        System.out.println(Arrays.toString(input));
    }
}
