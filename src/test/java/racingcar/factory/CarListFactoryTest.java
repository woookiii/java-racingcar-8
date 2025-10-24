package racingcar.factory;

import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarListFactoryTest {

    private final CarListFactory carListFactory = new CarListFactory();

    @Test
    void buildCarList_with_given_names() {
        List<String> carNames = Arrays.asList("Kim", "Lee", "Park");

        List<Car> carList = carListFactory.buildCarList(carNames);

        assertThat(carList).hasSize(3);

        Car firstCar = carList.get(0);
        assertThat(firstCar.getName()).isEqualTo("Kim");
        assertThat(firstCar.getId()).isEqualTo(0);
        assertThat(firstCar.getDistance()).isEqualTo(0);

        Car secondCar = carList.get(1);
        assertThat(secondCar.getId()).isEqualTo(1);
        assertThat(secondCar.getName()).isEqualTo("Lee");
        assertThat(secondCar.getDistance()).isEqualTo(0);

        Car thirdCar = carList.get(2);
        assertThat(thirdCar.getId()).isEqualTo(2);
        assertThat(thirdCar.getName()).isEqualTo("Park");
        assertThat(thirdCar.getDistance()).isEqualTo(0);
    }
}