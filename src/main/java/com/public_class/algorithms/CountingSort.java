package com.public_class.algorithms;

import java.util.Arrays;

public class CountingSort
{
    private static int[] accumulateIndexes(int[] array)
    {
        for (int i = 0, accumulatedSum = 0; i < array.length; i++)
        {
            array[i] = (accumulatedSum += array[i]);
        }
        return array;
    }

    private static int maxElementOfArray(int[] array)
    {
        int maxElement = 0;

        for (int element : array)
        {
            maxElement = (element > maxElement) ? element : maxElement;
        }
        return maxElement;
    }

    private static int[] arrayOfElementOccurrences(int[] array)
    {
        int[] countingArray = new int[maxElementOfArray(array) + 2];

        for (int element : array)
        {
            countingArray[element + 1]++; // use offset +1, later it will save index calculations
        }
        return accumulateIndexes(countingArray);
    }

    public static int[] sort(int[] input)
    {
        int[] occurrences = arrayOfElementOccurrences(input);
        int[] sorted = new int[input.length];

        for (int element : input)
        {
            sorted[occurrences[element]++] = element;
        }
        return sorted;
    }

    public static void main(String[] args)
    {
        int[] input = {1, 2, 5, 3, 2, 6, 7, 2, 3, 123, 54, 324, 17};
        int[] sorted = sort(input);

        System.out.println(Arrays.toString(sorted));
    }
}
