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
        Game game = new Game();
        game.playRound(1, 2);

        assertEquals(3, game.getRoundScore(1));
    }

    @Test
    void should_score_10_plus_follow_2_num_when_bowling_round_given_strike() {
        Game game = new Game();
        game.playRound(10);
        game.playRound(10);
        game.playRound(1, 9);

        assertEquals(21, game.getRoundScore(1));
    }

    @Test
    void should_score_10_plus_follow_1_num_when_bowling_round_given_spare() {
        Game game = new Game();
        game.playRound(5, 5);
        game.playRound(5, 1);

        assertEquals(15, game.getRoundScore(1));
    }

    @Test
    void should_final_score_300_when_bowling_game_given_all_strike() {
        Game game = new Game();
        game.playRound(10);
        game.playRound(10);
        game.playRound(10);
        game.playRound(10);
        game.playRound(10);
        game.playRound(10);
        game.playRound(10);
        game.playRound(10);
        game.playRound(10);
        game.playRound(10, 10);

        int score = 0;
        for (int i = 1; i <= 10; i ++) {
            score += game.getRoundScore(i);
        }
        assertEquals(300, score);
    }
}
