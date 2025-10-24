package racingcar.inputhandler;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;


class InputValidatorTest {

    private final InputValidator validator = new InputValidator();

    @Test
    void validateUserInput_throws_exception_given_input_is_empty() {
        assertThatThrownBy(() -> validator.validateUserInput(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("잘못된 입력입니다.");
    }

    @Test
    void validateUserInput_not_throws_exception_given_input_is_not_empty() {
        validator.validateUserInput("Kim");
    }

    @Test
    void validateCarNames_throws_exception_given_list_is_empty() {
        assertThatThrownBy(() -> validator.validateCarNames(List.of()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("잘못된 입력입니다.");
    }

    @Test
    void validateCarNames_not_throws_exception_given_list_is_filled() {
        validator.validateCarNames(List.of("Kim", "Lee"));
    }


    @Test
    void validateCarNames_throws_exception_given_name_length_is_longer_than_car_name_max_length() {
        List<String> carNames = List.of("Kim","Lee","Alexander");
        assertThatThrownBy(() -> validator.validateCarNames(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("잘못된 입력입니다.");
    }

    @Test
    void validateCarNames_not_throws_exception_given_names_length_is_not_longer_than_car_name_max_length() {
        validator.validateCarNames(List.of("Kim", "Lee"));
    }

    @Test
    void validateAttemptNumberInput_throws_exception_given_attempt_number_input_is_not_numeric() {
        assertThatThrownBy(() -> validator.validateAttemptNumberInput("abc"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("잘못된 입력입니다.");
    }

    @Test
    void validateAttemptNumberInput_not_throws_exception_given_attempt_number_input_is_numeric() {
        validator.validateAttemptNumberInput("123");
    }
}