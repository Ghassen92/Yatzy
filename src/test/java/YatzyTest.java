import org.junit.Test;
import util.Yatzy;

import static org.junit.Assert.assertEquals;
import static util.Category.*;

public class YatzyTest {

    @Test
    public void chance_should_scores_sum_of_all_dice() {
        assertEquals(15, Yatzy.getScore(2, 3, 4, 5, 1, CHANCE));
        assertEquals(16, Yatzy.getScore(3, 3, 4, 5, 1, CHANCE));
    }

    @Test
    public void yatzy_should_scores_50_case_all_the_same() {
        assertEquals(50, Yatzy.getScore(4, 4, 4, 4, 4, YAHTZEE));
        assertEquals(50, Yatzy.getScore(6, 6, 6, 6, 6, YAHTZEE));
    }

    @Test
    public void yatzy_should_scores_0_case_not_all_the_same() {
        assertEquals(0, Yatzy.getScore(6, 6, 6, 6, 3, YAHTZEE));
    }


    @Test
    public void ones_should_scores_sum_of_ones() {
        assertEquals(1, Yatzy.getScore(1, 2, 3, 4, 5, ONES));
        assertEquals(2, Yatzy.getScore(1, 2, 1, 4, 5, ONES));
        assertEquals(0, Yatzy.getScore(6, 2, 2, 4, 5, ONES));
        assertEquals(4, Yatzy.getScore(1, 2, 1, 1, 1, ONES));
    }


    @Test
    public void twos_should_scores_sum_of_tows() {
        assertEquals(4, Yatzy.getScore(1, 2, 3, 2, 6, TWOS));
        assertEquals(10, Yatzy.getScore(2, 2, 2, 2, 2, TWOS));
    }

    @Test
    public void threes_should_scores_sum_of_threes() {
        assertEquals(6, Yatzy.getScore(1, 2, 3, 2, 3, THREES));
        assertEquals(12, Yatzy.getScore(2, 3, 3, 3, 3, THREES));
    }

    @Test
    public void fours_should_scores_sum_of_fours() {
        assertEquals(12, Yatzy.getScore(4, 4, 4, 5, 5, FOURS));
        assertEquals(8, Yatzy.getScore(4, 4, 5, 5, 5, FOURS));
        assertEquals(4, Yatzy.getScore(4, 5, 5, 5, 5, FOURS));
    }

    @Test
    public void fives_should_scores_sum_of_fives() {
        assertEquals(10, Yatzy.getScore(4, 4, 4, 5, 5, FIVES));
        assertEquals(15, Yatzy.getScore(4, 4, 5, 5, 5, FIVES));
        assertEquals(20, Yatzy.getScore(4, 5, 5, 5, 5, FIVES));
    }

    @Test
    public void sixes_should_scores_sum_of_sixes() {
        assertEquals(0, Yatzy.getScore(4, 4, 4, 5, 5, SIXES));
        assertEquals(6, Yatzy.getScore(4, 4, 6, 5, 5, SIXES));
        assertEquals(18, Yatzy.getScore(6, 5, 6, 6, 5, SIXES));
    }

    @Test
    public void onePair_should_scores_sum_of_pair() {
        assertEquals(6, Yatzy.getScore(3, 4, 3, 5, 6, ONE_PAIR));
    }

    @Test
    public void onePair_should_scores_sum_of_pair_case_two_pair_founded() {
        assertEquals(10, Yatzy.getScore(5, 3, 3, 3, 5, ONE_PAIR));
        assertEquals(12, Yatzy.getScore(5, 3, 6, 6, 5, ONE_PAIR));
    }

    @Test
    public void twoPair_should_scores_sum_of_two_pair() {
        assertEquals(16, Yatzy.getScore(3, 3, 5, 4, 5, TWO_PAIR));
        assertEquals(16, Yatzy.getScore(3, 3, 5, 5, 5, TWO_PAIR));
    }

    @Test
    public void threeOfAKind_should_scores_sum_of_the_same_kind() {
        assertEquals(9, Yatzy.getScore(3, 3, 3, 4, 5, THREE_OF_A_KIND));
        assertEquals(15, Yatzy.getScore(5, 3, 5, 4, 5, THREE_OF_A_KIND));
        assertEquals(9, Yatzy.getScore(3, 3, 3, 3, 5, THREE_OF_A_KIND));
    }

    @Test
    public void fourOfAKind_should_scores_sum_of_the_same_kind() {
        assertEquals(12, Yatzy.getScore(3, 3, 3, 3, 5, FOUR_OF_A_KIND));
        assertEquals(20, Yatzy.getScore(5, 5, 5, 4, 5, FOUR_OF_A_KIND));
    }

    @Test
    public void smallStraight_should_scores_sum_of_the_4_sequential_dice_starting_from_1_case_4_sequential_dice_found() {
        assertEquals(15, Yatzy.getScore(1, 2, 3, 4, 5, SMALL_STRAIGHT));
        assertEquals(15, Yatzy.getScore(2, 3, 4, 5, 1, SMALL_STRAIGHT));
    }

    @Test
    public void smallStraight_should_scores_0_case_4_sequential_dice_starting_from_1_not_found() {
        assertEquals(0, Yatzy.getScore(1, 2, 2, 4, 5, SMALL_STRAIGHT));
    }

    @Test
    public void largeStraight_should_scores_sum_of_the_4_sequential_dice_starting_from_2_case_4_sequential_dice_found() {
        assertEquals(20, Yatzy.getScore(6, 2, 3, 4, 5, LARGE_STRAIGHT));
        assertEquals(20, Yatzy.getScore(2, 3, 4, 5, 6, LARGE_STRAIGHT));
    }

    @Test
    public void largeStraight_should_scores_0_case_4_sequential_dice_starting_from_1_not_found() {
        assertEquals(0, Yatzy.getScore(1, 2, 2, 4, 5, LARGE_STRAIGHT));
    }

    @Test
    public void fullHouse_should_scores_sum_case_twoKind_and_threeKind() {
        assertEquals(18, Yatzy.getScore(6, 2, 2, 2, 6, FULL_HOUSE));
    }

    @Test
    public void fullHouse_should_scores_0_case_not_twoKind_and_threeKind() {
        assertEquals(0, Yatzy.getScore(2, 3, 4, 5, 6, FULL_HOUSE));
    }
}