package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;
import racingcar.view.RacingView;

import java.util.ArrayList;
import java.util.List;

import static racingcar.boundary.MoveForwardCondition.MOVE_FORWARD_MIN;
import static racingcar.boundary.RandomConstants.START_INCLUSIVE;
import static racingcar.boundary.RandomConstants.END_INCLUSIVE;

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

    private void attemptMoveForwardAllCars(List<Car> carList) {
        for (Car car : carList) {
            attemptMoveForwardOneCar(car);
        }
    }

    private void attemptMoveForwardOneCar(Car car) {
        if(Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE) >= MOVE_FORWARD_MIN){
            car.moveForward();
        }
    }
}
