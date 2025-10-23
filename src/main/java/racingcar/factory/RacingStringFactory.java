package racingcar.factory;

import racingcar.domain.Car;

import java.util.List;

public class RacingStringFactory {

    public void makeWinnerString(List<Car> raceWinnerInOrder, StringBuilder winnerString) {
        for (Car car : raceWinnerInOrder) {
            winnerString.append(car.getName());
            winnerString.append(", ");
        }
        winnerString.delete(winnerString.length() - 2, winnerString.length());
    }

    public void makeResultBar(Car car, StringBuilder bar) {
        final long currentCarDistance = car.getDistance();
        for (long resultBarCount = 0; resultBarCount < currentCarDistance; resultBarCount++) {
            bar.append("-");
        }
    }
}
