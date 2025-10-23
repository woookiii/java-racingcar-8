package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;
import racingcar.view.RacingView;

import java.util.ArrayList;
import java.util.List;

public class RacingService {

    private final RacingView racingView = new RacingView();

    public List<Car> findRacingWinner(List<Car> carList) {
        final long maxDistance = carList.stream().mapToLong(Car::getDistance).max().orElse(0L);
        final List<Car> winnerInOrder = new ArrayList<>();
        for (Car car : carList) {
            if(car.getDistance() == maxDistance){
                winnerInOrder.add(car);
            }
        }
        return winnerInOrder;
    }

    public void executeRacing(long attemptNumber, List<Car> carList) {
        for (long attemptCurrentCount = 0; attemptCurrentCount < attemptNumber; attemptCurrentCount++) {
            attemptMoveForwardAllCars(carList);

            racingView.printRaceResult(carList);
        }
    }

    private static void attemptMoveForwardAllCars(List<Car> carList) {
        for (Car car : carList) {
            attemptMoveForwardOneCar(car);
        }
    }

    private static void attemptMoveForwardOneCar(Car car) {
        if(Randoms.pickNumberInRange(1, 8) >= 4){
            car.moveForward();
        }
    }
}
