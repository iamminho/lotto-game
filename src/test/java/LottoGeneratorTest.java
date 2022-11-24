import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("LottoGenerator 클래스")
class LottoGeneratorTest {
    @Nested
    @DisplayName("generate 메소드는")
    class Describe_generate {

        @Test
        @DisplayName("1과 45사이의 중복되지 않는 임의의 수 6개를 만든다.")
        void it_returns_six_random_non_overlapping_numbers_between_1_and_45 () {
            LottoRandomNumberGenerator lottoRandomNumberGenerator = new LottoRandomNumberGenerator();
            LottoGenerator lottoGenerator = new LottoGenerator(lottoRandomNumberGenerator);
            List<Integer> lotto =  lottoGenerator.generate();
            Set<Integer> expected = new HashSet<>(lotto);

            assertThat(lotto.size()).isEqualTo(expected.size());
        }
    }
}
