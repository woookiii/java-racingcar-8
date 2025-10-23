package racingcar.runner;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Car;
import racingcar.factory.CarListFactory;
import racingcar.inputhandler.CarNameParser;
import racingcar.inputhandler.InputValidator;
import racingcar.service.RacingService;
import racingcar.view.GuideView;
import racingcar.view.RacingView;

import java.util.List;

public class RacingCarRunner {

    private final GuideView guideView = new GuideView();
    private final InputValidator inputValidator = new InputValidator();
    private final CarNameParser carNameParser = new CarNameParser();
    private final RacingService racingService = new RacingService();
    private final RacingView racingView = new RacingView();
    private final CarListFactory carListFactory = new CarListFactory();
    
    public void run() {
        guideView.guideCarName();
        String carInput = Console.readLine();
        inputValidator.validateUserInput(carInput);
        final List<String> carNamesInOrder = carNameParser.parseCarNames(carInput);
        inputValidator.validateCarNames(carNamesInOrder);

        guideView.guideAttemptNumber();
        String attemptNumberInput = Console.readLine();
        inputValidator.validateUserInput(attemptNumberInput);
        inputValidator.validateAttemptNumberInput(attemptNumberInput);
        final long attemptNumber = Long.parseLong(attemptNumberInput);
        Console.close();

        final List<Car> carList = carListFactory.buildCarList(carNamesInOrder);

        racingView.printExecuteResultHeader();
        racingService.executeRacing(attemptNumber, carList);

        final List<Car> racingWinnerInOrder = racingService.findRacingWinner(carList);

        racingView.announceWinner(racingWinnerInOrder);
    }

}
