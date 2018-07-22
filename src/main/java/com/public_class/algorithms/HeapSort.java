package com.public_class.algorithms;

import java.util.Arrays;

// Kubanino @ https://public-class.com/
public class HeapSort
{
    private static void swap(int[] array, int index1, int index2)
    {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    private static int findLastParentNodeOfGivenMaxHeap(int lastHeapElementIndex)
    {
        return (lastHeapElementIndex > 2) ? (lastHeapElementIndex - 1) / 2 : 0;
    }

    private static void rebuildMaxHeapFromGivenParentNode(int[] array, int parentNodeIndex, int lastHeapElementIndex)
    {
        int leftChildIndex = 2 * parentNodeIndex + 1;
        int rightChildIndex = 2 * parentNodeIndex + 2;

        if (lastHeapElementIndex >= rightChildIndex)
        {
            if (array[rightChildIndex] >= array[leftChildIndex])
            {
                if (array[parentNodeIndex] < array[rightChildIndex])
                {
                    swap(array, parentNodeIndex, rightChildIndex);
                    rebuildMaxHeapFromGivenParentNode(array, rightChildIndex, lastHeapElementIndex);
                }
            }
            else
            {
                if (array[parentNodeIndex] < array[leftChildIndex])
                {
                    swap(array, parentNodeIndex, leftChildIndex);
                    rebuildMaxHeapFromGivenParentNode(array, leftChildIndex, lastHeapElementIndex);
                }
            }
        }
        else
        {
            if (lastHeapElementIndex >= leftChildIndex)
            {
                if (array[parentNodeIndex] < array[leftChildIndex])
                {
                    swap(array, parentNodeIndex, leftChildIndex);
                    rebuildMaxHeapFromGivenParentNode(array, leftChildIndex, lastHeapElementIndex);
                }
            }
        }
    }

    private static void buildMaxHeap(int[] array, int lastHeapElementIndex)
    {
        for (int i = findLastParentNodeOfGivenMaxHeap(lastHeapElementIndex); i >= 0; i--)
        {
            rebuildMaxHeapFromGivenParentNode(array, i, lastHeapElementIndex);
        }
    }

    private static void sort(int[] array)
    {
        buildMaxHeap(array, array.length - 1);
        for (int i = array.length - 1; i > 0; i--)
        {
            swap(array, 0, i);
            rebuildMaxHeapFromGivenParentNode(array, 0, i - 1);
        }
    }

    public static void main(String[] args)
    {
        int[] input = {9, 7, 4, 3, 6, 5, 1, 2, 8, 11};
        sort(input);

        System.out.println(Arrays.toString(input));
    }
}