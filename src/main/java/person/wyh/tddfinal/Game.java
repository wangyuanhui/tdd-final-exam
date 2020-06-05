package person.wyh.tddfinal;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private List<List<Integer>> rounds;

    public Game() {
        rounds = new ArrayList<>();
    }

    public void playRound(int strike) {
        rounds.add(List.of(strike));
    }

    public void playRound(int first, int second) {
        rounds.add(List.of(first, second));
    }

    public void playRound(int first, int second, int third) {
        rounds.add(List.of(first, second, third));
    }

    public int getRoundScore(int round) {
        int index = round - 1;
        List<Integer> r = rounds.get(index);
        if (isStrike(r)) {
            return sum(r) + getNext2Num(index);
        } else if (isSpare(r)) {
            return sum(r) + getNextNum(index);
        } else {
            return sum(r);
        }
    }

    private int getNextNum(int index) {
        if (rounds.get(index).size() > 1) {
            return rounds.get(index).get(1);
        }
        if (index + 1 < rounds.size()) {
            return rounds.get(index + 1).get(0);
        }
        return 0;
    }

    private int getNext2Num(int index) {
        List<Integer> nums = new ArrayList();
        if (rounds.get(index).size() > 1) {
            nums.add(rounds.get(index).get(1));
        }
        if (index + 1 < rounds.size()) {
            nums.add(rounds.get(index + 1).get(0));
            if (rounds.get(index + 1).size() > 1) {
                nums.add(rounds.get(index + 1).get(1));
            } else if (index + 2 < rounds.size()) {
                nums.add(rounds.get(index + 2).get(0));
            }
        }
        if (nums.size() == 3) {
            nums.remove(2);
        }
        return sum(nums);
    }

    private boolean isStrike(List<Integer> round) {
        return round.get(0) == 10;
    }

    private boolean isSpare(List<Integer> round) {
        return !isStrike(round) && (round.get(0) + round.get(1) == 10);
    }

    private int sum(List<Integer> round) {
        int sum = 0;
        for (Integer integer : round) {
            sum += integer;
        }
        return sum;
    }
}
