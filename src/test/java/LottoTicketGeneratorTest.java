import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("LottoTicketGenerator 클래스")
class LottoTicketGeneratorTest {

    @Nested
    @DisplayName("generate 메소드는")
    class Describe_generate {

        @Nested
        @DisplayName("구메 개수를 넣으면")
        class Context_parameter_is_number_or_purchases {
            private final int PURCHASE_NUMBER = 3;

            @Test
            @DisplayName("구매 개수만큼 로또번호를 생성한다.")
            void it_returns_lotto_number_as_many_as_the_number_of_purchases() {
                LottoRandomNumberGenerator lottoRandomNumberGenerator = new LottoRandomNumberGenerator();
                LottoGenerator lottoGenerator = new LottoGenerator(lottoRandomNumberGenerator);
                LottoTicketGenerator lottoTicketGenerator = new LottoTicketGenerator(lottoGenerator);
                List<Lotto> lottoTicket = lottoTicketGenerator.generate(PURCHASE_NUMBER);

                assertThat(lottoTicket.size()).isEqualTo(PURCHASE_NUMBER);
            }
        }
    }
}
