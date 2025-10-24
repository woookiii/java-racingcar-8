package racingcar.view;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RacingViewTest {

    private final RacingView racingView = new RacingView();;
    private ByteArrayOutputStream captor;
    private PrintStream standardOut;

    @BeforeEach
    void init() {
        standardOut = System.out;
        captor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captor));
    }

    @AfterEach
    void printOutPut() {
        System.setOut(standardOut);
        System.out.println(output());
    }

    private String output() {
        return captor.toString().trim();
    }

    @Test
    void printExecuteResultHeader() {
        racingView.printExecuteResultHeader();
        assertThat(output()).isEqualTo("실행 결과");
    }

    @Test
    void printRaceResult_with_given_cars() {
        Car firstCar = new Car(0, "Kim", 3L);
        Car secondCar = new Car(1, "Lee", 1L);
        List<Car> cars = Arrays.asList(firstCar, secondCar);

        racingView.printRaceResult(cars);

        assertThat(output()).contains("Kim : ---", "Lee : -");
    }

    @Test
    void announceWinner_with_given_winner_cars() {
        Car firstWinner = new Car(0, "Kim", 3L);
        Car secondWinner = new Car(1, "Lee", 3L);
        List<Car> winners = Arrays.asList(firstWinner, secondWinner);

        racingView.announceWinner(winners);

        assertThat(output()).contains("최종 우승자 : Kim, Lee");
    }
}