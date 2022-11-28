import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import javax.management.ConstructorParameters;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("Rank 클래스")
class RankTest {

    @Nested
    @DisplayName("findRank 메소드는")
    class Describe_findRank {

        @Nested
        @DisplayName("맞춘 로또번호개수에 따라")
        class Context_depending_on_number_of_correct_lotto_numbers {
            private List<Integer> counts = new ArrayList<>(List.of(3,4,5,6));
            private List<Rank> expects = new ArrayList<>(List.of(Rank.FIFTH, Rank.FORTH, Rank.THIRD, Rank.FIRST));

            @Test
            @DisplayName("당첨 등수를 반환한다.")
            void it_returns_rank (){
                int i = 0;
                while(i < counts.size()) {
                    Rank rank = Rank.findRank(counts.get(i), false);
                    Rank expected = expects.get(i++);

                    assertThat(rank).isEqualTo(expected);
                }
            }
        }

        @Nested
        @DisplayName("맞춘 로또번호개수가 5개이고 보너스번호도 맞춘다면")
        class Context_number_of_correct_lotto_is_five_and_has_bonus_number {
            private int count = 5;
            private boolean hasBonusNumber = true;

            @Test
            @DisplayName("2등을 반환한다.")
            void it_returns_rank_second () {
                Rank rank = Rank.findRank(count, hasBonusNumber);
                Rank expected = Rank.SECOND;

                assertThat(rank).isEqualTo(expected);
            }
        }
    }
}
