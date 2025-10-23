package racingcar.handler;

import java.util.List;

public class CarNameParser {
    public List<String> parseCarNames(String userInput) {
        final List<String> carNamesInOrder = List.of(userInput.split(","));

        return carNamesInOrder;
    }
}
