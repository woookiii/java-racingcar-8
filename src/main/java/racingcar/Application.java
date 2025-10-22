package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<String> cars = guideCarNamesInput();

        System.out.println("시도할 횟수는 몇 회인가요?");
        long attemptNumber = Long.parseLong(validateAttemptNumberInput(getAttemptNumberInput()));


    }

    private static String getAttemptNumberInput() {
        String userInput = Console.readLine();
        Console.close();

        return userInput;
    }

    private static String validateAttemptNumberInput(String userInput) {
        boolean isNumeric = userInput.chars().allMatch(Character::isDigit);

        if(!isNumeric || userInput.isEmpty()) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }

        return userInput;
    }

    private static List<String> guideCarNamesInput() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        List<String> cars = List.of(Console.readLine().split(","));
        Console.close();

        return cars;
    }
}
