package racingcar.domain;

public class Car {
    private final Integer id;
    private final String name;
    private Long distance = 0L;

    public Car(Integer id, String name) {
        this.id = id;
        this.name = name;
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
