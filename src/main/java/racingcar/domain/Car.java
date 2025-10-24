package racingcar.domain;


public class Car {
    private final Integer id;
    private final String name;
    private Long distance;

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
