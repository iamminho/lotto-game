import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {
    LottoRandomNumberGenerator lottoRandomNumberGenerator;

    public LottoGenerator(LottoRandomNumberGenerator lottoRandomNumberGenerator) {
        this.lottoRandomNumberGenerator = lottoRandomNumberGenerator;
    }

    private final int NUMBER_OF_LOTTO_NUMBERS = 6;
    public List<Integer> generate() {
        List<Integer> lotto = new ArrayList<>();
        while(lotto.size() < NUMBER_OF_LOTTO_NUMBERS) {
            int number = lottoRandomNumberGenerator.generate();
            validateOverlap(lotto, number);
        }
        return lotto;
    }

    private void validateOverlap(List<Integer> lotto, int number) {
        if(!lotto.contains(number)) {
            lotto.add(number);
        }
    }
}
