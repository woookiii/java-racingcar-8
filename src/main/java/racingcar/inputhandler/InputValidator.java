package racingcar.inputhandler;

import java.util.List;

public class InputValidator {

    public void validateUserInput(String userInput) {
        if(userInput.isEmpty()) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
    }

    public void validateCarNames(List<String> carNames) {
        if(carNames.isEmpty()) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }

        for (String carName : carNames) {
            validateCarNameLength(carName);
        }
    }

    private void validateCarNameLength(String carName) {
        if(carName.length() <= 5) {
            return;
        } else {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
    }

    public void validateAttemptNumberInput(String userInput) {
        final boolean isNumeric = userInput.chars().allMatch(Character::isDigit);

        if(!isNumeric) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
    }
}
