package racingcar.view;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class GuideViewTest {
    private final GuideView guideView = new GuideView();;
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

    protected final String output() {
        return captor.toString().trim();
    }

    @Test
    void guideCarName() {
        guideView.guideCarName();
        assertThat(output()).isEqualTo("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    @Test
    void guideAttemptNumber() {
        guideView.guideAttemptNumber();
        assertThat(output()).isEqualTo("시도할 횟수는 몇 회인가요?");
    }
}