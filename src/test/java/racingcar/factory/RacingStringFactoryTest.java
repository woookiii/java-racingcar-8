package racingcar.factory;

import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingStringFactoryTest {

    private final RacingStringFactory racingStringFactory = new RacingStringFactory();

    @Test
    void makeWinnerString_with_given_winners() {
        List<Car> winners = Arrays.asList(
                new Car(0, "Kim"),
                new Car(1, "Lee"),
                new Car(2, "Park")
        );
        StringBuilder sb = new StringBuilder();

        racingStringFactory.makeWinnerString(winners, sb);

        assertThat(sb.toString()).isEqualTo("Kim, Lee, Park");
    }

    @Test
    void makeResultBar_with_given_car() {
        Car car = new Car(0, "Kim", 4L);
        StringBuilder sb = new StringBuilder();

        racingStringFactory.makeResultBar(car, sb);

        assertThat(sb.toString()).isEqualTo("----");
    }
}