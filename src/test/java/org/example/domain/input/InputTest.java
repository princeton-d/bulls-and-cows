package org.example.domain.input;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class InputTest {

    private ByteArrayOutputStream outputStreamCaptor;
    private PrintStream standardOut;

    protected void systemIn(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }

    @BeforeEach
    void setUp() {
        standardOut = System.out;
        outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    protected void printResult() {
        System.setOut(standardOut);
        System.out.println(getOutput());
    }

    protected String getOutput() {
        return outputStreamCaptor.toString();
    }

    @Test
    public void enterAnswerNumberTest() throws Exception {
        //given
//        systemIn("안녕");
        Input input = new Input();

        //when
//        test();

        //then
//        assertThat(getOutput()).contains("안녕");
    }

    void test() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(scanner.nextLine());
    }

}