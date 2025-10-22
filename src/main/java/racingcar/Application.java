package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        final List<String> carNamesInOrder = validateCarNamesLength(parseCarNames(validateUserInput(Console.readLine())));

        System.out.println("시도할 횟수는 몇 회인가요?");
        final long attemptNumber = Long.parseLong(validateAttemptNumberInput(validateUserInput(Console.readLine())));
        Console.close();

        final Map<String, Long> raceResult = carNamesInOrder.stream()
                .collect(Collectors.toMap(car -> car, car -> 0L));

        for (long attemptCurrentCount = 0; attemptCurrentCount < attemptNumber; attemptCurrentCount++) {
            attemptMoveForwardAllCars(raceResult);
        }

    }

    private static void attemptMoveForwardAllCars(Map<String, Long> raceResult) {
        raceResult.keySet().forEach(car -> attemptMoveForwardOneCar(raceResult, car));
    }

    private static void attemptMoveForwardOneCar(Map<String, Long> raceResult, String car) {
        if(Randoms.pickNumberInRange(1, 8) >= 4){
            raceResult.put(car, raceResult.get(car) + 1);
        }
    }

    private static String validateUserInput(String userInput) {
        if(userInput.isEmpty()) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
        return userInput;
    }

    private static String validateAttemptNumberInput(String userInput) {
        final boolean isNumeric = userInput.chars().allMatch(Character::isDigit);

        if(!isNumeric) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }

        return userInput;
    }

    private static List<String> parseCarNames(String userInput) {
        final List<String> carNamesInOrder = List.of(userInput.split(","));

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
