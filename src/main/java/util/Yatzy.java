package util;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Yatzy {

    public static int chance(int d1, int d2, int d3, int d4, int d5) {
        return d1 + d2 + d3 + d4 + d5;
    }

    public static int yatzy(int d1, int d2, int d3, int d4, int d5) {
        return List.of(d1, d2, d3, d4, d5).stream().distinct().count() == 1 ? 50 : 0;
    }

    public static int ones(int d1, int d2, int d3, int d4, int d5) {
        return getOccurrenceOf(d1, d2, d3, d4, d5, 1);
    }

    public static int twos(int d1, int d2, int d3, int d4, int d5) {
        return getOccurrenceOf(d1, d2, d3, d4, d5, 2) * 2;
    }

    public static int threes(int d1, int d2, int d3, int d4, int d5) {
        return getOccurrenceOf(d1, d2, d3, d4, d5, 3) * 3;
    }


    public static int fours(int d1, int d2, int d3, int d4, int d5) {
        return getOccurrenceOf(d1, d2, d3, d4, d5, 4) * 4;
    }

    public static int fives(int d1, int d2, int d3, int d4, int d5) {
        return getOccurrenceOf(d1, d2, d3, d4, d5, 5) * 5;

    }

    public static int sixes(int d1, int d2, int d3, int d4, int d5) {
        return getOccurrenceOf(d1, d2, d3, d4, d5, 6) * 6;
    }

    public static int onePair(int d1, int d2, int d3, int d4, int d5) {
        int[] diceOccurrences = getOccurenceTable(d1, d2, d3, d4, d5);
        for (int i = 0; i < 6; i++)
            if (diceOccurrences[5 - i] >= 2)
                return (6 - i) * 2;
        return 0;
    }

    public static int twoPair(int d1, int d2, int d3, int d4, int d5) {
        int[] diceOccurrences = getOccurenceTable(d1, d2, d3, d4, d5);
        int n = 0;
        int score = 0;
        for (int i = 0; i < 6; i += 1)
            if (diceOccurrences[5 - i] >= 2) {
                n++;
                score += 6 - i;
            }
        return n == 2 ? score * 2 : 0;
    }

    public static int fourOfAKind(int d1, int d2, int d3, int d4, int d5) {
        int[] diceOccurrences = getOccurenceTable(d1, d2, d3, d4, d5);

        for (int i = 0; i < 6; i++)
            if (diceOccurrences[i] >= 4)
                return (i + 1) * 4;
        return 0;
    }

    public static int threeOfAKind(int d1, int d2, int d3, int d4, int d5) {
        int[] diceOccurrences = getOccurenceTable(d1, d2, d3, d4, d5);

        for (int i = 0; i < 6; i++)
            if (diceOccurrences[i] >= 3)
                return (i + 1) * 3;
        return 0;
    }

    public static int smallStraight(int d1, int d2, int d3, int d4, int d5) {
        int[] diceOccurrences = getOccurenceTable(d1, d2, d3, d4, d5);
        if (diceOccurrences[0] == 1 &&
                diceOccurrences[1] == 1 &&
                diceOccurrences[2] == 1 &&
                diceOccurrences[3] == 1 &&
                diceOccurrences[4] == 1)
            return 15;
        return 0;
    }

    public static int largeStraight(int d1, int d2, int d3, int d4, int d5) {
        int[] diceOccurrences = getOccurenceTable(d1, d2, d3, d4, d5);
        return Arrays.stream(diceOccurrences).filter(d -> d == 1).skip(1).count() == 4 ? 20 : 0;
    }

    public static int fullHouse(int d1, int d2, int d3, int d4, int d5) {
        int[] diceOccurrences = getOccurenceTable(d1, d2, d3, d4, d5);
        boolean isPairFound = false;
        int i;
        int pairDiceValue = 0;
        boolean isThreeFound = false;
        int threeKindDiceValue = 0;


        for (i = 0; i < 6; i++)
            if (diceOccurrences[i] == 2) {
                isPairFound = true;
                pairDiceValue = i + 1;
            }

        for (i = 0; i < 6; i++)
            if (diceOccurrences[i] == 3) {
                isThreeFound = true;
                threeKindDiceValue = i + 1;
            }

        if (isPairFound && isThreeFound)
            return pairDiceValue * 2 + threeKindDiceValue * 3;
        else
            return 0;
    }

    private static int[] getOccurenceTable(int d1, int d2, int d3, int d4, int d5) {
        int[] counts = new int[6];
        counts[d1 - 1]++;
        counts[d2 - 1]++;
        counts[d3 - 1]++;
        counts[d4 - 1]++;
        counts[d5 - 1]++;
        return counts;
    }

    private static int getOccurrenceOf(int d1, int d2, int d3, int d4, int d5, int target) {
        return Collections.frequency(List.of(d1, d2, d3, d4, d5), target);
    }
}