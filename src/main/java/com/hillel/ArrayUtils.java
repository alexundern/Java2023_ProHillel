package com.hillel;

public class ArrayUtils {
    public static int[] extractElementsAfterLastFour(int[] array) {
        int lastIndex = -1;

        for (int i = 0; i < array.length; i++) {
            if (array[i] == 4) {
                lastIndex = i;
            }
        }

        if (lastIndex == -1) {
            throw new RuntimeException("Input array does not contain any four");
        }

        int[] result = new int[array.length - lastIndex - 1];
        System.arraycopy(array, lastIndex + 1, result, 0, result.length);

        return result;
    }
}
