import java.util.Arrays;

import static java.lang.System.arraycopy;

public class MergeSort
{
    public static int[] sort(int[] input)
    {
        return split(input);
    }

    private static int[] split(int[] input)
    {
        if (input.length < 2)
        {
            return input;
        }

        int leftSize = (input.length / 2);
        int[] leftPart = new int[leftSize];
        int[] rightPart = new int[input.length - leftSize];

        arraycopy(input, 0, leftPart, 0, leftSize);
        arraycopy(input, leftSize, rightPart, 0, input.length - leftSize);

        leftPart = (leftPart.length < 2) ? leftPart : split(leftPart);
        rightPart = (rightPart.length < 2) ? rightPart : split(rightPart);

        return merge(leftPart, rightPart);
    }

    private static int[] merge(int[] leftPart, int[] rightPart)
    {
        int resultSize = leftPart.length + rightPart.length;
        int leftPointer = 0;
        int rightPointer = 0;

        int[] result = new int[resultSize];

        for (int i = 0; i < result.length; i++)
        {
            if (leftPointer != leftPart.length && rightPointer != rightPart.length)
            {
                result[i] = (leftPart[leftPointer] < rightPart[rightPointer]) ?
                        leftPart[leftPointer++] : rightPart[rightPointer++];
            }
            else
            {
                if (leftPointer < leftPart.length)
                {
                    result[i] = leftPart[leftPointer++];
                }
                else if (rightPointer < rightPart.length)
                {
                    result[i] = rightPart[rightPointer++];
                }
            }
        }
        return result;
    }

    public static void main(String[] args)
    {
        int[] input = {1, 2, 5, 3, 2, 6, 7, 2, 3, 123, 54, 324, 17};
        int[] sorted = sort(input);

        System.out.println(Arrays.toString(sorted));
    }
}
