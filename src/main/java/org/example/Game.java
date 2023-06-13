package org.example;

import org.example.domain.Player.Player;
import org.example.domain.input.Input;
import org.example.domain.number.AnswerNumber;
import org.example.domain.number.PlayerNumber;
import org.example.domain.output.Output;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Game {

    private Player player = new Player();
    private Output output = new Output();
    private Input input = new Input();
    private Random random = new Random();

    public void startGame() {

        List<AnswerNumber> answerNumbers = createAnswerNumbers(); // 3, 1, 6
        output.printFirstEnterNumberGuide();

        printAnswerNumber(answerNumbers);

        while (true) {

            player.increaseAttemptCount(); // 시도횟수 증가
            output.printEnterAnswerNumberGuide(player.getAttemptCount());
            List<PlayerNumber> playerNumbers = input.enterAnswerNumber();

            int strikeCount = countingStrikeCount(answerNumbers, playerNumbers);
            int ballCount = countingBallCount(answerNumbers, playerNumbers) - strikeCount;

            System.out.println(ballCount + "B" + strikeCount + "S");

            if (strikeCount == 3) {
                System.out.println(player.getAttemptCount() + "번만에 맞히셨습니다.");
                System.out.println("게임을 종료합니다.");
                break;
            }
        }


    }

    private static void printAnswerNumber(List<AnswerNumber> answerNumbers) {
        System.out.println("answerNumbers.get(0).getAnswerNumber() = " + answerNumbers.get(0).getAnswerNumber());
        System.out.println("answerNumbers.get(1).getAnswerNumber() = " + answerNumbers.get(1).getAnswerNumber());
        System.out.println("answerNumbers.get(2).getAnswerNumber() = " + answerNumbers.get(2).getAnswerNumber());
    }

    private int countingBallCount(List<AnswerNumber> answerNumbers, List<PlayerNumber> playerNumbers) {
        int count = 0;
        List<Integer> list = answerNumbers.stream()
                .map(AnswerNumber::getAnswerNumber)
                .collect(Collectors.toList());

        for (int i = 0; i < 3; i++) {
            if (list.contains(playerNumbers.get(i).getPlayerNumber())) {
                count++;
            }
        }

        return count;
    }

    private int countingStrikeCount(List<AnswerNumber> answerNumbers, List<PlayerNumber> playerNumbers) {
        int count = 0;

        for (int i = 0; i < 3; i++) {
            if (answerNumbers.get(i).getAnswerNumber() == playerNumbers.get(i).getPlayerNumber()) {
                count++;
            }
        }

        return count;
    }

    private List<AnswerNumber> createAnswerNumbers() {

        List<AnswerNumber> answerNumberList = new ArrayList<>();

        while (answerNumberList.size() != 3) {
            int answerNumber = random.nextInt(9) + 1;

            validateDuplicateAnswerNumber(answerNumberList, answerNumber);
        }

        return answerNumberList;
    }

    private static void validateDuplicateAnswerNumber(List<AnswerNumber> answerNumberList, int answerNumber) {
        if (isNotContainsAnswerNumber(answerNumberList, answerNumber)) {
            answerNumberList.add(new AnswerNumber(answerNumber));
        }
    }

    private static boolean isNotContainsAnswerNumber(List<AnswerNumber> answerNumberList, int answerNumber) {
        List<Integer> list = answerNumberList.stream()
                .map(AnswerNumber::getAnswerNumber)
                .collect(Collectors.toList());

        return !list.contains(answerNumber);
    }

}
