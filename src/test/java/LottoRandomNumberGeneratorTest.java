import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

@DisplayName("LottoRandomNumberGenerator 클래스")
class LottoRandomNumberGeneratorTest {
    @Nested
    @DisplayName("generate 메소드는")
    class Describe_generate {
        @RepeatedTest(100)
        @DisplayName("1과 45사이의 수를 반환한다.")
        void it_returns (){
            LottoRandomNumberGenerator lottoRandomNumberGenerator = new LottoRandomNumberGenerator();
            int number = lottoRandomNumberGenerator.generate();
            assertThat(number)
                    .isGreaterThan(0)
                    .isLessThan(46);
        }
    }
}
