import model.Dice;
import org.junit.Test;
import util.YatzyUtility;

import static model.Category.*;
import static model.Dice.*;
import static org.junit.Assert.assertEquals;


public class YatzyTest {

    @Test
    public void chance_should_scores_sum_of_all_dice() {
        assertEquals(15, YatzyUtility.getScore(new Dice[]{TWO, THREE, FOUR, FIVE, ONE}, CHANCE));
        assertEquals(16, YatzyUtility.getScore(new Dice[]{THREE, THREE, FOUR, FIVE, ONE}, CHANCE));
    }

    @Test
    public void yatzy_should_scores_50_case_all_the_same() {
        assertEquals(50, YatzyUtility.getScore(new Dice[]{FOUR, FOUR, FOUR, FOUR, FOUR}, YAHTZEE));
        assertEquals(50, YatzyUtility.getScore(new Dice[]{SIX, SIX, SIX, SIX, SIX}, YAHTZEE));
    }

    @Test
    public void yatzy_should_scores_0_case_not_all_the_same() {
        assertEquals(0, YatzyUtility.getScore(new Dice[]{SIX, SIX, SIX, SIX, THREE}, YAHTZEE));
    }


    @Test
    public void ones_should_scores_sum_of_ones() {
        assertEquals(1, YatzyUtility.getScore(new Dice[]{ONE, TWO, THREE, FOUR, FIVE}, ONES));
        assertEquals(2, YatzyUtility.getScore(new Dice[]{ONE, TWO, ONE, FOUR, FIVE}, ONES));
        assertEquals(0, YatzyUtility.getScore(new Dice[]{SIX, TWO, TWO, FOUR, FIVE}, ONES));
        assertEquals(4, YatzyUtility.getScore(new Dice[]{ONE, TWO, ONE, ONE, ONE}, ONES));
    }


    @Test
    public void twos_should_scores_sum_of_tows() {
        assertEquals(4, YatzyUtility.getScore(new Dice[]{ONE, TWO, THREE, TWO, SIX}, TWOS));
        assertEquals(10, YatzyUtility.getScore(new Dice[]{TWO, TWO, TWO, TWO, TWO}, TWOS));
    }

    @Test
    public void threes_should_scores_sum_of_threes() {
        assertEquals(6, YatzyUtility.getScore(new Dice[]{ONE, TWO, THREE, TWO, THREE}, THREES));
        assertEquals(12, YatzyUtility.getScore(new Dice[]{TWO, THREE, THREE, THREE, THREE}, THREES));
    }

    @Test
    public void fours_should_scores_sum_of_fours() {
        assertEquals(12, YatzyUtility.getScore(new Dice[]{FOUR, FOUR, FOUR, FIVE, FIVE}, FOURS));
        assertEquals(8, YatzyUtility.getScore(new Dice[]{FOUR, FOUR, FIVE, FIVE, FIVE}, FOURS));
        assertEquals(4, YatzyUtility.getScore(new Dice[]{FOUR, FIVE, FIVE, FIVE, FIVE}, FOURS));
    }

    @Test
    public void fives_should_scores_sum_of_fives() {
        assertEquals(10, YatzyUtility.getScore(new Dice[]{FOUR, FOUR, FOUR, FIVE, FIVE}, FIVES));
        assertEquals(15, YatzyUtility.getScore(new Dice[]{FOUR, FOUR, FIVE, FIVE, FIVE}, FIVES));
        assertEquals(20, YatzyUtility.getScore(new Dice[]{FOUR, FIVE, FIVE, FIVE, FIVE}, FIVES));
    }

    @Test
    public void sixes_should_scores_sum_of_sixes() {
        assertEquals(0, YatzyUtility.getScore(new Dice[]{FOUR, FOUR, FOUR, FIVE, FIVE}, SIXES));
        assertEquals(6, YatzyUtility.getScore(new Dice[]{FOUR, FOUR, SIX, FIVE, FIVE}, SIXES));
        assertEquals(18, YatzyUtility.getScore(new Dice[]{SIX, FIVE, SIX, SIX, FIVE}, SIXES));
    }

    @Test
    public void onePair_should_scores_sum_of_pair() {
        assertEquals(6, YatzyUtility.getScore(new Dice[]{THREE, FOUR, THREE, FIVE, SIX}, ONE_PAIR));
    }

    @Test
    public void onePair_should_scores_sum_of_pair_case_two_pair_founded() {
        assertEquals(10, YatzyUtility.getScore(new Dice[]{FIVE, THREE, THREE, THREE, FIVE}, ONE_PAIR));
        assertEquals(12, YatzyUtility.getScore(new Dice[]{FIVE, THREE, SIX, SIX, FIVE}, ONE_PAIR));
    }

    @Test
    public void twoPair_should_scores_sum_of_two_pair() {
        assertEquals(16, YatzyUtility.getScore(new Dice[]{THREE, THREE, FIVE, FOUR, FIVE}, TWO_PAIR));
        assertEquals(16, YatzyUtility.getScore(new Dice[]{THREE, THREE, FIVE, FIVE, FIVE}, TWO_PAIR));
    }

    @Test
    public void threeOfAKind_should_scores_sum_of_the_same_kind() {
        assertEquals(9, YatzyUtility.getScore(new Dice[]{THREE, THREE, THREE, FOUR, FIVE}, THREE_OF_A_KIND));
        assertEquals(15, YatzyUtility.getScore(new Dice[]{FIVE, THREE, FIVE, FOUR, FIVE}, THREE_OF_A_KIND));
        assertEquals(9, YatzyUtility.getScore(new Dice[]{THREE, THREE, THREE, THREE, FIVE}, THREE_OF_A_KIND));
    }

    @Test
    public void fourOfAKind_should_scores_sum_of_the_same_kind() {
        assertEquals(12, YatzyUtility.getScore(new Dice[]{THREE, THREE, THREE, THREE, FIVE}, FOUR_OF_A_KIND));
        assertEquals(20, YatzyUtility.getScore(new Dice[]{FIVE, FIVE, FIVE, FOUR, FIVE}, FOUR_OF_A_KIND));
    }

    @Test
    public void smallStraight_should_scores_sum_of_the_4_sequential_starting_from_1_case_4_sequential_found() {
        assertEquals(15, YatzyUtility.getScore(new Dice[]{ONE, TWO, THREE, FOUR, FIVE}, SMALL_STRAIGHT));
        assertEquals(15, YatzyUtility.getScore(new Dice[]{TWO, THREE, FOUR, FIVE, ONE}, SMALL_STRAIGHT));
    }

    @Test
    public void smallStraight_should_scores_0_case_4_sequential_starting_from_1_not_found() {
        assertEquals(0, YatzyUtility.getScore(new Dice[]{ONE, TWO, TWO, FOUR, FIVE}, SMALL_STRAIGHT));
    }

    @Test
    public void largeStraight_should_scores_sum_of_the_4_sequential_starting_from_2_case_4_sequential_found() {
        assertEquals(20, YatzyUtility.getScore(new Dice[]{SIX, TWO, THREE, FOUR, FIVE}, LARGE_STRAIGHT));
        assertEquals(20, YatzyUtility.getScore(new Dice[]{TWO, THREE, FOUR, FIVE, SIX}, LARGE_STRAIGHT));
    }

    @Test
    public void largeStraight_should_scores_0_case_4_sequential_starting_from_1_not_found() {
        assertEquals(0, YatzyUtility.getScore(new Dice[]{ONE, TWO, TWO, FOUR, FIVE}, LARGE_STRAIGHT));
    }

    @Test
    public void fullHouse_should_scores_sum_case_twoKind_and_threeKind() {
        assertEquals(18, YatzyUtility.getScore(new Dice[]{SIX, TWO, TWO, TWO, SIX}, FULL_HOUSE));
    }

    @Test
    public void fullHouse_should_scores_0_case_not_twoKind_and_threeKind() {
        assertEquals(0, YatzyUtility.getScore(new Dice[]{TWO, THREE, FOUR, FIVE, SIX}, FULL_HOUSE));
    }
}