package racingcar.movingstrategy;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import racingcar.domain.RandomNumber;

class RandomMovingStrategyTest {
    @DisplayName("값에 따라 전진, 정지가 제대로 동작하는지 테스트")
    @ParameterizedTest
    @CsvSource(value = {"0:false", "3:false", "4:true", "9:true"}, delimiter = ':')
    void testIsMovable(int number, boolean expected) {
        RandomNumber random = new RandomNumber(number);
        RandomMovingStrategy randomMovingStrategy = new RandomMovingStrategy(random);

        assertThat(randomMovingStrategy.isMovable()).isEqualTo(expected);
    }
}
