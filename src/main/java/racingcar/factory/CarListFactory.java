package racingcar.factory;

import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.List;

public class CarListFactory {

    public List<Car> buildCarList(List<String> carNamesInOrder) {
        final List<Car> carList = new ArrayList<>();
        for (int currentCarIndex = 0; currentCarIndex < carNamesInOrder.size(); currentCarIndex++) {
            Car car = new Car(currentCarIndex, carNamesInOrder.get(currentCarIndex));
            carList.add(car);
        }
        return carList;
    }
}
