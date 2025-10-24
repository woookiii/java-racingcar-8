package racingcar.service;

import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingServiceTest {

    private final RacingService racingService = new RacingService();

    @Test
    void findRacingWinner_from_given_cars_with_distances() {
        Car firstCar = new Car(0, "A", 3L);
        Car secondCar = new Car(1, "B", 5L);
        Car thirdCar = new Car(2, "C", 5L);
        List<Car> cars = List.of(firstCar, secondCar, thirdCar);

        List<Car> winners = racingService.findRacingWinner(cars);

        assertThat(winners).containsExactly(secondCar, thirdCar);
    }

    @Test
    void executeRacing_with_given_attempt_number_and_cars() {
        long attemptNumber = 1;
        Car firstCar = new Car(0, "A", 1L);
        Car secondCar = new Car(1, "B", 0L);
        List<Car> cars = List.of(firstCar, secondCar);

        racingService.executeRacing(attemptNumber, cars);

        Long firstCarDistance = cars.get(0).getDistance();
        assertThat(firstCarDistance).isGreaterThanOrEqualTo(1L);
        assertThat(firstCarDistance).isLessThanOrEqualTo(2L);

        Long secondCarDistance = cars.get(1).getDistance();
        assertThat(secondCarDistance).isGreaterThanOrEqualTo(0L);
        assertThat(secondCarDistance).isLessThanOrEqualTo(1L);
    }
}