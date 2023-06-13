package org.example.domain.input;

import org.example.domain.number.PlayerNumber;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Input {

    Scanner scanner = new Scanner(System.in);

    public List<PlayerNumber> enterAnswerNumber() {

        int inputPlayerAnswerNumbers = scanner.nextInt();

        return createPlayerNumbers(inputPlayerAnswerNumbers);
    }

    private List<PlayerNumber> createPlayerNumbers(int playerAnswerNumbers) {

        List<PlayerNumber> playerNumbers = new ArrayList<>();

        playerNumbers.add(new PlayerNumber(playerAnswerNumbers / 100));
        playerNumbers.add(new PlayerNumber(playerAnswerNumbers / 10 % 10));
        playerNumbers.add(new PlayerNumber(playerAnswerNumbers % 10));

        return playerNumbers;
    }

}
