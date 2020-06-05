package person.wyh.tddfinal;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BowlingTest {

    @Test
    void should_score_0_when_bowling_round_given_two_throws_break_down_0() {
        Game game = new Game();
        game.playRound(0, 0);

        assertEquals(0, game.getRoundScore(1));
    }

    @Test
    void should_score_that_number_when_bowling_round_given_two_throws_break_down_number_less_10() {

    }

    @Test
    void should_score_10_plus_follow_2_num_when_bowling_round_given_strike() {

    }

    @Test
    void should_score_10_plus_follow_1_num_when_bowling_round_given_spare() {

    }

    @Test
    void should_final_score_300_when_bowling_game_given_all_strike() {

    }
}
