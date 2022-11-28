import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class LottoTest {
    @Nested
    @DisplayName("checkLottoNumberCount 메소드는")
    class Describe_checkLottoNumberCount {

        @Nested
        @DisplayName("로또당첨번호와 로또번호를 비교해")
        class Context_compare_lotto_winning_number_and_lotto_number {
            private List<Integer> lottoWiningNumber = List.of(1,2,3,4,5,6);
            private List inputLotto = List.of(
                    List.of(1,2,3,4,5,6),
                    List.of(1,2,3,4,5,7),
                    List.of(1,2,3,4,8,9),
                    List.of(1,2,3,9,10,11),
                    List.of(1,2,11,15,17,21)
            );

            private List expects = List.of(6,5,4,3,2);

            @Test
            @DisplayName("맞춘 개수를 반환한다.")
            void it_returns_correct_number () {
                int size = inputLotto.size();
                IntStream.range(0, size)
                        .forEach(idx -> {
                            Lotto lotto = new Lotto((List<Integer>) inputLotto.get(idx));
                            int count = lotto.checkLottoNumberCount(lottoWiningNumber);

                            assertThat(count).isEqualTo(expects.get(idx));
                        });
            }
        }
    }

    @Nested
    @DisplayName("checkHasBonusNumber 메소드는")
    class Describe_checkHasBonusNumber {

        @Nested
        @DisplayName("보너스 당첨번호와 로또번호를 비교해")
        class Context_compare_bonus_number_and_lotto_number {
            private int bonusNumber = 1;
            private List inputLotto = List.of(
                    List.of(1,2,3,4,5,6),
                    List.of(2,3,4,5,7,8)
            );
            private List<Boolean> expects = new ArrayList<>(Arrays.asList(true, false));

            @Test
            @DisplayName("보너스 번호를 맞췄는지 반환한다.")
            void it_returns_has_bonus_number () {
                int size = inputLotto.size();
                IntStream.range(0,size)
                        .forEach(idx -> {
                            Lotto lotto = new Lotto((List<Integer>) inputLotto.get(idx));
                            boolean hasBonusNumber = lotto.checkHasBonusNumber(bonusNumber);

                            assertThat(hasBonusNumber).isEqualTo(expects.get(idx));
                        });
            }
        }
    }
}
