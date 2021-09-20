package com.public_class.algorithms;

import java.util.Arrays;

@SuppressWarnings("Duplicates")
public class IntroSort
{
    // IntroSort combines QuickSort, HeapSort and InsertionSort. Not stable due to QuickSort being not stable.
    private static void swap(int[] array, int index1, int index2)
    {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    private static int medianOfThree(int[] array, int a, int b, int c)
    {
        if (array[a] < array[b] && array[b] < array[c])
        {
            return b;
        }
        else if (c <= array[b] && array[b] <= array[a])
        {
            return b;
        }
        else if (array[a] < array[c] && array[c] <= array[b])
        {
            return c;
        }
        else if (array[b] < array[c] && array[c] <= array[a])
        {
            return c;
        }
        else if (array[b] <= array[a] && array[a] < array[c])
        {
            return a;
        }
        return a; // else if (c <= a && a < b)
    }

    private static int findLastParentNodeOfGivenMaxHeap(int lastHeapElementIndex)
    {
        return (lastHeapElementIndex > 2) ? (lastHeapElementIndex - 1) / 2 : 0;
    }

    private static void insert(int[] array, int elementToBeInserted)
    {
        int tempValueOfElement = array[elementToBeInserted];
        for (int i = elementToBeInserted; i > 0; i--)
        {
            if (tempValueOfElement < array[i - 1])
            {
                array[i] = array[i - 1];
            }
            else
            {
                array[i] = tempValueOfElement;
                return;
            }
        }
        array[0] = tempValueOfElement;
    }

    private static void insertionSort(int[] array)
    {
        if (array.length > 1)
        {
            for (int i = 0; i < array.length - 1; i++)
            {
                if (array[i + 1] <= array[i])
                {
                    insert(array, i + 1);
                }
            }
        }
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

    private static void heapSort(int[] array)
    {
        buildMaxHeap(array, array.length - 1);
        for (int i = array.length - 1; i > 0; i--)
        {
            swap(array, 0, i);
            rebuildMaxHeapFromGivenParentNode(array, 0, i - 1);
        }
    }

    private static int quicksort(int[] array, int start, int end)
    {
        int pivot = array[end];
        int i = start;

        for (int j = start; j < end; j++)
        {
            if (array[j] <= pivot)
            {
                swap(array, i++, j);
            }
        }
        swap(array, i++, end);
        return i;
    }

    private static void introSort(int[] array, int start, int end, int depthLimit)
    {
        if ((end - start) < 16)
        {
            insertionSort(array);
            return;
        }
        if (0 == depthLimit)
        {
            heapSort(array);
            return;
        }
        int pivot = medianOfThree(array, start, (end - start) / 2, end);
        swap(array, pivot, end);

        int partitionIndexAfterQuickSort = quicksort(array, start, end);
        introSort(array, start, partitionIndexAfterQuickSort - 1, depthLimit - 1);
        introSort(array, partitionIndexAfterQuickSort + 1, end, depthLimit);
    }

    private static void sort(int[] array)
    {
        introSort(array, 0, array.length - 1, (int) Math.log(array.length));
    }

    public static void main(String[] args)
    {
        int[] input = {7777, 8768, 765, 1, 2, 5, 3, 2, 6, 555, 7, 2, 3, 123, 54, 324, 17};
        sort(input);

        System.out.println(Arrays.toString(input));
    }
}
