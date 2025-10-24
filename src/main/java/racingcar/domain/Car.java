package racingcar.domain;

import org.assertj.core.util.VisibleForTesting;

public class Car {
    private final Integer id;
    private final String name;
    private Long distance = 0L;

    public Car(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    @VisibleForTesting
    public Car(Integer id, String name, Long distance) {
        this.id = id;
        this.name = name;
        this.distance = distance;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Long getDistance() {
        return distance;
    }

    public void moveForward() {
        this.distance = this.distance + 1;
    }


}
