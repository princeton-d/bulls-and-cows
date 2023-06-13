package org.example.domain.output;

public class Output {

    private final String FIRST_GUIDE_WORD = "컴퓨터가 숫자를 생성하였습니다. 답을 맞춰보세요!";
    private final String ENTER_ANSWER_GUIDE_WORD = "번째 시도 : ";

    public void printFirstEnterNumberGuide() {
        System.out.println(FIRST_GUIDE_WORD);
    }

    public void printEnterAnswerNumberGuide(int attemptCount) {
        String guideWord = attemptCount + ENTER_ANSWER_GUIDE_WORD;

        System.out.print(guideWord);
    }
}
