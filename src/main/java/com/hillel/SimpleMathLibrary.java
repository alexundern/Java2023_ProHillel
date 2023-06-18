package com.hillel;

public class SimpleMathLibrary {
    public double add(double a, double b) {
        return a + b;
    }

    public double minus(double a, double b) {
        return a - b;
    }


    public static int[] extractElementsAfterLastFour(int[] input) {
        int lastIndex = -1;

        for (int i = 0; i < input.length; i++) {
            if (input[i] == 4) {
                lastIndex = i;
            }
        }

        if (lastIndex == -1) {
            throw new RuntimeException("Input array must contain at least one 4");
        }

        int[] result = new int[input.length - lastIndex - 1];
        System.arraycopy(input, lastIndex + 1, result, 0, result.length);
        return result;
    }
//
//    public boolean containsOneAndFour(int[] input) {
//        boolean containsOne = false;
//        boolean containsFour = false;
//
//        for (int num : input) {
//            if (num == 1) {
//                containsOne = true;
//            } else if (num == 4) {
//                containsFour = true;
//            }
//        }
//
//        return containsOne && containsFour;
}

