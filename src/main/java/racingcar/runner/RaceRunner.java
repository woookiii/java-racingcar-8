package racingcar.runner;

import camp.nextstep.edu.missionutils.Console;
import racingcar.handler.CarNameParser;
import racingcar.handler.InputValidator;
import racingcar.service.RaceService;
import racingcar.view.RaceView;

import java.util.List;
import java.util.stream.Collectors;

public class RaceRunner {
    private final RaceView raceView = new RaceView();
    private final RaceService raceService = new RaceService();
    private final CarNameParser carNameParser = new CarNameParser();
    private final InputValidator inputValidator = new InputValidator();

    public void run() {

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        final List<String> carNamesInOrder = inputValidator.validateCarNames(
                carNameParser.parseCarNames(inputValidator.validateUserInput(Console.readLine())));

        System.out.println("시도할 횟수는 몇 회인가요?");
        final long attemptNumber = Long.parseLong(inputValidator.validateAttemptNumberInput(inputValidator.validateUserInput(Console.readLine())));
        Console.close();

        final List<Long> raceResult = carNamesInOrder.stream()
                .map(car -> 0L)
                .collect(Collectors.toList());

        System.out.println("\n실행 결과");
        for (long attemptCurrentCount = 0; attemptCurrentCount < attemptNumber; attemptCurrentCount++) {
            raceService.attemptMoveForwardAllCars(raceResult);

            raceView.printRaceResult(carNamesInOrder, raceResult);
        }

        List<String> raceWinnerInOrder = raceService.findRaceWinner(carNamesInOrder, raceResult);

        raceView.announceWinner(raceWinnerInOrder);
    }
}
