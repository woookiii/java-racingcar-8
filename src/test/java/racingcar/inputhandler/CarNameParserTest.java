package racingcar.inputhandler;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class CarNameParserTest {

    private final CarNameParser parser = new CarNameParser();

    @Test
    void parseCarNames_from_given_string() {
        String input = "Kim,Lee,Park";
        List<String> result = parser.parseCarNames(input);

        assertThat(result).containsExactly("Kim", "Lee", "Park");
    }
}