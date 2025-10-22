package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        List<String> cars = guideCarNamesInput();

    }

    private static List<String> guideCarNamesInput() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        List<String> cars = List.of(Console.readLine().split(","));
        Console.close();
        return cars;
    }
}
