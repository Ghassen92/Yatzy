package util;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class Yatzy {

    public static int getScore(int d1, int d2, int d3, int d4, int d5, Category category) {
        switch (category) {
            case YAHTZEE:
                return yatzy(d1, d2, d3, d4, d5);
            case ONES:
                return ones(d1, d2, d3, d4, d5);
            case TWOS:
                return twos(d1, d2, d3, d4, d5);
            case THREES:
                return threes(d1, d2, d3, d4, d5);
            case FOURS:
                return fours(d1, d2, d3, d4, d5);
            case FIVES:
                return fives(d1, d2, d3, d4, d5);
            case SIXES:
                return sixes(d1, d2, d3, d4, d5);
            case ONE_PAIR:
                return onePair(d1, d2, d3, d4, d5);
            case TWO_PAIR:
                return twoPair(d1, d2, d3, d4, d5);
            case THREE_OF_A_KIND:
                return threeOfAKind(d1, d2, d3, d4, d5);
            case FOUR_OF_A_KIND:
                return fourOfAKind(d1, d2, d3, d4, d5);
            case SMALL_STRAIGHT:
                return smallStraight(d1, d2, d3, d4, d5);
            case LARGE_STRAIGHT:
                return largeStraight(d1, d2, d3, d4, d5);
            case FULL_HOUSE:
                return fullHouse(d1, d2, d3, d4, d5);
            default:
                return chance(d1, d2, d3, d4, d5);
        }
    }

    private static int chance(int d1, int d2, int d3, int d4, int d5) {
        return d1 + d2 + d3 + d4 + d5;
    }

    private static int yatzy(int d1, int d2, int d3, int d4, int d5) {
        return Stream.of(d1, d2, d3, d4, d5).distinct().count() == 1 ? 50 : 0;
    }

    private static int ones(int d1, int d2, int d3, int d4, int d5) {
        return getOccurrenceOf(d1, d2, d3, d4, d5, 1);
    }

    private static int twos(int d1, int d2, int d3, int d4, int d5) {
        return getOccurrenceOf(d1, d2, d3, d4, d5, 2) * 2;
    }

    private static int threes(int d1, int d2, int d3, int d4, int d5) {
        return getOccurrenceOf(d1, d2, d3, d4, d5, 3) * 3;
    }


    private static int fours(int d1, int d2, int d3, int d4, int d5) {
        return getOccurrenceOf(d1, d2, d3, d4, d5, 4) * 4;
    }

    private static int fives(int d1, int d2, int d3, int d4, int d5) {
        return getOccurrenceOf(d1, d2, d3, d4, d5, 5) * 5;

    }

    private static int sixes(int d1, int d2, int d3, int d4, int d5) {
        return getOccurrenceOf(d1, d2, d3, d4, d5, 6) * 6;
    }

    private static int onePair(int d1, int d2, int d3, int d4, int d5) {
        int[] diceOccurrences = getOccurenceTable(d1, d2, d3, d4, d5);
        for (int i = 0; i < 6; i++)
            if (diceOccurrences[5 - i] >= 2)
                return (6 - i) * 2;
        return 0;
    }

    private static int twoPair(int d1, int d2, int d3, int d4, int d5) {
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

    private static int fourOfAKind(int d1, int d2, int d3, int d4, int d5) {
        int[] diceOccurrences = getOccurenceTable(d1, d2, d3, d4, d5);

        for (int i = 0; i < 6; i++)
            if (diceOccurrences[i] >= 4)
                return (i + 1) * 4;
        return 0;
    }

    private static int threeOfAKind(int d1, int d2, int d3, int d4, int d5) {
        int[] diceOccurrences = getOccurenceTable(d1, d2, d3, d4, d5);

        for (int i = 0; i < 6; i++)
            if (diceOccurrences[i] >= 3)
                return (i + 1) * 3;
        return 0;
    }

    private static int smallStraight(int d1, int d2, int d3, int d4, int d5) {
        int[] diceOccurrences = getOccurenceTable(d1, d2, d3, d4, d5);
        if (diceOccurrences[0] == 1 &&
                diceOccurrences[1] == 1 &&
                diceOccurrences[2] == 1 &&
                diceOccurrences[3] == 1 &&
                diceOccurrences[4] == 1)
            return 15;
        return 0;
    }

    private static int largeStraight(int d1, int d2, int d3, int d4, int d5) {
        int[] diceOccurrences = getOccurenceTable(d1, d2, d3, d4, d5);
        return Arrays.stream(diceOccurrences).filter(d -> d == 1).skip(1).count() == 4 ? 20 : 0;
    }

    private static int fullHouse(int d1, int d2, int d3, int d4, int d5) {
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