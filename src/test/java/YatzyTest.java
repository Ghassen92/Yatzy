import org.junit.Test;
import util.Yatzy;

import static org.junit.Assert.assertEquals;

public class YatzyTest {

    @Test
    public void chance_should_scores_sum_of_all_dice() {
        assertEquals(15, Yatzy.chance(2, 3, 4, 5, 1));
        assertEquals(16, Yatzy.chance(3, 3, 4, 5, 1));
    }

    @Test
    public void yatzy_should_scores_50_case_all_the_same() {
        assertEquals(50, Yatzy.yatzy(4, 4, 4, 4, 4));
        assertEquals(50, Yatzy.yatzy(6, 6, 6, 6, 6));
    }

    @Test
    public void yatzy_should_scores_0_case_not_all_the_same() {
        assertEquals(0, Yatzy.yatzy(6, 6, 6, 6, 3));
    }


    @Test
    public void ones_should_scores_sum_of_ones() {
        assertEquals(1, Yatzy.ones(1, 2, 3, 4, 5));
        assertEquals(2, Yatzy.ones(1, 2, 1, 4, 5));
        assertEquals(0, Yatzy.ones(6, 2, 2, 4, 5));
        assertEquals(4, Yatzy.ones(1, 2, 1, 1, 1));
    }


    @Test
    public void twos_should_scores_sum_of_tows() {
        assertEquals(4, Yatzy.twos(1, 2, 3, 2, 6));
        assertEquals(10, Yatzy.twos(2, 2, 2, 2, 2));
    }

    @Test
    public void threes_should_scores_sum_of_threes() {
        assertEquals(6, Yatzy.threes(1, 2, 3, 2, 3));
        assertEquals(12, Yatzy.threes(2, 3, 3, 3, 3));
    }

    @Test
    public void fours_should_scores_sum_of_fours() {
        assertEquals(12, Yatzy.fours(4, 4, 4, 5, 5));
        assertEquals(8, Yatzy.fours(4, 4, 5, 5, 5));
        assertEquals(4, Yatzy.fours(4, 5, 5, 5, 5));
    }

    @Test
    public void fives_should_scores_sum_of_fives() {
        assertEquals(10, Yatzy.fives(4, 4, 4, 5, 5));
        assertEquals(15, Yatzy.fives(4, 4, 5, 5, 5));
        assertEquals(20, Yatzy.fives(4, 5, 5, 5, 5));
    }

    @Test
    public void sixes_should_scores_sum_of_sixes() {
        assertEquals(0, Yatzy.sixes(4, 4, 4, 5, 5));
        assertEquals(6, Yatzy.sixes(4, 4, 6, 5, 5));
        assertEquals(18, Yatzy.sixes(6, 5, 6, 6, 5));
    }

    @Test
    public void onePair_should_scores_sum_of_pair() {
        assertEquals(6, Yatzy.onePair(3, 4, 3, 5, 6));
    }

    @Test
    public void onePair_should_scores_sum_of_pair_case_two_pair_founded() {
        assertEquals(10, Yatzy.onePair(5, 3, 3, 3, 5));
        assertEquals(12, Yatzy.onePair(5, 3, 6, 6, 5));
    }

    @Test
    public void twoPair_should_scores_sum_of_two_pair() {
        assertEquals(16, Yatzy.twoPair(3, 3, 5, 4, 5));
        assertEquals(16, Yatzy.twoPair(3, 3, 5, 5, 5));
    }

    @Test
    public void threeOfAKind_should_scores_sum_of_the_same_kind() {
        assertEquals(9, Yatzy.threeOfAKind(3, 3, 3, 4, 5));
        assertEquals(15, Yatzy.threeOfAKind(5, 3, 5, 4, 5));
        assertEquals(9, Yatzy.threeOfAKind(3, 3, 3, 3, 5));
    }

    @Test
    public void fourOfAKind_should_scores_sum_of_the_same_kind() {
        assertEquals(12, Yatzy.fourOfAKind(3, 3, 3, 3, 5));
        assertEquals(20, Yatzy.fourOfAKind(5, 5, 5, 4, 5));
    }

    @Test
    public void smallStraight_should_scores_sum_of_the_4_sequential_dice_starting_from_1_case_4_sequential_dice_found() {
        assertEquals(15, Yatzy.smallStraight(1, 2, 3, 4, 5));
        assertEquals(15, Yatzy.smallStraight(2, 3, 4, 5, 1));
    }

    @Test
    public void smallStraight_should_scores_0_case_4_sequential_dice_starting_from_1_not_found() {
        assertEquals(0, Yatzy.smallStraight(1, 2, 2, 4, 5));
    }

    @Test
    public void largeStraight_should_scores_sum_of_the_4_sequential_dice_starting_from_2_case_4_sequential_dice_found() {
        assertEquals(20, Yatzy.largeStraight(6, 2, 3, 4, 5));
        assertEquals(20, Yatzy.largeStraight(2, 3, 4, 5, 6));
    }

    @Test
    public void largeStraight_should_scores_0_case_4_sequential_dice_starting_from_1_not_found() {
        assertEquals(0, Yatzy.largeStraight(1, 2, 2, 4, 5));
    }

    @Test
    public void fullHouse_should_scores_sum_case_twoKind_and_threeKind() {
        assertEquals(18, Yatzy.fullHouse(6, 2, 2, 2, 6));
    }

    @Test
    public void fullHouse_should_scores_0_case_not_twoKind_and_threeKind() {
        assertEquals(0, Yatzy.fullHouse(2, 3, 4, 5, 6));
    }
}