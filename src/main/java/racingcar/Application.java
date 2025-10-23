package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        final List<String> carNamesInOrder = validateCarNames(parseCarNames(validateUserInput(Console.readLine())));

        System.out.println("시도할 횟수는 몇 회인가요?");
        final long attemptNumber = Long.parseLong(validateAttemptNumberInput(validateUserInput(Console.readLine())));
        Console.close();

        final List<Long> raceResult = carNamesInOrder.stream()
                .map(car -> 0L)
                .collect(Collectors.toList());

        System.out.println("\n실행 결과");
        for (long attemptCurrentCount = 0; attemptCurrentCount < attemptNumber; attemptCurrentCount++) {
            attemptMoveForwardAllCars(raceResult);

            printRaceResult(carNamesInOrder, raceResult);
        }

        List<String> raceWinnerInOrder = findRaceWinner(carNamesInOrder, raceResult);

        announceWinner(raceWinnerInOrder);
    }

    private static void announceWinner(List<String> raceWinnerInOrder) {
        final StringBuilder winnerString = new StringBuilder();
        makeWinnerString(raceWinnerInOrder, winnerString);

        System.out.format("최종 우승자 : %s", winnerString);
    }

    private static void makeWinnerString(List<String> raceWinnerInOrder, StringBuilder winnerString) {
        for (String car : raceWinnerInOrder) {
            winnerString.append(car);
            winnerString.append(", ");
        }
        winnerString.delete(winnerString.length() - 2, winnerString.length());
    }

    private static List<String> findRaceWinner(List<String> carNamesInOrder, List<Long> raceResult) {
        final long maxDistance = raceResult.stream().max(Long::compare).orElse(0L);
        List<String> winnerInOrder = new ArrayList<>();
        for (int currentCarIndex = 0; currentCarIndex < raceResult.size(); currentCarIndex++) {
            if(raceResult.get(currentCarIndex) == maxDistance){
                winnerInOrder.add(carNamesInOrder.get(currentCarIndex));
            }
        }
        return winnerInOrder;
    }

    private static void printRaceResult(List<String> carNamesInOrder, List<Long> raceResult) {
        for (int currentCarIndex = 0; currentCarIndex < raceResult.size(); currentCarIndex++) {
            final StringBuilder bar = new StringBuilder();
            makeResultBar(raceResult, currentCarIndex, bar);
            System.out.format("%s : %s%n", carNamesInOrder.get(currentCarIndex), bar);
        }
        System.out.println();
    }

    private static void makeResultBar(List<Long> raceResult, int currentCarIndex, StringBuilder bar) {
        long currentCarDistance = raceResult.get(currentCarIndex);
        for (long resultBarCount = 0; resultBarCount < currentCarDistance; resultBarCount++) {
            bar.append("-");
        }
    }

    private static void attemptMoveForwardAllCars(List<Long> raceResult) {
        for (int currentCarIndex = 0; currentCarIndex < raceResult.size(); currentCarIndex++) {
            attemptMoveForwardOneCar(raceResult, currentCarIndex);
        }
    }

    private static void attemptMoveForwardOneCar(List<Long> raceResult, int currentCarIndex) {
        if(Randoms.pickNumberInRange(1, 8) >= 4){
            raceResult.set(currentCarIndex, raceResult.get(currentCarIndex) + 1);
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

    private static List<String> validateCarNames(List<String> carNames) {
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

}
