package com.hillel;

public class ArrayChecker {
    public static boolean checkArrayComposition(int[] array) {
        boolean hasOne = false;
        boolean hasFour = false;

        for (int num : array) {
            if (num == 1) {
                hasOne = true;
            } else if (num == 4) {
                hasFour = true;
            }
        }

        return hasOne && hasFour;
    }

}
