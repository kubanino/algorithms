package com.public_class.algorithms;

import java.util.Arrays;

// Kubanino @ https://public-class.com/
public class CycleSort
{ // good algorithm for costly memory writes (max one write per element)
    private static final int ITEM_ALREADY_AT_CORRECT_POSITION = -1;
    private static int writesCount = 0;

    private static int findOffsetPositionFromGivenCycleStart(int[] array, int cycleStart, int item)
    {
        int position = cycleStart;

        for (int i = cycleStart + 1; i < array.length; i++)
        {
            if (array[i] < item)
            {
                position++;
            }
        }
        if (position == cycleStart)
        {
            return ITEM_ALREADY_AT_CORRECT_POSITION;
        }
        while (item == array[position])
        {
            position++;
        }
        return position;
    }

    private static int replaceItemsAtGivenPositionAndReturnOldItem(int[] array, int position, int item)
    {
        int temp = array[position];
        writesCount++;
        array[position] = item;

        return temp;
    }

    private static void sort(int[] array)
    {
        int item, position;

        for (int cycleStart = 0; cycleStart < array.length; cycleStart++)
        {
            item = array[cycleStart];
            int cycleLength = 0;
            do
            {
                position = findOffsetPositionFromGivenCycleStart(array, cycleStart, item);
                if (position != ITEM_ALREADY_AT_CORRECT_POSITION)
                {
                    item = replaceItemsAtGivenPositionAndReturnOldItem(array, position, item);
                    cycleLength++;
                }
            }
            while (position != ITEM_ALREADY_AT_CORRECT_POSITION);
            if (cycleLength > 0)
            {
                array[cycleStart] = item;
            }
        }
        System.out.println("Well, how many writes do we have? " + writesCount);
    }

    public static void main(String[] args)
    {
        int[] input = {99, 3, 44, 76, 15, 11, 76, 9, 88, 12};
        sort(input);

        System.out.println(Arrays.toString(input));
    }
}
