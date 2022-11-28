import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("LottoTicket 클래스")
class LottoTicketTest {

    @Nested
    @DisplayName("getResult 메소드는")
    class Describe_getResult {

        @Nested
        @DisplayName("로또 번호와 로또 당첨번호를 비교하여")
        class Context_compare_lotto_number_to_lotto_winning_number {
            private List<Integer> numbers = new ArrayList<>(Arrays.asList(1,2,3,4,5,6));
            private int inputBonusNumber = 7;
            private List input = List.of(
                    List.of(1,2,3,4,5,6),
                    List.of(1,2,3,4,5,7),
                    List.of(1,2,3,4,5,8),
                    List.of(1,2,3,4,7,8),
                    List.of(1,2,3,8,9,10),
                    List.of(1,2,4,8,9,10),
                    List.of(11,12,13,18,19,10)
            );

            private EnumMap<Rank, Integer> expected = new EnumMap<Rank, Integer>(Rank.class);
            void expect () {
                expected.put(Rank.FIFTH, 2);
                expected.put(Rank.FORTH, 1);
                expected.put(Rank.THIRD, 1);
                expected.put(Rank.SECOND, 1);
                expected.put(Rank.FIRST, 1);
            }

            @Test
            @DisplayName("당첨 내역을 반환한다.")
            void it_returns_winning_results () {
                List<Lotto> inputTicket = (List<Lotto>) input.stream()
                        .map(ele -> new Lotto((List<Integer>) ele))
                        .collect(Collectors.toList());
                LottoTicket lottoTicket = new LottoTicket(inputTicket);
                LottoNumber lottoNumber = new LottoNumber(numbers);
                LottoBonusNumber bonusNumber = new LottoBonusNumber(inputBonusNumber, lottoNumber);
                LottoResult lottoResult = lottoTicket.getResult(lottoNumber, bonusNumber);
                expect();

                assertThat(lottoResult.getResult()).isEqualTo(expected);
            }
        }
    }
}
