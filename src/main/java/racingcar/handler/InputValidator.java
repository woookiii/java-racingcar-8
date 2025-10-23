package racingcar.handler;

import java.util.List;

public class InputValidator {

    public String validateUserInput(String userInput) {
        if(userInput.isEmpty()) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
        return userInput;
    }


    public List<String> validateCarNames(List<String> carNames) {
        if(carNames.isEmpty()) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }

        for (String carName : carNames) {
            if(carName.length() <= 5) {
                continue;
            } else {
                throw new IllegalArgumentException("잘못된 입력입니다.");
            }
        }

        return carNames;
    }

    public String validateAttemptNumberInput(String userInput) {
        final boolean isNumeric = userInput.chars().allMatch(Character::isDigit);

        if(!isNumeric) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }

        return userInput;
    }
}
