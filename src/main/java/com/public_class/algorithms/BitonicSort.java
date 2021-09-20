package com.public_class.algorithms;

import java.util.Arrays;

public class BitonicSort
{
    private static final boolean ASC = true;
    private static final boolean DESC = false;

    private static void swap(int[] array, int index1, int index2)
    {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    private static boolean isPowerOf2(int number)
    {
        if (number < 1)
        {
            return false;
        }
        else if (number == 1)
        {
            return true;
        }
        else if (number % 2 != 0)
        {
            return false;
        }
        return isPowerOf2(number / 2);
    }

    private static void sortFromBitonicSequence(int[] array, int start, int end, int initialStepSize, boolean order)
    {
        if (order == ASC)
        {
            for (int i = start; i < start + initialStepSize; i++)
            {
                if (array[i] > array[i + initialStepSize])
                {
                    swap(array, i, i + initialStepSize);
                }
            }
        }
        if (order == DESC)
        {
            for (int i = end; i > end - initialStepSize; i--)
            {
                if (array[i] > array[i - initialStepSize])
                {
                    swap(array, i, i - initialStepSize);
                }
            }
        }
        if (initialStepSize > 1)
        {
            sortFromBitonicSequence(array, start, start + initialStepSize - 1, initialStepSize / 2, order);
            sortFromBitonicSequence(array, start + initialStepSize, end, initialStepSize / 2, order);
        }
    }

    private static void createBitonicSequences(int[] array, int initialSequenceLength)
    {
        if (array.length < initialSequenceLength)
        {
            return;
        }
        for (int i = 0; i < array.length; i += initialSequenceLength)
        {
            sortFromBitonicSequence(array, i, i + initialSequenceLength / 2 - 1, initialSequenceLength / 4, ASC);
            sortFromBitonicSequence(array, i + initialSequenceLength / 2, i + initialSequenceLength - 1,
                    initialSequenceLength / 4, DESC);
        }
    }

    private static void sort(int[] array)
    {
        if (!isPowerOf2(array.length))
        {
            return;
        }
        for (int i = 4; i <= array.length; i *= 2)
        {
            createBitonicSequences(array, i);
        }
        sortFromBitonicSequence(array, 0, array.length - 1, array.length / 2, ASC);
    }

    public static void main(String[] args)
    {
        int[] input = {3, 44, 76, 21, 35, 7, 4, 8, 6, 78, 91, 42, 33, 2, 1, 5};
        sort(input);

        System.out.println(Arrays.toString(input));
    }
}
