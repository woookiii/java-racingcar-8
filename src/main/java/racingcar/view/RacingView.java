package racingcar.view;

import racingcar.domain.Car;
import racingcar.factory.RacingStringFactory;

import java.util.List;


public class RacingView {

    RacingStringFactory racingStringFactory = new RacingStringFactory();

    public void printExecuteResultHeader() {
        System.out.println("\n실행 결과");
    }

    public void printRaceResult(List<Car> carList) {
        for (Car car : carList) {
            final StringBuilder bar = new StringBuilder();
            racingStringFactory.makeResultBar(car, bar);
            System.out.format("%s : %s%n", car.getName(), bar);
        }
        System.out.println();
    }

    public void announceWinner(List<Car> raceWinnerInOrder) {
        final StringBuilder winnerString = new StringBuilder();
        racingStringFactory.makeWinnerString(raceWinnerInOrder, winnerString);

        System.out.format("최종 우승자 : %s", winnerString);
    }
}
