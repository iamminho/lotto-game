import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LottoRandomNumberGeneratorTest {
    @Test
    void it_returns (){
        LottoRandomNumberGenerator lottoRandomNumberGenerator = new LottoRandomNumberGenerator();
        int number = lottoRandomNumberGenerator.generate();
        assertThat(number)
                .isGreaterThan(0)
                .isLessThan(46);
    }

}
