package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<String> cars = guideCarNamesInput();

        long attemptNumber = guideAttemptNumberInput();


    }

    private static long guideAttemptNumberInput() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String userInput = Console.readLine();
        Console.close();


        return Long.parseLong(userInput);
    }


    private static List<String> guideCarNamesInput() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        List<String> cars = List.of(Console.readLine().split(","));
        Console.close();
        return cars;
    }
}
