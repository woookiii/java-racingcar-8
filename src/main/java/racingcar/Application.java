package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        List<String> carNamesInOrder = validateCarNamesLength(parseCarNames(validateUserInput(Console.readLine())));

        System.out.println("시도할 횟수는 몇 회인가요?");
        long attemptNumber = Long.parseLong(validateAttemptNumberInput(validateUserInput(Console.readLine())));
        Console.close();


    }

    private static String validateUserInput(String userInput) {
        if(userInput.isEmpty()) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
        return userInput;
    }

    private static String validateAttemptNumberInput(String userInput) {
        boolean isNumeric = userInput.chars().allMatch(Character::isDigit);

        if(!isNumeric) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }

        return userInput;
    }

    private static List<String> parseCarNames(String userInput) {
        List<String> carNamesInOrder = List.of(userInput.split(","));

        return carNamesInOrder;
    }

    private static List<String> validateCarNamesLength(List<String> carNames) {
        for (String carName : carNames) {
            if(carName.length() <= 5) {
                continue;
            } else {
                throw new IllegalArgumentException("잘못된 입력입니다.");
            }
        }

        return carNames;
    }

}
